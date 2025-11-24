public class Q12_FindSmallestLetterGreaterThanTarget {
     public static char nextGreatestLetter(char[] letters, char target) {
        int low = 0, high = letters.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (letters[mid] > target) {
                high = mid - 1;  
            } else {
                low = mid + 1;    // move right
            }
        }

        return letters[low % letters.length];
    }

    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        char target = 'a';
        char result = nextGreatestLetter(letters, target);
        System.out.println("The smallest letter greater than '" + target + "' is: " + result);
    }
}
