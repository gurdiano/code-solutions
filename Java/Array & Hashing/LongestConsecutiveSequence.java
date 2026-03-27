// https://neetcode.io/problems/longest-consecutive-sequence/question

// Time O(n log n)
// Space O(1)
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums);

        int max = 1, cont = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue;

            if (nums[i] == nums[i - 1] + 1) {
                cont++;
            } else {
                max = Math.max(max, cont);
                cont = 1;
            }
        }
        
        return Math.max(max, cont);
    }
}

// Time O(n)
// Space O(n)
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) set.add(num);

        int max = 0;
        for(int num : set) {
            if (!set.contains(num - 1)) {
                int sequence = 1;
                int current = num;
                
                while(set.contains(current + 1)) {
                    sequence++;
                    current++;
                }

                max = Math.max(max, sequence);
            }
        }

        return max;
    }
}

