//Leetcode problem- https://leetcode.com/problems/minimum-common-value/description/

public class LowestCommonValue {
	
	public int getCommon(int[] nums1, int[] nums2) {
        int l1=nums1.length;
        int l2=nums2.length;
        int i=0,j=0, ans=-1;
        while(i<l1 && j<l2){ //uses two pointer approach
            if(nums1[i]>nums2[j]){
                j++;
            }
            else if(nums1[i]<nums2[j]){
                i++;
            }
            else{
                ans=nums1[i];
                break;
            }
        }
        return ans;
    }
	
	public static void main(String[] args) {
		int[] arr1= {1,2,3,4,5};
		int[] arr2= {2,4};
		LowestCommonValue obj= new LowestCommonValue();
		int answer = obj.getCommon(arr1, arr2);  //answer=2
		System.out.println(answer); 
	}

}
