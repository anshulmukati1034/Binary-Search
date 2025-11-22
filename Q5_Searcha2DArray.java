public class Q5_Searcha2DArray {
   
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0, high = m * n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int row = mid / n;
            int col = mid % n;

            int value = matrix[row][col];

            if (value == target) return true;
            else if (value < target) low = mid + 1;
            else high = mid - 1;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target = 3;
        boolean result = searchMatrix(matrix, target);
        System.out.println("Target " + target + (result ? " found." : " not found."));
    }
}

