// https://neetcode.io/problems/find-minimum-in-rotated-sorted-array

// O(log n)
class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return nums[l];
    }
}

class Solution {
    public int findMin(int[] nums) {
        int min = nums[0];

        int l = 0, r = nums.length - 1;
        while(l <= r) {
            if (nums[l] < nums[r]) {
                return Math.min(min, nums[l]);
            }

            int m = (l + r) / 2;
            min = Math.min(min, nums[m]);

            if(nums[m] >= nums[l]) l = m + 1;
            else r = m - 1;
        }

        return min;
    }
}
