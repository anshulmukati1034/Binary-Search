public class Q7_PeakElement {
     public static int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[mid + 1]) {
                // Peak is on the left (including mid)
                high = mid;
            } else {
                // Peak is on the right
                low = mid + 1;
            }
        }

        return low;  // or high
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        int peakIndex = findPeakElement(nums);
        System.out.println("Peak element found at index: " + peakIndex + " with value: " + nums[peakIndex]);
    }
}
