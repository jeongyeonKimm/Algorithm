class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || s.charAt(i - 1) == ' ') {
                answer += Character.toUpperCase(s.charAt(i));
                continue;
            }
            answer += s.charAt(i);
        }
        return answer;
    }
}