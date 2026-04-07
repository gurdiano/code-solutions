// https://neetcode.io/problems/evaluate-reverse-polish-notation

// O(n)
class Solution {
    public void joker(String operation, Deque<Integer> stack) {
        int a = stack.pop();
        int b = stack.pop();

        if(operation.equals("+")) stack.push(b + a);
        if(operation.equals("-")) stack.push(b - a);
        if(operation.equals("*")) stack.push(b * a);
        if(operation.equals("/")) stack.push(b / a);

        System.out.println();
    }
    
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(String str : tokens) {
            if ("+-/*".contains(str)) joker(str, stack);

            else {
                int number = Integer.parseInt(str);
                stack.push(number);
            }
        }
    
        return stack.pop();
    }
}
