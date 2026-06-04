import java.util.Arrays;

public class MergeTwoSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {

            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }

            k--;
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

    public static void main(String[] args) {

        int arr1[] = { 2, 3, 4, 5, 0, 0, 0, 0 };
        int arr2[] = { 0, 1, 6, 9 };

        int m = 4;
        int n = 4;

        MergeTwoSortedArray obj = new MergeTwoSortedArray();

        obj.merge(arr1, m, arr2, n);

        System.out.println(Arrays.toString(arr1));
    }

}
