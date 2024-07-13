import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        Map<Character, Integer> skillMap = new HashMap<>();

        for (int i = 0; i < skill.length(); i++) {
            skillMap.put(skill.charAt(i), i);
        }

        int count = 0;
        Stack<Character> stack = new Stack<>();

        for (String str : skill_trees) {
            boolean flag = true;
            int idx = 0;
            for (char c : str.toCharArray()) {
                if (skillMap.containsKey(c) && skillMap.get(c) != idx) {
                    flag = false;
                    break;
                }

                while (!stack.isEmpty() && skillMap.containsKey(c)) {
                    if (skillMap.get(stack.peek()) > skillMap.get(c)) {
                        flag = false;
                        break;
                    }
                    stack.pop();
                }

                if (!flag) break;

                if (skillMap.containsKey(c)) {
                    stack.push(c);
                    idx++;
                }
            }
            
            if (flag) count++;
            
            stack.clear();
        }

        return count;
    }
}