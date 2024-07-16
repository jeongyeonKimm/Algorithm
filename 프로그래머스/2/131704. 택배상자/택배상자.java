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
            if (target == priority[i]) target++;    // 현재 i번째 우선순위가 찾고자 하는 우선순위와 같으면 트럭에 싣고 찾고자 하는 다음 우선순위로 변경
            else stack.push(priority[i]);   // 같지 않으면 해당 우선순위를 서브 컨테이너에 넣음
            
            // 찾고자 하는 우선순위와 스택의 top가 같으면 스택에서 꺼내고 다음 우선순위로 변경
            while (!stack.isEmpty() && target == stack.peek()) {    
                stack.pop();
                target++;
            }
        }
        
        return target;  // 최종 target의 값은 찾은 최종적으로 우선순위
    }
}