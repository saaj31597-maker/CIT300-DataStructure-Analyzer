// Author / Responsibility: Member 1 - S.M. Sajith (23DA2-0875)
import java.util.Scanner;

/**
 * Shared console input helper with validation.
 * Every menu uses these methods so that bad input never crashes the program.
 */
public class InputHelper {
    private static final Scanner SC = new Scanner(System.in);

    /** Reads an integer between min and max (inclusive); repeats until valid. */
    public static int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            if (!SC.hasNextLine()) {
                System.out.println("\nInput closed. Exiting program.");
                System.exit(0);
            }
            String line = SC.nextLine().trim();
            try {
                int value = Integer.parseInt(line);
                if (value < min || value > max) {
                    System.out.println("  ! Please enter a number between " + min + " and " + max + ".");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("  ! Invalid input. Please enter a whole number.");
            }
        }
    }

    /** Reads any integer value. */
    public static int readInt(String prompt) {
        return readInt(prompt, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /** Reads a non-empty text value (trimmed). */
    public static String readText(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (!SC.hasNextLine()) {
                System.out.println("\nInput closed. Exiting program.");
                System.exit(0);
            }
            String line = SC.nextLine().trim();
            if (!line.isEmpty()) {
                return line;
            }
            System.out.println("  ! Input cannot be empty.");
        }
    }

    /** Waits for the user to press Enter. */
    public static void pause() {
        System.out.print("\nPress Enter to continue...");
        if (SC.hasNextLine()) {
            SC.nextLine();
        }
    }
}
