# Hangman-Game

(*UPDATE*)
The original problem with the inputted word(s) for the guesser to guess was visable in the console, to combat this I simply added a for loop that iterates 50 times printing an empty string to create the space between the inputted word(s) and the game itself.
This program is a text-based implementation of the classic game of Hangman in Java. Players guess letters to uncover a secret word within a limited number of attempts.

*Running the Game*
Clone or download the HangmanGame.java file to your local machine.
Open the HangmanGame.java file in a text editor or IDE.
Compile and run the HangmanGame.java file using the Java compiler and Virtual Machine (JVM) of your choice.
Follow the prompts to enter the number of words to guess and the words themselves.
Enter a letter to make guesses and play the game.
Continue guessing letters until you either win by guessing the correct word or lose by running out of attempts.

*Features*
Enter a word for the opposing player to guess
Displays a partially guessed word with underscores representing unguessed letters.
Allows players to enter letter guesses.
Tracks and displays guessed letters and remaining attempts.
Determines if a guessed letter is correct or incorrect.
Ends the game when the player wins by guessing the correct word or loses by running out of attempts.
Displays appropriate messages for winning or losing the game.

*Improvements* 
Add a function where if the guesser is confident in the answer or just wants to outright guess the word they can, as of right now if you were to guess a word it takes the letter at index 0 as the guess not the word itself.
