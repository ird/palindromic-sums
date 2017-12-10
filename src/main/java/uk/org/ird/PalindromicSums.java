package uk.org.ird;

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
    }

    public static void test() {
        Palindromes.setLowerBound(121);
        System.out.println("Is 121 a palindrome? " + Palindromes.isNotPalindrome());
        Palindromes.setLowerBound(99);
        System.out.println("Is 99 a palindrome? " + Palindromes.isNotPalindrome());
        Palindromes.setLowerBound(321);
        System.out.println("Is 321 a palindrome? " + Palindromes.isNotPalindrome());
    }
}
