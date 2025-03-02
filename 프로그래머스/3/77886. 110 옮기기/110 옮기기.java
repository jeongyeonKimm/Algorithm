import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        // 110을 뽑고 남은 문자열에 0이 있는 경우 마지막 0 뒤에 110을 넣으면 가장 작음
        // 0이 없는 경우 맨 앞에 110을 넣으면 가장 작음
        String[] result = new String[s.length];
        
        for (int i = 0; i < s.length; i++) {
            Stack<Character> stack = new Stack<>();
            int count = 0;

            for (int j = 0; j < s[i].length(); j++) {
                stack.push(s[i].charAt(j));
                
                if (stack.size() >= 3) {
                    char first = stack.pop();
                    if (first != '0') {
                        stack.push(first);
                        continue;
                    }

                    char second = stack.pop();
                    if (second != '1') {
                        stack.push(second);
                        stack.push(first);
                        continue;
                    }

                    char third = stack.pop();
                    if (third != '1') {
                        stack.push(third);
                        stack.push(second);
                        stack.push(first);
                        continue;
                    }

                    count++;
                }
            }

            StringBuilder sb = new StringBuilder();
            boolean flag = false;
            int idx = stack.size();

            while(!stack.isEmpty()) {
                char c = stack.pop();
                if (!flag && c == '1') {
                    idx--;
                }

                if (c == '0') {
                    flag = true;
                }

                sb.insert(0, c);
            }

            for (int j = 0; j < count; j++) {
                sb.insert(idx, "110");
            }

            result[i] = sb.toString();
        }
        
        return result;
    }
}