package uk.org.ird;

import java.util.LinkedList;

/**
 * http://projecteuler.net/problem=125
 * "eg. The palindromic number 595 can be written as the sum of consecutive
 * squares: 6^2 + 7^2 + 8^2 + 9^2 + 10^2 + 11^2 + 12^2.
 * There are exactly eleven palindromes below one-thousand that can be written
 * as consecutive square sums, and the sum of these palindromes is 4164.
 * Note that 1 = 0^2 + 1^2 has not been included as this problem is concerned
 * with the squares of positive integers.
 * Find the sum of all the numbers less than 10^8 that are both palindromic
 * and can be written as the sum of consecutive squares."
 * @author      ird
 * @version     1.0
 */
public class PalindromicSums {

    public static void main(String[] args) {
        test();
        int sum = 0;
        LinkedList<Integer> result = build(1000);
        for(int e: result) {
            sum += e;
        }
        System.out.println(result);
        System.out.println(sum);
    }

    /**
     * Build a list of palindromes up to the limit that are also the sum of
     * consecutive palindromes.
     * @param limit
     * @return a LinkedList of palindromes
     */
    public static LinkedList<Integer> build(int limit) {
        LinkedList<Integer> res = new LinkedList<>();
        int i = 0;
        Palindromes.setLowerBound(i);
        i = Palindromes.firstPalindrome();
        while (i < limit) {
            if (expressibleAsSquares(i)) {
                res.add(i);
            }
            i = Palindromes.next();
        }
        return res;
    }

    public static boolean expressibleAsSquares(int target) {
        int start = 1;
        int end = 1;
        int total = start * start; // 1
        while (end <= Math.sqrt(target)) {
            if(total == target) {
                if(start != end) {
                    return true;
                }
            }
            if(total > target) {
                total -= start*start;
                start++;
                continue;
            }
            end++;
            total += end * end;
        }
        return false;
    }
    public static void test() {
        Palindromes.setLowerBound(121);
        System.out.println("Is 121 a palindrome? " + Palindromes.isPalindrome());
        Palindromes.setLowerBound(99);
        System.out.println("Is 99 a palindrome? " + Palindromes.isPalindrome());
        Palindromes.setLowerBound(321);
        System.out.println("Is 321 a palindrome? " + Palindromes.isPalindrome());
        int[] squareTest = {1, 2, 3, 4, 21, 41, 101, 595};
        for(int i : squareTest) {
            System.out.println("Is "+i+" expressible as a sum of squares? "+ expressibleAsSquares(i));
        }
    }
}
