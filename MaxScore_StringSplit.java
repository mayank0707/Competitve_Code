Leetcode problem - https://leetcode.com/problems/maximum-score-after-splitting-a-string/?envType=daily-question&envId=2025-01-01
	
Q. Given a string s of zeros and ones, return the maximum score after splitting the string into two non-empty substrings (i.e. left substring and right substring).
The score after splitting a string is the number of zeros in the left substring plus the number of ones in the right substring.

Learning- Prefix Sum concept

Solution-

class Solution {
    public int maxScore(String s) {
        int len = s.length();

        // Arrays to store prefix counts of 0s and suffix counts of 1s
        int[] prefixZeros = new int[len];
        int[] suffixOnes = new int[len];

        // prefix counts of 0s
        prefixZeros[0] = s.charAt(0) == '0' ? 1 : 0;
        for (int i = 1; i < len; i++) {
            prefixZeros[i] = prefixZeros[i - 1] + (s.charAt(i) == '0' ? 1 : 0);
        }

        // suffix counts of 1s
        suffixOnes[len - 1] = s.charAt(len - 1) == '1' ? 1 : 0;
        for (int i = len - 2; i >= 0; i--) {
            suffixOnes[i] = suffixOnes[i + 1] + (s.charAt(i) == '1' ? 1 : 0);
        }

        // Find the maximum sum at each split point
        int max = 0;
        for (int i = 0; i < len - 1; i++) { // Split between i and i+1
            int leftSide = prefixZeros[i];
            int rightSide = suffixOnes[i + 1];
            max = Math.max(max, leftSide + rightSide);
        }

        return max;
    }
}