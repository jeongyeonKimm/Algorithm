import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int[] priority = new int[order.length]; // 각 상자의 우선순위
        for (int i = 0; i < order.length; i++) {
            priority[order[i] - 1] = i;
        }
        
        int target = 0; // 현재 트럭에 실어야 하는 우선순위
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < priority.length; i++) {
            if (target == priority[i]) target++;
            else stack.push(priority[i]);
            
            while (!stack.isEmpty() && target == stack.peek()) {
                stack.pop();
                target++;
            }
        }
        
        return target;
    }
}