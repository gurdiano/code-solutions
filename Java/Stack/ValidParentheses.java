// https://neetcode.io/problems/validate-parentheses

// O(n)
class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();

        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for(int i = 0; i < s.length(); i++) { 
            Character special = s.charAt(i);
            Character c = null;

            if(map.containsValue(special)) stack.push(special);
            else if(map.containsKey(special)) c = special;
            
            if(c != null) {
                if (stack.isEmpty() || !stack.pop().equals(map.get(c))) return false;
            }
        }
        
        return stack.isEmpty();
    }
}
