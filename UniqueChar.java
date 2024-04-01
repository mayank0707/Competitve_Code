//Leetcode problem- https://leetcode.com/problems/first-unique-character-in-a-string/description/

import java.util.*;


public class UniqueChar {
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
