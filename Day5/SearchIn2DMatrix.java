package Day5;

public class SearchIn2DMatrix {
    public static boolean searchIn2dMatrix(int mat[][], int target) {
        int n = mat.length;
        int m = mat[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == target)
                    return true;
            }
        }

        return false;

    }

    // Better Approach using Binary Search

    public static boolean binarySearch(int[] nums, int target) {
        int n = nums.length;

        int low = 0;
        int high = n - 1;

        while (low <= high) {
            // calculate mid;

            int mid = (low + high) / 2;
            if (nums[mid] == target)
                return true;

            // If target is greater, search in the right half
            else if (target > nums[mid]) {
                low = mid + 1;
            }

            else
                high = mid - 1;
        }

        return false;
    }

    public static boolean searchIn2dMatrixBetter(int[][] mat, int target) {
        int n = mat.length;
        int m = mat[0].length;

        for (int i = 0; i < n; i++) {
            if (mat[i][0] <= target && target <= mat[i][m - 1])
                return binarySearch(mat[i], target);

        }

        return false;

    }

    // Time Complexity O(n*logm)
    // SC O(1)

    // OPTIMAL APPROACH
    // Function to search target in 2D matrix using binary search
    public boolean searchIn2DMatrixOptimal(int[][] mat, int target) {
        int n = mat.length;
        int m = mat[0].length;

        int low = 0;
        int high = n * m - 1;

        while (low <= high) {
            // calculate mid

            int mid = (low + high) / 2;

            // Map 1d index to 2d coordinates
            int row = mid / m;
            int col = mid % m;

            if (mat[row][col] == target) {
                return true;
            } else if (mat[row][col] < target) {
                low = mid + 1;
            } else
                high = mid - 1;

        }
        return false;
    }

    public static void main(String[] args) {
        int[][] mat = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };

        int target = 20;

        boolean result = searchIn2dMatrix(mat, target);
        System.out.print(result);
    }

    // The TC of O(n*m)
    // The SC of O(1)
}