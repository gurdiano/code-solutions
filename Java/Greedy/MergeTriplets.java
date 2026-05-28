// https://neetcode.io/problems/merge-triplets-to-form-target

// O(n)
class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        Set<Integer> set = new HashSet<>();

        for(int[] arr : triplets) {
            if(arr[0] > target[0] || arr[1] > target[1] || arr[2] > target[2]) continue;
            
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] == target[i]) set.add(i);
            }
        }

        return set.size() == 3;
    }
}
