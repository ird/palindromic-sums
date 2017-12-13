package uk.org.ird;

public class Palindromes {
    private static Integer current = 1;
    private Palindromes() {} // prevent instantiation
    /**
     * Returns the next palindrome greater than the current one
     */
    public static int next() {
        current += 1;
        while (!isPalindrome()) {
            current++;
        }
        return current;
    }
    public static int firstPalindrome() {
        if(!isPalindrome()) {
            return next();
        }
        return current;
    }
    /**
     * Set the lower bound
     * @param lowerBound value to set the lower limit to
     */
    public static void setLowerBound(int lowerBound) { current = lowerBound; }
    /**
     * test current value to see if it is a palindrome
     * @returns true whilst this.current is not a palindrome
     */
    static boolean isPalindrome() {
        String s = current.toString();
        int len = s.length();
        while(len > 1) {
            if (!s.substring(0, 1).equals(s.substring(len-1))) {
                return false;
            }
            s = s.substring(1, len-1);
            len -= 2;
        }
        return true;
    }
}
