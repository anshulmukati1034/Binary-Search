public class Q4_GuessNumberHigherAndLower {
      public static int guessNumber(int n) {
        int low = 1, high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int res = guess(mid);

            if (res == 0) {
                return mid;  // Found the number
            } else if (res == -1) {
                high = mid - 1;  // Guess is high → move left
            } else {
                low = mid + 1;   // Guess is low → move right
            }
        }

        return -1; // This will never happen
    }

    public static int guess(int num) {
        int pick = 6; // The number to guess
        if (num == pick) {
            return 0;
        } else if (num > pick) {
            return -1;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        int n = 10;
        int result = guessNumber(n);
        System.out.println("The guessed number is: " + result);
    }
}
