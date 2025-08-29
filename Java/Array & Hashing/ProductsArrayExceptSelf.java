// https://neetcode.io/problems/products-of-array-discluding-self?list=neetcode150

// O(n)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
		int[] prefix = new int[nums.length];
		
		prefix[0] = 1;
		for(int i = 1; i < nums.length; i++) {
			prefix[i] = prefix[i - 1] * nums[i -1];
		}
		
		int suffix = 1; 
		for(int i = nums.length - 1; i >= 0; i--) {
			res[i] = prefix[i] * suffix;
			suffix *= nums[i]; 
		}
		return res;
    }
}  