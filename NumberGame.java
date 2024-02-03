import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempt=10;
        int TotalAttempts = 0;
        int rounds = 0;

        System.out.println("WELCOME TO NUMBER GUESSING GAME::");
        while (true) {
            int NumberGenerated = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempt =0;

            System.out.println("The number should be between"+ lowerBound + "and" + upperBound);
            System.out.println("Round " + (rounds+1));

            while(attempt < maxAttempt)
            {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter your guess::");
                int guess = sc.nextInt();
                attempt++;

                if (NumberGenerated == guess)
                {
                    System.out.println("Congratulations!! Your guess is correct for number:"+ NumberGenerated);
                    TotalAttempts += attempt;
                    break;
                }
                else if (NumberGenerated > guess)
                {
                    System.out.println("Number is too low.Please try again!!");
                } else
                {
                    System.out.println("Number is too high.Please try again!!");
                }


            }


            if (attempt == maxAttempt)
            {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + NumberGenerated);
            }

            rounds++;
            System.out.println("Rounds won ::"+rounds);
            System.out.print("Do you want to play again? (yes/no): ");
            Scanner sc =new Scanner(System.in);
            String playAgain = sc.next().toLowerCase();
            if (!playAgain.equals("yes"))
            {
                break;
            }
        }

        System.out.println("\nGame Over!!. Your total score is based on the total attempts: " + TotalAttempts);
        System.out.println("Thank you for playing!");
    }
}



