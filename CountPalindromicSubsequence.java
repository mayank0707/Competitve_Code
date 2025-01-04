//Leetcode problem - https://leetcode.com/problems/unique-length-3-palindromic-subsequences/?envType=daily-question&envId=2025-01-04

/*
	Q.- Given a string s, return the number of unique palindromes of length three that are a subsequence of s.
		Note that even if there are multiple ways to obtain the same subsequence, it is still only counted once.
 */

//Learning - 2 pass traversal with tracking approach

//Solution-

class Solution {
    public int countPalindromicSubsequence(String s) {
        // Set to store unique palindromes
        Set<String> uniquePalindromes = new HashSet<>();
        
        // Array to track characters seen so far (prefix) and to come (suffix)
        Set<Character> seenBefore = new HashSet<>();
        int[] suffixCount = new int[26];
        
        // Count occurrences of each character in the string
        for (char c : s.toCharArray()) {
            suffixCount[c - 'a']++;
        }
        
        // Traverse the string to find palindromes
        for (int i = 0; i < s.length(); i++) {
            char mid = s.charAt(i);  // Current character as middle of palindrome
            suffixCount[mid - 'a']--;  // Decrement its count in suffix
            
            // Check all seenBefore and suffix characters for valid "aba" palindromes
            for (char startEnd : seenBefore) {
                if (suffixCount[startEnd - 'a'] > 0) {
                    // Form a palindrome and add to the set
                    uniquePalindromes.add("" + startEnd + mid + startEnd);
                }
            }
            
            // Add the current character to seenBefore
            seenBefore.add(mid);
        }
        
        // Return the number of unique palindromes
        return uniquePalindromes.size();
    }
}