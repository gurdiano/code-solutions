// https://neetcode.io/problems/car-fleet

// O(n log n)
class Solution {
    private TreeMap<Integer, Integer> carPositionSpeedMap(int[] position, int[] speed) {
        TreeMap<Integer, Integer> map = new TreeMap<>((a, b) -> b - a);
        
        for(int i = 0; i < position.length; i++) {
            map.put(position[i], speed[i]);
        }
        return map;
    }

    private Deque<Float> carTimeStack(TreeMap<Integer, Integer> map, int target){
        Deque<Float> stack = new ArrayDeque<>();

        for(int key : map.keySet()){
            float time = (float)(target - key) / map.get(key);

            if(stack.isEmpty()) stack.push(time);
            else if(time > stack.peek()) stack.push(time);
        }
        return stack;
    }

    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Integer> map = carPositionSpeedMap(position, speed);
        Deque<Float> stack = carTimeStack(map, target);

        return stack.size();
    }
}