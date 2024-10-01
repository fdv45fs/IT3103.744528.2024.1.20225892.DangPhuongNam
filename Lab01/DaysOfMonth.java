import java.util.Scanner;

public class DaysOfMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year;
        int month;

        System.out.print("Enter a year: ");
        year = scanner.nextInt();
        System.out.print("Enter the month: ");
        String monthInput = scanner.next().trim();
        month = getMonthFromInput(monthInput);
        if (month == -1) {
            System.out.println("Invalid");
        }

        boolean isLeapYear = isLeapYear(year);

        int days = getDaysInMonth(month, isLeapYear);
        System.out.println("Dang Phuong Nam 20225892\nThere are " + days + " days.");
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public static int getDaysInMonth(int month, boolean isLeapYear) {
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> isLeapYear ? 29 : 28;
            default -> -1;
        };
    }

    public static int getMonthFromInput(String monthInput) {
        return switch (monthInput.toLowerCase()) {
            case "january", "jan.", "jan", "1" -> 1;
            case "february", "feb.", "feb", "2" -> 2;
            case "march", "mar.", "mar", "3" -> 3;
            case "april", "apr.", "apr", "4" -> 4;
            case "may", "5" -> 5;
            case "june", "jun", "6" -> 6;
            case "july", "jul", "7" -> 7;
            case "august", "aug.", "aug", "8" -> 8;
            case "september", "sept.", "sep", "9" -> 9;
            case "october", "oct.", "oct", "10" -> 10;
            case "november", "nov.", "nov", "11" -> 11;
            case "december", "dec.", "dec", "12" -> 12;
            default -> -1; // invalid
        };
    }
}
