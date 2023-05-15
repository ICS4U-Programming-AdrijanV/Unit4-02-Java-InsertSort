// Importing
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
* The program uses insert sort.
*
* @author  Adrijan Vranjkovic
* @version 1.0
* @since   2023-05-15
*/

public final class InsertSort {

    /**
    * For style checker.
    *
    * @exception IllegalStateException Utility class.
    * @see IllegalStateException
    */
    private InsertSort() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * This is the main method.
    *
    * @param args Unused
    */
    public static void main(String[] args) {

        // Create a list to hold the input arrays
        final ArrayList<int[]> inputList = new ArrayList<>();

        try {
            // Create input/output file and scanner
            final File input = new File("input.txt");
            final Scanner scanInput = new Scanner(input);
            final FileWriter output = new FileWriter("output.txt");

            while (scanInput.hasNextLine()) {
                // Cut off any trailing white spaces
                final String line = scanInput.nextLine().trim();

                // Skip any blank lines
                if (!line.isEmpty()) {
                    // Parse the input line and store the array
                    final int[] arrOfInt = parseInputLine(line);

                    if (arrOfInt != null) {
                        inputList.add(arrOfInt);
                    } else {
                        output.write("Invalid input\n");
                    }
                }
            }

            // Call insertion sort
            for (int[] arrOfInt : inputList) {
                insertionSort(arrOfInt);
                output.write(Arrays.toString(arrOfInt) + "\n");
            }

            // Close output
            output.close();

        } catch (IOException err) {
            // Display error
            System.err.println("Error: " + err.getMessage());
        }
    }

    /**
    * This function uses insert sort.
    *
    * @param array *
    */
    private static void insertionSort(int[] array) {
        final int n = array.length;
        for (int i = 1; i < n; i++) {
            final int currentNum = array[i];
            final int j = i - 1;
            while (j >= 0 && array[j] > currentNum) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = currentNum;
        }
    }

    /**
    * This function prepares the input for the sorting.
    *
    * @param line *
    * @return arrOfInt
    */
    private static int[] parseInputLine(String line) {
        final String[] numStrings = line.split(" ");
        final int[] arrOfInt = new int[numStrings.length];
        for (int i = 0; i < numStrings.length; i++) {
            try {
                arrOfInt[i] = Integer.parseInt(numStrings[i]);
            } catch (NumberFormatException fnfex) {
                // Return null if it's not an integer
                return null;
            }
        }
        return arrOfInt;
    }
}
