// https://leetcode.com/problems/valid-anagram/

// O(n)
class Solution {
    public boolean isAnagram(String s, String t) {
		if(s.length() != t.length()) return false;
			
		int[] alphabetPos = new int[26];
		for(int i = 0; i < s.length(); i++) {
			alphabetPos[s.charAt(i) - 'a']++;
			alphabetPos[t.charAt(i) - 'a']--;
		}
		
		for(int letterPos : alphabetPos) {
			if(letterPos != 0) return false;
		}
	    return true;  
    }
}
