// Iterate through the array from index 1 to N, where N is the size of the array.
// For each integer, i, use linear search to count its occurrence in the given array.
// If an element has an occurrence of 2, store it as a candidate element.
// If an element has an occurrence of 0, store it as another candidate element.
// Finally, return the two elements that have occurrences of 2 and 0, respectively.

public class FindRepeatingAndMissingNumber {

    public static int[] findMissingAndRepeating(int[] arr) {
        int n = arr.length;
        int missing = -1;
        int repeating = -1;

        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] == i) {
                    count++;
                }
            }

            if (count == 2) {
                repeating = i;

            } else if (count == 0) {
                missing = i;
            }

            if (repeating != -1 && missing != -1)
                break;
        }
        return new int[] { repeating, missing };

    }

    // ***********************************BETTER
    // APPROACH*******************************
    /**
     * Declare a hash array of size N+1 where N is the range of numbers in the array
     * (from 1 to N). This hash array will store the frequency of each element.
     * Iterate through the given array and for each element encountered, update the
     * frequency in the hash array.
     * Once all elements are processed, iterate through the hash array and identify
     * the two elements: one with frequency 2 and one with frequency 0.
     * Return the two elements that have frequencies of 2 and 0, respectively.
     * 
     * @param args
     */

    public static int[] findReapeatingAndMissingNumberBetter(int arr[]) {
        int n = arr.length;

        // hash to count occurance
        int[] hash = new int[n + 1];

        // update the hash array
        for (int i = 0; i < n; i++) {
            hash[arr[i]]++;
        }

        int repeating = -1;
        int missing = -1;

        // find the missing and repeating number
        for (int i = 1; i <= n; i++) {
            if (hash[i] == 2) {
                repeating = i;
            } else if (hash[i] == 0) {
                missing = i;
            }

            // Stop early if both found
            if (repeating != -1 && missing != -1) {
                break;
            }

        }
        // Return [repeating, missing]
        return new int[] { repeating, missing };
    }

    // Time Complexity
    // O(N*N)

    // Space Complexity
    // O(N)

    /*
     * First, calculate the sum of all elements in the given array, denoted as S,
     * and the sum of natural numbers from 1 to N, denoted as Sn. The formula for Sn
     * is (N * (N + 1)) / 2.
     * Now calculate S - Sn. This gives us X - Y, where X is the repeating number
     * and Y is the missing number.
     * Next, calculate the sum of squares of all elements in the array, denoted as
     * S2, and the sum of squares of the first N numbers, denoted as S2n. The
     * formula for S2n is (N * (N + 1) * (2N + 1)) / 6.
     * Now calculate S2 - S2n. This gives us X2 - Y2.
     * From the equations S - Sn = X - Y and S2 - S2n = X2 - Y2, we can compute X +
     * Y by the formula (S2 - S2n) / (S - Sn).
     * Using the values of X + Y and X - Y, we can solve for X and Y through simple
     * addition and subtraction.
     * Finally, return the values of X (the repeating number) and Y (the missing
     * number).
     */

    public static int[] Optimal1(int[] arr) {
        long n = arr.length;

        // Sum of first n natural numbers

        long SN = (n * (n + 1)) / 2;

        // Sum of squares of first n natural numbers

        long S2N = (n * (n + 1) * (2 * n + 1)) / 6;

        // Calculate actual sum (S) and sum of squares (S2) of array elements

        long S = 0, S2 = 0;
        for (int i = 0; i < n; i++) {
            S += arr[i];
            S2 += (long) arr[i] * (long) arr[i];
        }

        // Compute the difference values
        long val1 = S - SN; // X - Y

        // S2 - S2n = X^2 - Y^2
        long val2 = S2 - S2N;

        // Calculate X + Y
        val2 = val2 / val1;

        // Calculate X and Y
        long x = (val1 + val2) / 2; // repeating
        long y = x - val1; // missing

        return new int[] { (int) x, (int) y };

    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 2, 5, 4, 6, 7, 5 };

        int[] result = findMissingAndRepeating(nums);

        int[] response = findReapeatingAndMissingNumberBetter(nums);

        // Print the repeating and missing numbers found
        System.out.println("The repeating and missing numbers are: {"
                + result[0] + ", " + result[1] + "}");
        // Print the repeating and missing numbers found
        System.out.println("The repeating and missing numbers are better: {"
                + response[0] + ", " + response[1] + "}");
    }

}