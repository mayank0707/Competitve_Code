//Leetcode problem - https://leetcode.com/problems/move-zeroes/description/

public class MoveZeroElements {
	
	public void moveZeroes(int[] nums) {
        if(nums.length == 1){ //if array length is 1, return as it is.
            return ;
        }

        int nonZeroIndex = 0; 
        for(int i=0;i<nums.length;i++){ //find every nonZero value in array and set it
            if(nums[i]!=0){
                nums[nonZeroIndex] = nums[i];
                nonZeroIndex++;
            }
        }
        while(nonZeroIndex<nums.length){ //At the end set the zeroes at the end of nonZero value
            nums[nonZeroIndex]=0;
            nonZeroIndex++;
        }
    }

}
