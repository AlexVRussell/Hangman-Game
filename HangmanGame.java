import java.util.Scanner;
public class HangmanGame {
    private String secretWord; // Secret word to guess
    private StringBuilder guessedWord; // Partially guessed word
    private int remainingAttempts; // Number of remaining attempts
    private StringBuilder guessedLetters; // Guessed letters
    private boolean gameWon; // Game won flag
    private boolean gameLost; // Game lost flag

    public HangmanGame(String[] words) {
        secretWord = words[(int) (Math.random() * words.length)];
        guessedWord = new StringBuilder();
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == ' ') {
                guessedWord.append(' ');
            } else {
                guessedWord.append('_');
            }
        }
        remainingAttempts = 6;
        guessedLetters = new StringBuilder();
        gameWon = false;
        gameLost = false;
    }

    public void playGame() {
        System.out.println("Welcome to Hangman!");
        System.out.println("Guess the word: " + guessedWord.toString());
        Scanner scanner = new Scanner(System.in);
        while (!gameWon && !gameLost) {
            System.out.print("Enter a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);
            if (guessedLetters.toString().contains(String.valueOf(guess))) {
                System.out.println("You already guessed that letter. Try again!");
                continue;
            }
            guessedLetters.append(guess);
            if (secretWord.contains(String.valueOf(guess))) {
                for (int i = 0; i < secretWord.length(); i++) {
                    if (secretWord.charAt(i) == guess) {
                        guessedWord.setCharAt(i, guess);
                    }
                }
                System.out.println("Correct!");
            } else {
                remainingAttempts--;
                System.out.println("Incorrect! Remaining attempts: " + remainingAttempts);
            }
            System.out.println("Guessed letters: " + guessedLetters.toString());
            System.out.println("Current word: " + guessedWord.toString());
            if (guessedWord.toString().equals(secretWord)) {
                gameWon = true;
            } else if (remainingAttempts == 0) {
                gameLost = true;
            }
        }
        if (gameWon) {
            System.out.println("Congratulations! You won! The word was: " + secretWord);
        } else if (gameLost) {
            System.out.println("Game over! You lost! The word was: " + secretWord);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of words to guess: ");
        int numWords = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        String[] words = new String[numWords];
        for (int i = 0; i < numWords; i++) {
            System.out.print("Enter word #" + (i + 1) + ": ");
            words[i] = scanner.nextLine().toLowerCase();
        }
        HangmanGame hangmanGame = new HangmanGame(words);
        hangmanGame.playGame();
    }
}