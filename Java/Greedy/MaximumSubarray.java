https://neetcode.io/problems/maximum-subarray

// S T: O(n), O(1)
class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0], sum = 0;

        for (int num : nums) {
             if(sum <= 0) sum = 0;
             sum += num;
             max = Math.max(max, sum);
        }

        return max;
    }
}

// S T: O(n)
class Solution {
    public int maxSubArray(int[] nums) {
        int[] clone = nums.clone();
        for (int i = 1; i < nums.length; i++) {
            clone[i] = Math.max(nums[i], (nums[i] + clone[i - 1]));
        }

        int max = clone[0];
        for (int res : clone) {
            max = Math.max(max, res);
        }

        return max;
    }
}
