public class Q6_SearchinRotatedSortedArray {
   
    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) return mid;

            // Determine which side is properly sorted
            if (nums[low] <= nums[mid]) { // Left side is sorted
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1; // Target is in the left side
                } else {
                    low = mid + 1; // Target is in the right side
                }
            } else { // Right side is sorted
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1; // Target is in the right side
                } else {
                    high = mid - 1; // Target is in the left side
                }
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        int result = search(nums, target);
        if (result != -1) {
            System.out.println("Target " + target + " found at index " + result + ".");
        } else {
            System.out.println("Target " + target + " not found.");
        }
    }
}