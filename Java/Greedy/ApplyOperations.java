https://leetcode.com/problems/apply-operations-to-make-all-array-elements-equal-to-zero/

// O(n)
class Solution {
    public boolean checkArray(int[] nums, int k) {
        int current = 0;

        for (int i = 0; i < nums.length; i++) {
            if(current > nums[i]) return false;
            
            nums[i] -= current;
            current += nums[i];

            if(i >= k - 1) current -= nums[i - k + 1];
        }   

        return current == 0;
    }
}