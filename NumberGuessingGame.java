import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void playGame(int min, int max, int maxAttempts) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int randomNumber = random.nextInt(max - min + 1) + min;
        int attempts = 0;
        boolean hasWon = false;

        System.out.println("Guess a number between " + min + " and " + max + ":");

        while (attempts < maxAttempts) {
            int guess = scanner.nextInt();
            attempts++;

            if (guess == randomNumber) {
                hasWon = true;
                break;
            } else if (guess > randomNumber) {
                System.out.println("Too high! Try again:");
            } else {
                System.out.println("Too low! Try again:");
            }

            System.out.println("Attempts left: " + (maxAttempts - attempts));
        }

        if (hasWon) {
            System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
        } else {
            System.out.println("You've used all " + maxAttempts + " attempts. The correct number was: " + randomNumber);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int roundsWon = 0;
        int rounds = 0;
        boolean playAgain;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            rounds++;
            playGame(1, 100, 5); // Range 1-100, 5 attempts

            System.out.println("Would you like to play again? (yes/no)");
            playAgain = scanner.next().equalsIgnoreCase("yes");

            if (playAgain) {
                System.out.println("Starting a new round...");
            }

        } while (playAgain);

        System.out.println("Game Over! You played " + rounds + " round(s).");
    }
}
