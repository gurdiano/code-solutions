// https://neetcode.io/problems/partition-labels

// O(n)
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) map.put(s.charAt(i), i);

        int size = 0; int end = 0;
        for(int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);

            end = Math.max(end, map.get(letter));

            size++;
            if(end == i) {
                res.add(size);

                size = 0;
                end = 0;
            }
        }
        
        return res;
    }
}
