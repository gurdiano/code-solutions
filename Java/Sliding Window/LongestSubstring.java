// https://neetcode.io/problems/longest-substring-without-duplicates

// O(n)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();

        int l = 0, max = 0;
        for (int r = 0; r < s.length(); r++){ 
            char c = s.charAt(r);

            while (set.contains(c)) { 
                set.remove(s.charAt(l));
                l++;
            }
            set.add(c);
            max = Math.max(max, (r - l + 1));
        }

        return max;
    }
}
