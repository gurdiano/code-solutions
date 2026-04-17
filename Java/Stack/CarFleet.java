// https://neetcode.io/problems/car-fleet

// O(n log n)
class Solution {
    private TreeMap<Integer, Integer> createTreeMap(int[] position, int[] speed) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int i = 0; i < position.length; i++) {
            map.put(position[i], speed[i]);
        }
        return map;
    }
    
    private Deque<Float> createStack(TreeMap<Integer, Integer> map, int target){
        Deque<Float> stack = new ArrayDeque<>();

        for(int key : map.keySet()){
            float time = (float)(target - key) / map.get(key); 
            stack.push(time);
        }
        return stack;
    }

    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Integer> map = createTreeMap(position, speed);
        Deque<Float> stack = createStack(map, target);

        List<Float> res = new ArrayList<>();
        float current = stack.pop();

        res.add(current);

        while(!stack.isEmpty()){
            float num = stack.pop();

            if(num > current) {
                res.add(num);
                current = num;
            }
        }   

        return res.size();
    }
}
