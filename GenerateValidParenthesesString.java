//Leetcode Problem- https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/description/
//Submitted leetcode solution explanation- https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/solutions/4984645/best-and-easy-to-understand-solution/

import java.util.*;


public class GenerateValidParenthesesString {
	public String minRemoveToMakeValid(String s) {
        ArrayList<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);
        int openingBracket = 0, i = 0;

        while(i<sb.length()){
            if(sb.charAt(i)==')'){
                if(openingBracket == 0){ //removes the initial ')'
                    sb.deleteCharAt(i);
                    i--;
                }
                else{ //handles the '(' & ')' and both nullified each other
                    openingBracket--;
                    list.remove(list.size()-1);
                }
            }
            else if(sb.charAt(i)=='('){ 
                openingBracket++;
                list.add(i); //stores the '(' position to handle it later
            }
            i++;
        }

        int n = list.size()-1;
        while(n>=0){
            sb.deleteCharAt(list.get(n)); //removes the extra '(' from sb
            n--;
        }

        return sb.toString();
    }
}
