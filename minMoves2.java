//Leetcode problem - https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/

/*
    Q.- Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.
	In one move, you can increment or decrement an element of the array by 1.
*/

// Learning - Median is a good solution for absolute diff and Average is good for Squared difference.

//Solution- 
 class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums); // Sort the array
        int median = nums[nums.length / 2]; //Find median
        int ans = 0;

        for (int n : nums) {
            ans += Math.abs(n - median); //Sum the absolute difference
        }

        return ans;
    }
}
