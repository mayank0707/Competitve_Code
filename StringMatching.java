//Leetcode problem- https://leetcode.com/problems/string-matching-in-an-array/description/?envType=daily-question&envId=2025-01-07

//Q.- Given an array of string words, return all strings in words that is a substring of another word. You can return the answer in any order.

//Solution-

class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        for(String word : words){
            for(int i = 0;i<words.length;i++){
                if(!word.equals(words[i])){
                    if(words[i].contains(word)){
                        if(!res.contains(word)){
                            res.add(word);
                        }
                    }
                }
                else{
                    continue;
                }
            }
        }
        return res;
    }
}