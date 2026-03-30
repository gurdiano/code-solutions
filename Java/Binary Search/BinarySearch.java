// https://neetcode.io/problems/binary-search

// O(log n)
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if(nums[middle] > target) right = middle - 1;
            else if(nums[middle] < target) left = middle + 1;

            else return middle;
        }

        return -1;
    }
}

// O(n)
class Solution {
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target) return i;
        }

        return -1;           
    }
}