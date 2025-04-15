import java.util.*;

//this is a modded version of the Hangman example provided in Harvard's 10b course
//the main difference is that this version draws the stick man

class Hangman {
    public static void main(String[] args) {
        Bitset correctGuesses = new Bitset(128);
        Bitset lettersInWord = new Bitset(128);
        Bitset wrongGuesses = new Bitset(128);

        final int WRONG_GUESS_ROW = 12; // Moved up to reduce space
        final int WIN_OR_LOSE_ROW = 24; // Moved to bottom of screen
        final int GUESS_ROW = 14; // Moved up accordingly
        final int SECRET_WORD_ROW = 8; // Moved up
        final int HANGMAN_START_ROW = 3; // Starting row for hangman drawing
        final int HANGMAN_START_COL = 40; // Starting column for hangman drawing
        final int MAX_WRONG_GUESSES = 8; // Maximum wrong guesses before losing

        char letterGuessed = ' '; // a user's "guess" of 1 letter (initialized)
        int mistakes = 0; // # of incorrect guesses

        Scanner theScanner = new Scanner(System.in);
        System.out.print("What is the secret word? ");
        String secretWord = theScanner.nextLine().toLowerCase();
        TxtGrph.homeAndClear();

        // Draw the initial gallows
        drawGallows(HANGMAN_START_ROW, HANGMAN_START_COL);

        // Draw underscores for the secret word
        for (int i = 0; i < secretWord.length(); i++) {
            lettersInWord.include(secretWord.charAt(i));
            TxtGrph.position(SECRET_WORD_ROW, 2 * i + 1);
            System.out.print("_");
        }

        TxtGrph.position(WRONG_GUESS_ROW, 1);
        System.out.print("WRONG GUESSES: ");

        boolean gameOver = false;
        boolean playerWon = false;

        while (!gameOver) {
            TxtGrph.position(GUESS_ROW, 1);
            TxtGrph.eraseRight();
            System.out.print("TRY A NEW LETTER: ");

            // Get a valid letter the user hasn't already guessed
            String input;
            boolean validInput = false;

            do {
                TxtGrph.position(GUESS_ROW, 20); // Increased to add space after colon
                TxtGrph.eraseRight(); // Clear any previous input
                input = theScanner.nextLine().toLowerCase();

                // Check for valid input
                if (input.length() > 0) {
                    letterGuessed = input.charAt(0);
                    validInput = !(correctGuesses.union(wrongGuesses)).member(letterGuessed);
                }
            } while (!validInput);

            if (lettersInWord.member(letterGuessed)) { // the guess is correct; display every place
                                                       // it occurs in the secret word
                for (int i = 0; i < secretWord.length(); i++)
                    if (letterGuessed == secretWord.charAt(i)) {
                        TxtGrph.position(SECRET_WORD_ROW - 1, 2 * i + 1);
                        System.out.print(letterGuessed);
                    }
                TxtGrph.beep();
                correctGuesses.include(letterGuessed);

                // Check if player has won
                if (correctGuesses.equals(lettersInWord)) {
                    gameOver = true;
                    playerWon = true;
                }
            } else // the guess was INCORRECT
            {
                wrongGuesses.include(letterGuessed);
                TxtGrph.position(WRONG_GUESS_ROW, 2 * mistakes + 16);
                System.out.print(letterGuessed + " "); // Added space after wrong guess
                mistakes++;

                // Draw the next part of the hangman
                updateHangman(mistakes, HANGMAN_START_ROW, HANGMAN_START_COL);

                // Check if player has lost
                if (mistakes >= MAX_WRONG_GUESSES) {
                    gameOver = true;
                    playerWon = false;
                }
            }
        }

        TxtGrph.position(WIN_OR_LOSE_ROW, 1);
        if (!playerWon)
            System.out.println("YOU LOSE. The word was..." + secretWord);
        else
            System.out.println("YOU WIN");
    }

    // Draw the initial gallows
    public static void drawGallows(int startRow, int startCol) {
        // Draw the top beam
        TxtGrph.position(startRow, startCol + 5);
        System.out.print("_________");

        // Draw the vertical pole
        for (int i = 1; i < 7; i++) {
            TxtGrph.position(startRow + i, startCol + 5);
            System.out.print("|");
        }

        // Draw the rope
        TxtGrph.position(startRow + 1, startCol + 13);
        System.out.print("|");

        // Draw the base
        TxtGrph.position(startRow + 7, startCol);
        System.out.print("__________________");
    }

    // Update hangman drawing based on number of mistakes
    public static void updateHangman(int mistakes, int startRow, int startCol) {
        switch (mistakes) {
            case 1: // Head
                TxtGrph.position(startRow + 2, startCol + 13);
                System.out.print("O");
                break;
            case 2: // Body
                TxtGrph.position(startRow + 3, startCol + 13);
                System.out.print("|");
                break;
            case 3: // Left arm
                TxtGrph.position(startRow + 3, startCol + 12);
                System.out.print("/");
                break;
            case 4: // Right arm
                TxtGrph.position(startRow + 3, startCol + 14);
                System.out.print("\\");
                break;
            case 5: // Left leg
                TxtGrph.position(startRow + 4, startCol + 12);
                System.out.print("/");
                break;
            case 6: // Right leg
                TxtGrph.position(startRow + 4, startCol + 14);
                System.out.print("\\");
                break;
            case 7: // Left foot
                TxtGrph.position(startRow + 5, startCol + 11);
                System.out.print("_");
                break;
            case 8: // Right foot
                TxtGrph.position(startRow + 5, startCol + 15);
                System.out.print("_");
                break;
        }
    }
}
