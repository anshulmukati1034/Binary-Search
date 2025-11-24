public class Q11_KthSmallestElementinaSortedMatrix {
     public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        int low = matrix[0][0];
        int high = matrix[n-1][n-1];

        while (low < high) {
            int mid = low + (high - low) / 2;

            int count = countLessEqual(matrix, mid);

            if (count < k) {
                low = mid + 1;   // need larger numbers
            } else {
                high = mid;      // mid could be the answer
            }
        }

        return low;   // or high, same value
    }

    // Count numbers <= mid
    private static int countLessEqual(int[][] matrix, int mid) {
        int n = matrix.length;
        int count = 0;

        int row = n - 1;
        int col = 0;

        while (row >= 0 && col < n) {
            if (matrix[row][col] <= mid) {
                count += (row + 1);  // all elements above are <= mid
                col++;               // move right
            } else {
                row--;               // move up
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 5, 9},
            {10, 11, 13},
            {12, 13, 15}
        };
        int k = 8;
        int kthSmallestElement = kthSmallest(matrix, k);
        System.out.println("The " + k + "th smallest element in the sorted matrix is: " + kthSmallestElement);
    }
}
