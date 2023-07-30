import java.util.Scanner;

public class Hangman {
    private static final String[] WORDS = {"programming", "java", "hangman", "computer", "game", "developer"};
    private static final int MAX_ATTEMPTS = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String wordToGuess = selectRandomWord(WORDS).toLowerCase();
        char[] guessedLetters = new char[wordToGuess.length()];
        int attempts = 0;

        for (int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = '_';
        }

        System.out.println("Welcome to Hangman!");
        System.out.println("Guess the word: " + new String(guessedLetters));

        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            boolean found = false;
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guess) {
                    guessedLetters[i] = guess;
                    found = true;
                }
            }

            if (!found) {
                attempts++;
            }

            System.out.println("Attempts left: " + (MAX_ATTEMPTS - attempts));
            System.out.println("Current status: " + new String(guessedLetters));

            if (wordToGuess.equals(new String(guessedLetters))) {
                System.out.println("Congratulations! You guessed the word!");
                break;
            }
        }

        if (attempts >= MAX_ATTEMPTS) {
            System.out.println("Sorry, you ran out of attempts. The word was: " + wordToGuess);
        }

        scanner.close();
    }

    private static String selectRandomWord(String[] words) {
        int randomIndex = (int) (Math.random() * words.length);
        return words[randomIndex];
    }
}
