//Leetcode problem - https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/description/?envType=daily-question&envId=2025-01-12

/*
 Q.- A parentheses string is a non-empty string consisting only of '(' and ')'. It is valid if any of the following conditions is true:
	It is ().
	It can be written as AB (A concatenated with B), where A and B are valid parentheses strings.
	It can be written as (A), where A is a valid parentheses string.
	You are given a parentheses string s and a string locked, both of length n. locked is a binary string consisting only of '0's and '1's. For each index i of locked,
	
	If locked[i] is '1', you cannot change s[i].
	But if locked[i] is '0', you can change s[i] to either '(' or ')'.
	Return true if you can make s a valid parentheses string. Otherwise, return false.
 */

//Learning - Two pass approach i.e. first from left to right and then right to left.

//Solution-

class Solution {
    public boolean canBeValid(String s, String locked) {
        // If the string length is odd, it's impossible to balance parentheses
        if (s.length() % 2 != 0) {
            return false;
        }

        int openCount = 0, flexibleCount = 0;

        // Left-to-right pass
        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '1') {
                // Locked character
                if (s.charAt(i) == '(') {
                    openCount++;
                } else { // ')'
                    openCount--;
                }
            } else {
                // Unlocked character
                flexibleCount++;
            }

            // If there are more closing parentheses than can be matched
            if (openCount + flexibleCount < 0) {
                return false;
            }
        }

        openCount = 0;
        flexibleCount = 0;

        // Right-to-left pass
        for (int i = s.length() - 1; i >= 0; i--) {
            if (locked.charAt(i) == '1') {
                // Locked character
                if (s.charAt(i) == ')') {
                    openCount++;
                } else { // '('
                    openCount--;
                }
            } else {
                // Unlocked character
                flexibleCount++;
            }

            // If there are more opening parentheses than can be matched
            if (openCount + flexibleCount < 0) {
                return false;
            }
        }

        return true;
    }
}