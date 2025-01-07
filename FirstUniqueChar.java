//Leetcode problem- https://leetcode.com/problems/first-unique-character-in-a-string/description/

 //Q.- Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

//Solution-

class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(map.get(ch)==1){
                return i; //found the first unique character
            }
        }
        return -1;
    }
}