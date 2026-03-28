// https://neetcode.io/problems/max-water-container

// O(n)
class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1;
        int max = 0;

        while(left < right) {
            int leftValue = heights[left], rightValue = heights[right];
            int area = Math.min(leftValue, rightValue) * (right - left);
            
            max = Math.max(max, area);

            if(leftValue <= rightValue) left++;
            else right--;
        }

        return max;
    }
}
