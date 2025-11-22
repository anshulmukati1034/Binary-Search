public class Q2_FirstBadVersion {
     public static int firstBadVersion(int n) {
        int low = 1, high = n;

        while(low < high){
            int mid = low + (high - low)/2;

            if (isBadVersion(mid)) {
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }

    private static boolean isBadVersion(int version) {
        return version >= 4; 
    }

    public static void main(String[] args) {
        int n = 10; 
        int firstBad = firstBadVersion(n);
        System.out.println("The first bad version is: " + firstBad);
    }
}
