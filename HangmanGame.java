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

    public HangmanGame(String word) {
        secretWord = word.toLowerCase();
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
        //Prints space between the inputted word and the beginning of the game so the guesser can't see the answer in the console
        for(int i = 0; i < 50; i++){
            System.out.println("");
        }
        System.out.println("Welcome to Hangman!\n" + "____\n" + "|  |\n" + "|  |\n" + "|\n" + "|\n" + "|\n" + "|\n" + "-------");
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
                System.out.println("Incorrect! Remaining attempts: " + remainingAttempts + "\n");
                //Display the hangman figure based on the number of remaining attempts.
                //Each case corresponds to a specific number of remaining attempts and
                //prints the appropriate hangman figure.
                //*Disclaimer*
                //Could be an enhanced switch statement, however to account for older versions of Java I went for a traditional case and break statement
                switch (remainingAttempts) {
                    case 6:
                        System.out.println("____\n" + "|  |\n" + "|  |\n" + "|\n" + "|\n" + "|\n" + "|\n" + "-------");
                        break;
                    case 5:
                        System.out.println("____\n" + "|  |\n" + "|  |\n" + "|  o\n" + "|\n" + "|\n" + "|\n" + "-------");
                        break;
                    case 4:
                        System.out.println("____\n" + "|  |\n" + "|  |\n" + "|  o\n" + "|  |\n" + "|\n" + "|\n" + "-------");
                        break;
                    case 3:
                        System.out.println("____\n" + "|  |\n" + "|  |\n" + "|  o\n" + "|  |\\\n" + "|\n" + "|\n" + "-------");
                        break;
                    case 2:
                        System.out.println("____\n" + "|  |\n" + "|  |\n" + "|  o\n" + "| /|\\\n" + "|\n" + "|\n" + "-------");
                        break;
                    case 1:
                        System.out.println("____\n" + "|  |\n" + "|  |\n" + "|  o\n" + "| /|\\\n" + "| /\n" + "|\n" + "-------");
                        break;
                    case 0:
                        System.out.println("____\n" + "|  |\n" + "|  |\n" + "|  X\n" + "| /|\\\n" + "| / \\\n" + "|\n" + "-------");
                        break;
                }
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
        System.out.print("Enter the word to guess: ");
        String word = scanner.nextLine().toLowerCase();

        HangmanGame hangmanGame = new HangmanGame(word);
        hangmanGame.playGame();
    }
}