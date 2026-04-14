// https://neetcode.io/problems/daily-temperatures

// O(n)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<int[]> stack = new ArrayDeque<>();
        
        for(int i = 0; i < temperatures.length; i++){
            int current = temperatures[i];

            while(!stack.isEmpty() && current > stack.peek()[0]) {
                int[] temp = stack.pop();
                res[temp[1]] = i - temp[1];
            }

            stack.push(new int[]{current, i});
        }
        
        return res;
    }
}

// O(n²)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];

        int left = 0, right = 0;
        int contDay = 0;
        while(left < temperatures.length - 1) {
            if (temperatures[right] > temperatures[left]) {
                res[left] = contDay;
                contDay = 0;
                left++;
                right = left;
                continue;
            }

            if (right == temperatures.length - 1) {
                left++;
                right = left;
                contDay = 0;
            }else {
                right++;
                contDay++;
            }
        }

        return res;
    }
}