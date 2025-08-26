// https://neetcode.io/problems/two-integer-sum?list=neetcode150

// O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < nums.length; i++) {
			int comp = target - nums[i];
			
			if(map.containsKey(comp)) {
				return new int[]{map.get(comp), i};
			}
            
			map.put(nums[i], i);
		}
		return new int[]{};
    }
}

// O(n²)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) { 
			int posA = nums[i];
			
			for (int j = i + 1; j < nums.length; j++) { 
				 int posB = nums[j];
				 
				 if(posA + posB == target) {
					 return new int[]{i, j};
				 }
			}
		}
		return new int[]{};
    }
}