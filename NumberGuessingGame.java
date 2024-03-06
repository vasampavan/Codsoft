import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int maxRange = 100;
        int secretNumber;
        int maxAttempts = 10;
        int roundsPlayed = 0;
        int totalAttempts = 0;
        int roundsWon = 0;

        do {
            // Step 1: Generate a random number within the specified range
            secretNumber = random.nextInt(maxRange) + 1;

            // Additional details
            int attempts = 0;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("Guess the number between 1 and 100.");

            while (true) {
                // Step 2: Prompt the user to enter their guess
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                // Step 3: Compare the user's guess and provide feedback
                if (userGuess == secretNumber) {
                    System.out.println("Congratulations! You guessed the correct number: " + secretNumber);
                    roundsWon++;
                    break;
                } else if (userGuess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                // Update additional details
                attempts++;

                // Step 5: Limit the number of attempts
                if (attempts == maxAttempts) {
                    System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + secretNumber);
                    break;
                }
            }

            // Additional details
            totalAttempts += attempts;

            // Step 6: Option for multiple rounds
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                System.out.println("Game Over! You played " + roundsPlayed + " rounds and won " + roundsWon + " rounds.");
                System.out.println("Your total score is based on " + totalAttempts + " total attempts.");
                break;
            } else {
                System.out.println("\nStarting a new round...\n");
                roundsPlayed++;
            }

        } while (true);

        scanner.close();
    }
}
