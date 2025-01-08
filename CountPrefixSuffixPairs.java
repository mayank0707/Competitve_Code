//Leetcode problem - https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/?envType=daily-question&envId=2025-01-08

/*
 Q.- Let's define a boolean function isPrefixAndSuffix that takes two strings, str1 and str2:

isPrefixAndSuffix(str1, str2) returns true if str1 is both a prefix and a suffix of str2, and false otherwise.
For example, isPrefixAndSuffix("aba", "ababa") is true because "aba" is a prefix of "ababa" and also a suffix, but isPrefixAndSuffix("abc", "abcd") is false.

Return an integer denoting the number of index pairs (i, j) such that i < j, and isPrefixAndSuffix(words[i], words[j]) is true.
 
*/

//Solution-

class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int ans = 0;
        for(int i=0;i<words.length;i++){
            for(int j = 0;j<i;j++){
                if(isPrefixAndSuffix(words[j], words[i]) == true){
                    ans++;
                }
            }
        }
        return ans;
    }

    public boolean isPrefixAndSuffix(String str1, String str2){
        if (str1.length() > str2.length()) {
            return false; // str1 cannot be a prefix or suffix if it's longer than str2
        }
        boolean isPrefix = str2.substring(0, str1.length()).equals(str1);
        boolean isSuffix = str2.substring(str2.length() - str1.length()).equals(str1);

        return isPrefix && isSuffix;
    }
}