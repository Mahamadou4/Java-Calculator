import java.util.Scanner;

public class MyCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the calculator mode: Standard/Scientific?");
            String mode = scanner.nextLine().trim().toLowerCase();

            if (mode.equals("standard")) {
                System.out.println("The calculator will operate in standard mode.");
                System.out.print("Enter '+' for addition, '-' for subtractions, '*' for multiplication, '/' for division: ");
            } else if (mode.equals("scientific")) {
                System.out.println("The calculator will operate in scientific mode.");
                System.out.print("Enter '+' for addition, '-' for subtractions, '*' for multiplication, '/' for division, 'sin' for sin x, 'cos' for cos x, 'tan' for tan x: ");
            } else {
                System.out.println("Invalid mode. Please enter 'Standard' or 'Scientific'.");
                continue;
            }

            char operator = scanner.nextLine().charAt(0);

            if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                System.out.print("How many numbers do you want to " + (operator == '+' ? "add" : (operator == '-' ? "subtract" : (operator == '*' ? "multiply" : "divide"))) + "? ");
            } else if (mode.equals("scientific") && (operator == 's' || operator == 'c' || operator == 't')) {
                System.out.print("calculate with?");
            } else {
                System.out.println("perform an invalid operation?");
                continue;
            }

            int numValues = scanner.nextInt();
            scanner.nextLine();

            double result = 0.0;

            System.out.println("Enter " + numValues + " numbers:");

            for (int i = 1; i <= numValues; i++) {
                System.out.print("Number " + i + ": ");
                double value = scanner.nextDouble();
                scanner.nextLine();

                if (operator == '+') {
                    result += value;
                } else if (operator == '-') {
                    if (i == 1) {
                        result = value;
                    } else {
                        result -= value;
                    }
                } else if (operator == '*') {
                    if (i == 1) {
                        result = value;
                    } else {
                        result *= value;
                    }
                } else if (operator == '/') {
                    if (i == 1) {
                        result = value;
                    } else if (value == 0) {
                        System.out.println("Division by zero is not allowed.");
                        return;
                    } else {
                        result /= value;
                    }
                } else if (mode.equals("scientific")) {
                    if (operator == 's') {
                        result = Math.sin(value);
                    } else if (operator == 'c') {
                        result = Math.cos(value);
                    } else if (operator == 't') {
                        result = Math.tan(value);
                    }
                }
            }

            System.out.println("Result: " + result);

            System.out.print("Do you want to start over? (Y/N) ");
            String startOver = scanner.nextLine();
            if (!startOver.equalsIgnoreCase("Y")) {
                System.out.println("Goodbye.");
                break;
            }
        }

        scanner.close();
    }
}

