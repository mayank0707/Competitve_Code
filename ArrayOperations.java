//Leetcode problem - https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/description/?envType=daily-question&envId=2025-01-06

/*
 Q.- You have n boxes. You are given a binary string boxes of length n, where boxes[i] is '0' if the ith box is empty, and '1' if it contains one ball.
	In one operation, you can move one ball from a box to an adjacent box. Box i is adjacent to box j if abs(i - j) == 1. Note that after doing so, there may be more than one ball in some boxes.
	Return an array answer of size n, where answer[i] is the minimum number of operations needed to move all the balls to the ith box.
	Each answer[i] is calculated considering the initial state of the boxes.
 */

//Learning- Prefix Sum that can easily optimized the solution i.e. by reusing information from previously computed results rather than recalculating everything from scratch.

//Solution-

class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] ans = new int[n];

        // Traverse from left to right
        int leftCount = 0; // Number of '1's to the left
        int leftOperations = 0; // Total operations for left part
        for (int i = 0; i < n; i++) {
            ans[i] += leftOperations; // Add left operations to the current box
            leftCount += boxes.charAt(i) - '0'; // Update the count of '1's
            leftOperations += leftCount; // Update the operations count
        }

        // Traverse from right to left
        int rightCount = 0; // Number of '1's to the right
        int rightOperations = 0; // Total operations for right part
        for (int i = n - 1; i >= 0; i--) {
            ans[i] += rightOperations; // Add right operations to the current box
            rightCount += boxes.charAt(i) - '0'; // Update the count of '1's
            rightOperations += rightCount; // Update the operations count
        }

        return ans;
    }
}