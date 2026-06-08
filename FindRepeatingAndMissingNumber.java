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