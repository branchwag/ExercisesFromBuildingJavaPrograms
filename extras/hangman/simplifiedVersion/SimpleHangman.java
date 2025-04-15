import java.util.*;

class SimpleHangman {
    // ASCII art for hangman states (0-8 mistakes)
    private static final String[] HANGMAN_STATES = {
            "  +---+\n  |   |\n      |\n      |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n      |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n  |   |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|   |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|\\  |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|\\  |\n /    |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|\\  |\n / \\  |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|\\  |\n / \\  |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|\\  |\n / \\  |\n      |\n========="
    };

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Set<Character> correctGuesses = new HashSet<>();
        Set<Character> wrongGuesses = new HashSet<>();

        System.out.print("What is the secret word? ");
        String secretWord = keyboard.nextLine().toLowerCase();

        // Clear the console (may work differently across operating systems)
        System.out.print("\033[H\033[2J");
        System.out.flush();

        boolean gameOver = false;
        boolean playerWon = false;
        int mistakes = 0;

        while (!gameOver) {
            // Print current game state
            System.out.println("\n" + HANGMAN_STATES[mistakes]);
            System.out.println();

            // Print word with correctly guessed letters
            System.out.print("Word: ");
            boolean allLettersGuessed = true;
            for (char c : secretWord.toCharArray()) {
                if (correctGuesses.contains(c)) {
                    System.out.print(c + " ");
                } else {
                    System.out.print("_ ");
                    allLettersGuessed = false;
                }
            }
            System.out.println();

            // Check for win
            if (allLettersGuessed) {
                gameOver = true;
                playerWon = true;
                continue;
            }

            // Print wrong guesses
            System.out.print("Wrong guesses: ");
            for (char c : wrongGuesses) {
                System.out.print(c + " ");
            }
            System.out.println();

            // Get user's guess
            System.out.print("Try a new letter: ");
            String input = keyboard.nextLine().toLowerCase();

            if (input.length() == 0) {
                continue;
            }

            char guess = input.charAt(0);

            // Check if letter was already guessed
            if (correctGuesses.contains(guess) || wrongGuesses.contains(guess)) {
                System.out.println("You already guessed that letter. Try again.");
                continue;
            }

            // Check if guess is correct
            if (secretWord.indexOf(guess) >= 0) {
                correctGuesses.add(guess);
                System.out.println("Good guess!");
            } else {
                wrongGuesses.add(guess);
                mistakes++;
                System.out.println("Wrong guess!");

                // Check for loss
                if (mistakes >= 6) { // We only have 7 states (0-6), so lose on 6 mistakes
                    gameOver = true;
                    playerWon = false;
                }
            }

            // Add a separator line
            System.out.println("\n--------------------------------------------------");
        }

        // Game over - show final state
        System.out.println("\n" + HANGMAN_STATES[mistakes]);
        System.out.println();

        // Print final word state
        System.out.print("Word: ");
        for (char c : secretWord.toCharArray()) {
            System.out.print(c + " ");
        }
        System.out.println();

        // Print result message
        if (playerWon) {
            System.out.println("\nYOU WIN!");
        } else {
            System.out.println("\nYOU LOSE! The word was: " + secretWord);
        }
    }
}
