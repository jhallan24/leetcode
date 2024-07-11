class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                
                for (char reversedChar : sb.toString().toCharArray()) {
                    stack.push(reversedChar);
                }
            } else {
               
                stack.push(ch);
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }
        
        return result.toString();
    }

}