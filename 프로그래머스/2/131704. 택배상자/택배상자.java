import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int target = 0; // 트럭에 실어야 하는 박스의 우선순위
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 1; i <= order.length; i++) {   // i는 박스의 번호
            stack.push(i);
            while (!stack.isEmpty() && stack.peek() == order[target]) {
                stack.pop();
                count++;
                target++;
            }
        }
        
        return count;
    }
}