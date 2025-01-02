Leetcode Problem - https://leetcode.com/problems/count-vowel-strings-in-ranges/description/?envType=daily-question&envId=2025-01-02
	
Q.- You are given a 0-indexed array of strings words and a 2D array of integers queries.
Each query queries[i] = [li, ri] asks us to find the number of strings present in the range li to ri (both inclusive) of words that start and end with a vowel.
Return an array ans of size queries.length, where ans[i] is the answer to the ith query.

Learning: Prefix Sum concept

Solution-

import java.util.Arrays;

public class Count_VowelStrings {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int queries_len = queries.length;
        int n = words.length;

        int[] prefix = new int[n];

        for(int i= 0;i<n;i++){
            boolean response1 = findResponse(words[i].charAt(0));
            boolean response2 = words[i].length() == 1 ? true : findResponse(words[i].charAt(words[i].length()-1));

            prefix[i] = (i > 0 ? prefix[i - 1] : 0) + ((response1&&response2) ? 1 : 0);
        }

        int[] ans = new int[queries_len];
        for (int i = 0; i < queries_len; i++) {
            int li= queries[i][0];
            int ri = queries[i][1];

            ans[i] = prefix[ri]-(li>0 ? prefix[li-1]: 0);
        }

        return ans;
    }

    public boolean findResponse(char ch){
        switch (ch) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    } 

    public static void main(String[] args) {
        String[] arr = {"a","e","i"};
        int[][] queries = new int[][] {
            {0,2},{0,1},{2,2}
        };
        Count_VowelStrings obj = new Count_VowelStrings();
        System.out.println(Arrays.toString(obj.vowelStrings(arr, queries)));
    }
}