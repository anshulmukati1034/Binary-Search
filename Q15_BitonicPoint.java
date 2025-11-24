public class Q15_BitonicPoint {
    public static int findMaximum(int[] arr) {
        int n = arr.length;

        // Check if the first element is maximum
        if (n == 1 || arr[0] > arr[1])
            return arr[0];

        // Check if the last element is maximum
        if (arr[n - 1] > arr[n - 2])
            return arr[n - 1];

        // Search Space for binary Search
        int lo = 1, hi = n - 2;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            // If the element at mid is maximum then return it
            if (arr[mid] >= arr[mid - 1] && arr[mid] > arr[mid + 1])
                return arr[mid];

            // If next element is greater, then maximum
            // element will exist in the right subarray
            if (arr[mid] < arr[mid + 1])
                lo = mid + 1;

            // Otherwise, it will exist in left subarray
            else
                hi = mid - 1;
        }

        return arr[hi];
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 12, 4, 2};
        int maxElement = findMaximum(arr);
        System.out.println("The maximum element in the bitonic array is: " + maxElement);
    }
}
