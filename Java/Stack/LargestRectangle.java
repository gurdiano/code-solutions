https://neetcode.io/problems/largest-rectangle-in-histogram

// O(n)
class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> stack = new ArrayDeque<>();

        stack.push(new int[]{0, heights[0]});
        int maxArea = 0;
        for(int i = 1; i < heights.length; i++) {
            int value = heights[i];
            
            if(value >= stack.peek()[1]) {
                stack.push(new int[]{i, value});
            }
            else {
                int[] last = new int[]{};
                while(!stack.isEmpty() && value <= stack.peek()[1]) {
                    last = stack.pop();

                    maxArea = Math.max(maxArea, (i - last[0]) * last[1]);
                }
                stack.push(new int[]{last[0], value});
            }
        }

        int size = heights.length;
        while(!stack.isEmpty()) {
            int[] arr = stack.pop();
            maxArea = Math.max(maxArea, (size - arr[0]) * arr[1]);
        }
        return maxArea;
    }
}
