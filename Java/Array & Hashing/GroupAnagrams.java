// https://leetcode.com/problems/group-anagrams/

// O(N∗K)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Integer, List<String>> map = new HashMap<>();
        
        for(String word : strs){
            int[] alphabetPos = new int[26];
            
            for(int i = 0; i < word.length(); i++) alphabetPos[word.charAt(i) - 'a']++;

            int key = Arrays.hashCode(alphabetPos);
            if(map.containsKey(key)) map.get(key).add(word);
            else map.put(key, new ArrayList<>(List.of(word)));
        }

        return new ArrayList<>(map.values());
    }
}