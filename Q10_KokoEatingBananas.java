public class Q10_KokoEatingBananas {
     public static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        for(int p : piles){
            high = Math.max(high, p);
        }

        while(low < high){
            int mid = low + (high - low) / 2;

            if(canFinish(piles, mid, h)){
                high = mid;        
            } else {
                low = mid + 1;     
            }
        }

        return low; // or high both are same
    }

    private static boolean canFinish(int[] piles, int speed, int h){
        int hours = 0;

        for(int p : piles){
            hours += (p + speed - 1) / speed;  

            if(hours > h) return false;       
        }

        return hours <= h;
    }

    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        int minSpeed = minEatingSpeed(piles, h);
        System.out.println("Minimum eating speed to finish all bananas in " + h + " hours is: " + minSpeed);
    }
}
