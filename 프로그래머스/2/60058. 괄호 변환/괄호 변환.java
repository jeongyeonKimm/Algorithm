import java.util.Stack;

class Solution {
    public String solution(String p) {
        if (isCorrectString(p)) return p;
        return makeCorrectString(p);
    }
    
    String makeCorrectString(String s) {
        if (s.length() == 0) {
            return s;
        }
        
        int open = 0;
        int close = 0;
        String u = "";
        String v = "";
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                open++;
            } else {
                close++;
            }
            
            if (open > 0 && close > 0 && open == close) {
                u = s.substring(0, i + 1);
                if (i < s.length() - 1) {
                    v = s.substring(i + 1);
                }
                break;
            }
        }
        
        if (isCorrectString(u)) {
            return u + makeCorrectString(v);
        } else {
            String newString = "(";
            newString += makeCorrectString(v);
            newString += ")";
            newString += reverseString(u.substring(1, u.length() - 1));
            return newString;
        }
    }
    
    boolean isCorrectString(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        
        if (stack.isEmpty()) return true;
        else return false;
    }
    
    String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                sb.append(")");
            } else {
                sb.append("(");
            }
        }
        
        return sb.toString();
    }
}