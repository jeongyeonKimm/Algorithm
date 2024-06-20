import java.util.Stack;

class Solution {
    public int solution(String s) {
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            String newStr = s.substring(i) + s.substring(0, i);
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < newStr.length(); j++) {
                if (stack.isEmpty()) {
                    stack.push(newStr.charAt(j));
                    continue;
                }
                
                if (newStr.charAt(j) == '(' || 
                    newStr.charAt(j) == '[' || 
                    newStr.charAt(j) == '{') {
                    stack.push(newStr.charAt(j));
                    continue;
                }
                
                if ((newStr.charAt(j) == ')' && stack.peek() == '(') ||
                    (newStr.charAt(j) == ']' && stack.peek() == '[') ||
                    (newStr.charAt(j) == '}' && stack.peek() == '{')) {
                    stack.pop();
                }
            }
            if (stack.isEmpty())  count++;
        }
        
        return count;
    }
}