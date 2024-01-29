package demo;
import java.util.Scanner;
public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first date:");
        int day1 = getValidDay(scanner, "Day");
        int month1 = getValidMonth(scanner, "Month");
        int year1 = getValidYear(scanner, "Year");

        // Input for second date
        System.out.println("Enter the second date:");
        int day2 = getValidDay(scanner, "Day");
        int month2 = getValidMonth(scanner, "Month");
        int year2 = getValidYear(scanner, "Year");

        // Calculate the difference in days
        int differenceInDays = calculateDifferenceInDays(day1, month1, year1, day2, month2, year2);

        System.out.println("The difference in days between the two dates is: " + differenceInDays + " days");

        scanner.close();
    }

    // Function to get a valid day (1-31)
    private static int getValidDay(Scanner scanner, String type) {
        int day;
        do {
            System.out.print("Enter " + type + " (1-31): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next();
            }
            day = scanner.nextInt();
        } while (day < 1 || day > 31);
        return day;
    }

    // Function to get a valid month (1-12)
    private static int getValidMonth(Scanner scanner, String type) {
        int month;
        do {
            System.out.print("Enter " + type + " (1-12): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next();
            }
            month = scanner.nextInt();
        } while (month < 1 || month > 12);
        return month;
    }

    // Function to get a valid year
    private static int getValidYear(Scanner scanner, String type) {
        System.out.print("Enter " + type + ": ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    // Function to calculate the difference in days between two dates
    private static int calculateDifferenceInDays(int day1, int month1, int year1, int day2, int month2, int year2) {
        int daysInYear1 = getDaysInYear(year1);
        int daysInYear2 = getDaysInYear(year2);

        int totalDays1 = getDaysFromStart(day1, month1, year1, daysInYear1);
        int totalDays2 = getDaysFromStart(day2, month2, year2, daysInYear2);

        return Math.abs(totalDays2 - totalDays1)+1;
    }

    // Function to get the number of days in a year
    private static int getDaysInYear(int year) {
        return isLeapYear(year) ? 366 : 365;
    }

    // Function to check if a year is a leap year
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }

    // Function to calculate the total days from the start of the year
    private static int getDaysFromStart(int day, int month, int year, int daysInYear) {
        for (int i = 1; i < month; i++) {
            day += getDaysInMonth(i, year);
        }
        return day;
    }

    // Function to get the number of days in a month
    private static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 4:
            	return 30;
            case 6:
            	return 30;
            case 9:
            	return 30;
            case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return 31;
        }
    }
}




