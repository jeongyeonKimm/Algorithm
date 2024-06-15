import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (stack.isEmpty() || stack.peek() != c) stack.push(c);
            else stack.pop();
        }
        
        if (stack.isEmpty()) return 1;
        return 0;
    }
}