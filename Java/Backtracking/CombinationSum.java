// https://neetcode.io/problems/combination-target-sum

// O(n^(t/m))
class Solution {
    List<List<Integer>> RES = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> current = new ArrayList<>();
        backtracking(nums, target, current, 0);
        return this.RES;
    }

    public void backtracking(int[] nums, int target, List<Integer> current, int i) {
        if(target == 0) {
            this.RES.add(new ArrayList<>(current));
            return;
        }
        if(target < 0 || i >= nums.length) {
            return;
        }
        
        int value = nums[i];

        current.add(value);
        backtracking(nums, target - value, current, i);

        current.remove(current.size() - 1);
        backtracking(nums, target, current, i + 1);
    }
}
