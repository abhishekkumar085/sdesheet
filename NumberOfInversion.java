public class NumberOfInversion {
    public static int numberOfInversion(int[] arr) {
        int cnt = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j])
                    cnt++;
            }
        }

        return cnt;

    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int inversions = numberOfInversion(arr);
        System.out.println("The number of inversions is: " + inversions);
    }
}
