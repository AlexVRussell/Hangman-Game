# Hangman-Game

*UPDATE*

- Added a feature that displays the visual representation of the iconic Hangman figure using the traditional syntax for a switch statement with 'case' and 'break' statements instead of the arrow syntax (->). I originally used the arrow syntax, but then shortly realized that it was added in Java 14 and therefore wouldn't be supported on all versions of Java.

*Quick Description*

- This program is a text-based implementation of the classic game of Hangman in Java. Players guess letters to uncover a secret word within a limited number of attempts.

*How to Run*

- Clone or download the HangmanGame.java file to your local machine.
- Open the HangmanGame.java file in a text editor or IDE and compile.
- Follow the prompts to enter the number of words to guess and the words themselves.
- Enjoy this fun side project!

*Game Features*

- Enter a word for the opposing player to guess.
- After the player who choses a word has inputted the word to guess, a for loop printing an empty string that iterates 25 times to create space so the guesser cannot see the secret word.
- Displays the length of the word appended with underscores
- Allows players to enter letter guesses.
- Tracks and displays guessed letters and remaining attempts.
- Determines if a guessed letter is correct or incorrect and displays the appropiate hangman figure.
- Ends the game when the player wins by guessing the correct word or loses by running out of attempts, printing the appropiate message.

*Possible Improvements* 

- Add a function where you can guess the entire word, as of right now if you were to guess a word it takes the letter at index 0 as the guess not the word itself.
If you have any improvements to this please reach out I'd love to improve my code and learn/grow to become better. Thanks.
