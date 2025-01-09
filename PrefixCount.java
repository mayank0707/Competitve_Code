//Leetcode problem - https://leetcode.com/problems/counting-words-with-a-given-prefix/description/

//You are given an array of strings words and a string pref. Return the number of strings in words that contain pref as a prefix.

//Solution-

class Solution {
    public int prefixCount(String[] words, String pref) {
        int ans = 0;
        for(String word : words){
            if(word.length()>=pref.length() && word.substring(0,pref.length()).equals(pref)){
                ans++;
            }
        }
        return ans;
    }
}