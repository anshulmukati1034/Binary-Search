public class Q13_CapacityToShipPackagesWithinDDays {
     public static int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;

        for (int w : weights) {
            low = Math.max(low, w);    // minimum capacity
            high += w;                 // maximum capacity
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canShip(weights, mid) <= days) {
                high = mid;   // try a smaller capacity
            } else {
                low = mid + 1;  // need bigger capacity
            }
        }

        return low;  // minimum capacity that works
    }

    private static int canShip(int[] weights, int cap) {
        int days = 1;
        int load = 0;

        for (int w : weights) {
            if (load + w > cap) {
                days++;      // new day
                load = w;    // start with current weight
            } else {
                load += w;
            }
        }

        return days;
    }

    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        int capacity = shipWithinDays(weights, days);
        System.out.println("Minimum capacity to ship packages within " + days + " days is: " + capacity);
    }
}
