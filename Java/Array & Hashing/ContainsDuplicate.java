// setmap, O(n)
class Solution {
    public boolean containsDuplicate(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		
		for(int num: nums) {
			if(!set.add(num)) {
				return true;
			}
		}
        return false;
    }
}


// first approach
// hashmap, O(n)
class Solution {
    public boolean containsDuplicate(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < nums.length; i++) {
			int target = nums[i];
			
			if(map.containsKey(target)) {
				return true;
			}
			map.put(target, i);
		}
        return false;
    }
}