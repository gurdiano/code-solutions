https://neetcode.io/problems/find-target-in-rotated-sorted-array

// O(log n)
class Solution {
    public int findMinimum(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = (l + r) / 2;

            if(nums[m] > nums[r]) l = m + 1;
            else r = m;
        }
        return l;
    }

    public int search(int[] nums, int target) {
        int min = findMinimum(nums);

        int l = 0, r = nums.length - 1;
        if(target >= nums[min] && target <= nums[r]) l = min;
        else r = min - 1;

        while(l <= r) {
            int m = (l + r) / 2;

            if(nums[m] == target) return m;
            
            if(target > nums[m]) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }
}