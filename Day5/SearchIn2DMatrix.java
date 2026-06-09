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
}