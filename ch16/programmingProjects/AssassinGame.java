import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AssassinGame {
	private static class Player {
		private String name;
		private Player next;

		public Player(String name) {
			this.name = name;
			this.next = null;
		}

		public String toString() {
			return name;
		}
	}

	private Player killRingHead;

	private Player graveyardHead;

	public AssassinGame(String filename) throws FileNotFoundException {
		List<String> players = new ArrayList<>();
		Scanner fileScanner = new Scanner(new File(filename));

		while (fileScanner.hasNextLine()) {
			String name = fileScanner.nextLine().trim();
			if (!name.isEmpty()) {
				players.add(name);
			}
		}

		fileScanner.close();

		if (players.size() < 2) {
			throw new IllegalArgumentException("At least two players are required");
		}

		Collections.shuffle(players);

		buildKillRing(players);
	}

	private void buildKillRing(List<String> players) {
		if (players.isEmpty()) {
			return;
		}

		killRingHead = new Player(players.get(0));

		Player current = killRingHead;
		for (int i = 1; i < players.size(); i++) {
			current.next = new Player(players.get(i));
			current = current.next;
		}

		current.next = killRingHead;
	}

	public void printKillRing() {
		if (killRingHead == null) {
			System.out.println("The kill ring is empty");
			return;
		}

		System.out.println("Current kill ring:");

		Player current = killRingHead;
		do {
			System.out.println(" " + current.name + " is stalking " + current.next.name);
			current = current.next;
		} while (current != killRingHead);
	}

	public void printGraveyard() {
		if (graveyardHead == null) {
			System.out.println("\nThe graveyard is empty");
			return;
		}

		System.out.println("\nCurrent graveyard:");

		Player current = graveyardHead;
		while (current != null) {
			Player killer = findKiller(current.name);
			String killerName = (killer != null) ? killer.name : "unknown";
			System.out.println(" " + current.name + " was killed by " + killerName);
			current = current.next;
		}
	}

	private Player findKiller(String name) {
		Player current = killRingHead;

		if (current == null) {
			return null;
		}

		do {
			if (current.next != null && current.next.name.equalsIgnoreCase(name)) {
				return current;
			}
			current = current.next;
		} while (current != killRingHead);

		return null;
	}

	public boolean kill(String name) {
		if (killRingHead == null) {
			return false;
		}

		if (killRingHead.next == killRingHead) {
			if (killRingHead.name.equalsIgnoreCase(name)) {
				Player deadPlayer = new Player(killRingHead.name);
				deadPlayer.next = graveyardHead;
				graveyardHead = deadPlayer;

				killRingHead = null;
				return true;
			}
			return false;
		}

		Player current = killRingHead;
		Player prev = null;

		do {
			if (current.next.name.equalsIgnoreCase(name)) {
				Player deadPlayer = current.next;
				current.next = deadPlayer.next;

				if (deadPlayer == killRingHead) {
					killRingHead = deadPlayer.next;
				}

				Player graveyardPlayer = new Player(deadPlayer.name);
				graveyardPlayer.next = graveyardHead;
				graveyardHead = graveyardPlayer;

				return true;
			}

			prev = current;
			current = current.next;
		} while (current != killRingHead);
		return false;
	}

	public boolean isGameOver() {
		return killRingHead == null || killRingHead.next == killRingHead;
	}

	public String getWinner() {
		if (!isGameOver() || killRingHead == null) {
			return null;
		}
		return killRingHead.name;
	}

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);

		System.out.print("Enter player list file: ");
		String filename = console.nextLine();

		try {
			AssassinGame game = new AssassinGame(filename);

			while (!game.isGameOver()) {
				game.printKillRing();
				game.printGraveyard();

				System.out.print("\nEnter name of player to kill (or press Enter to quit): ");

				String name = console.nextLine();

				if (name.isEmpty()) {
					System.out.println("Game aborted.");
					break;
				}

				if (game.kill(name)) {
					System.out.println(name + " has been killed!");
				} else {
					System.out.println("Player not found in the kill ring.");
				}

				System.out.println();
			}

			if (game.isGameOver() && game.getWinner() != null) {
				System.out.println("Game over!");
				System.out.println(game.getWinner() + " wins!");
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + filename);
		} catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
		}

		console.close();
	}
}
