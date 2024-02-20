/* 
 * Leetcode problem - https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/description/
 */

public class IsPartitionPossible {

	public boolean canThreePartsEqualSum(int[] arr) {
        int totalSum=0;
        for(int i: arr){
            totalSum+=i;
        }
        if(totalSum %3!=0){
            return false;
        }
        int sumPerPart = totalSum/3;
        int q=sumPerPart;
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(q-arr[i]!=0){
                q=q-arr[i];
            }
            else{
                q=sumPerPart;
                count++;
            }
        }
        if(count>=3){
            return true;
        }
        else{
            return false;
        }
    }
	
	public static void main(String[] args) {
		IsPartitionPossible obj=new IsPartitionPossible();
		int arr[]= new int[] {0,2,1,-6,6,-7,9,1,2,0,1};
		System.out.println(obj.canThreePartsEqualSum(arr));
	}

}
