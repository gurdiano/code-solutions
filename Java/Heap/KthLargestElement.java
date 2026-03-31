// https://neetcode.io/problems/kth-largest-integer-in-a-stream


class KthLargest {
    PriorityQueue<Integer> minHeap;
    int K;

    // O(n log K)
    public KthLargest(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>();
        this.K = k;

        for (int num : nums) {
            minHeap.offer(num);
            if(minHeap.size() > this.K) minHeap.poll();
        }
    }

    // O(log n)
    public int add(int val) {
        this.minHeap.offer(val);
        if(minHeap.size() > this.K) minHeap.poll();
        return this.minHeap.peek();
    }
}
