import java.util.Scanner;

public class HangmanGame {
    //Secret word to guess
    private final String secretWord;
    //Partially guessed word
    private final StringBuilder guessedWord;
    //Number of remaining attempts
    private int remainingAttempts;
    //Guessed letters
    private final StringBuilder guessedLetters;
    //Game won
    private boolean gameWon;
    //Game lost
    private boolean gameLost;

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
        for(int i = 0; i < 50; i++){
            System.out.println("#");
        }
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
            System.out.println("Guessed letters: " + guessedLetters);
            System.out.println("Current word: " + guessedWord);
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
        //Consume the newline character
        scanner.nextLine();
        String[] words = new String[numWords];
        for (int i = 0; i < numWords; i++) {
            System.out.print("Enter word #" + (i + 1) + ": ");
            words[i] = scanner.nextLine().toLowerCase();
        }
        HangmanGame hangmanGame = new HangmanGame(words);
        hangmanGame.playGame();
    }
}
