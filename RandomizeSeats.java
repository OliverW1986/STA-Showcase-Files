import java.util.Scanner;

public class RandomizeSeats {
    private static final int MAX_TEAMS = 7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the seat randomizer! Please input your team number and your current row");

        int teamNumber = getUserInput(scanner, "Enter your team number: ");
        int rowNumber = getUserInput(scanner, "Enter your row: ");

        int endingTeamNumber = calculateEndingTeamNumber(teamNumber, rowNumber);

        System.out.println("Ending Team Number: " + endingTeamNumber);
        scanner.close();
    }

    /**
     * Gets a valid integer from the user between 1 and 7
     * 
     * @param scanner Scanner object to get user input
     * @param prompt  String to prompt the user for input
     * @return int between 1 and 7
     */
    private static int getUserInput(Scanner scanner, String prompt) {
        int input;

        System.out.println(prompt);
        do {
            System.out.println("Please enter a number between 1 and " + MAX_TEAMS);
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // This clears the invalid input
            }
            input = scanner.nextInt();
        } while (input <= 0 || input > MAX_TEAMS);
        return input;
    }

    /**
     * Calculate the ending team number based on the current team number and row
     * number
     * If the result is greater than 7, it will loop back around to 1
     * 
     * @param teamNumber Current team number
     * @param rowNumber  Current row number
     * @return Ending team number
     */
    private static int calculateEndingTeamNumber(int teamNumber, int rowNumber) {
        int result = teamNumber + rowNumber;
        if (result <= MAX_TEAMS)
            return result;
        result %= MAX_TEAMS;
        return result;

    }
}