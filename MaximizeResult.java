//Leetcode Problem- https://leetcode.com/problems/remove-digit-from-number-to-maximize-result/

import java.util.ArrayList;
import java.util.Collections;

public class MaximizeResult {
	public String removeDigit(String number, char digit) {
        ArrayList<String> result = new ArrayList<>();
        
        for(int i=0;i<number.length();i++) {
        	if(number.charAt(i)==digit){
        	    result.add(number.substring(0, i) + number.substring(i+1));
            }
        }
        
        Collections.sort(result);
		return result.get(result.size()-1);
    }
	
	public static void main(String[] args) {
		String number = "23161";
		char digit = '1';
		MaximizeResult obj = new MaximizeResult();
		String ans = obj.removeDigit(number, digit);
		System.out.println(ans);
	}

}
