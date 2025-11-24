public class Q14_MinimumDifferenceElementinaSortedArray {
     public static int findClosest(int[] arr, int key) {
        int low = 0, high = arr.length - 1;

        // If key is beyond boundaries
        if (key <= arr[0]) return arr[0];
        if (key >= arr[high]) return arr[high];

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == key) return arr[mid];

            if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // Now low = first element > key
        // and high = last element < key
        // Compare both

        if ((arr[low] - key) < (key - arr[high])) {
            return arr[low];
        }
        return arr[high];
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 10};
        int key = 7;
        int closestElement = findClosest(arr, key);
        System.out.println("The element closest to " + key + " is: " + closestElement);
    }
}
