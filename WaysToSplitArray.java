//Leetcode problem - https://leetcode.com/problems/number-of-ways-to-split-array/?envType=daily-question&envId=2025-01-03

/*
	Q.- Nums contains a valid split at index i if the following are true:
	The sum of the first i + 1 elements is greater than or equal to the sum of the last n - i - 1 elements.
	There is at least one element to the right of i. That is, 0 <= i < n - 1.
	Return the number of valid splits in nums.
*/

//Learning- Prefix Sum concept with different kind of problem statement.

//Solution-

class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long[] prefix = new long[n];
        
        prefix[0] = nums[0];

        for(int i = 1;i<n;i++){
            prefix[i] = prefix[i-1]+nums[i];
        }

        int ans = 0;

        for(int i = 0;i<n-1;i++){
            if(prefix[i] >= (prefix[n-1]-prefix[i])){
                ans++;
            }
        }

        return ans;
    }
}