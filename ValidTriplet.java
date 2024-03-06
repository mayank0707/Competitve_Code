//Leetcode problem- https://leetcode.com/problems/3sum/

import java.util.*;

public class ValidTriplet {

	public List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) break; // Since arr[i] <= arr[l] <= arr[r], if a[i] > 0 then sum=arr[i]+arr[l]+arr[r] > 0
            int l = i + 1, r = n - 1;
            while (l < r) {
                int sum = arr[i] + arr[l] + arr[r];
                if (sum < 0) l++;
                else if (sum > 0) r--;
                else {
                    ans.add(Arrays.asList(arr[i], arr[l], arr[r]));
                    while (l+1 <= r && arr[l] == arr[l+1]) l++; // Skip duplicate arr[l]
                    l++;
                    r--;
                }
            }
            while (i+1 < n && arr[i+1] == arr[i]) i++; // Skip duplicate arr[i]
        }
        return ans;
    }
	
	public static void main(String[] args) {
		int[] arr= {1, 0, -1, 2, -1, -2};
		ValidTriplet obj = new ValidTriplet();
		List<List<Integer>> ans = obj.threeSum(arr);
		System.out.println(ans);
	}

}
