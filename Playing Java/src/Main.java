import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int correctNumber = (int) (Math.random() * 101);
        //System.out.println(correctNumber);

        int guessedNumber;
        int startInterval = 0;
        int endInterval = 100;
        int numberOfTurns = 0;
        do {
            System.out.println("Number of turns : " + numberOfTurns);
            guessedNumber = getNum(startInterval, endInterval);

            if (guessedNumber == correctNumber) {
                System.out.println("You won");
                System.out.println("Number of turns : " + numberOfTurns);
            } else if (guessedNumber < correctNumber) {
                startInterval = guessedNumber;
                System.out.println("Your number is incorrect , you need to enter bigger number choose from interval (" + startInterval + " - " + endInterval + " )");
            } else if (guessedNumber > correctNumber) {
                endInterval = guessedNumber;
                System.out.println("Your number is incorrect , you need to enter smaller number choose from interval (" + startInterval + " - " + endInterval + " )");
            }
            ++numberOfTurns;
        } while (guessedNumber != correctNumber);

    }

    public static int getNum(int startInterval, int endInterval) {
        Scanner sc = new Scanner(System.in);
        int number;
        do {
            System.out.println("=========================================");
            System.out.println("Please guess a positive number ( " + startInterval + " - " + endInterval + " ) ");
            while (!sc.hasNextInt()) {
                System.out.println("That's not a number!");
                sc.next(); // this is important!//
            }
            number = sc.nextInt();
        } while (number <= startInterval || number > endInterval);
        //System.out.println("Your number is " + number);
        return number;
    }
}
