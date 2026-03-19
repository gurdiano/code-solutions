// https://neetcode.io/problems/top-k-elements-in-list/

// O(n log k)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for(int num : map.keySet()) { 
            heap.add(num);
            if(heap.size() > k) heap.poll();
        }

        int[] topFreq = new int[k];
        for(int i = k - 1; i >= 0; i--) {
            topFreq[i] = heap.poll();
        }

        return topFreq;
    }
}