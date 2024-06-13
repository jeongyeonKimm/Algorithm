class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        
        String answer = "";
        boolean flag = true;
        
        for (char c : s.toCharArray()) {
            answer += flag ? Character.toUpperCase(c) : c;
            flag = c == ' ' ? true : false;
        }
        return answer;
    }
}