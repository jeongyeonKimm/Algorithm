class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        for (int i = 0; i < s.length(); i++) {
            int cnt = 0;
            char ch = s.charAt(i);
            while (cnt < index) {
                ch = ch == 'z' ? 'a' : (char) (ch + 1);
                if (!skip.contains(String.valueOf(ch))) {
                    cnt++;
                }
            }
            answer += ch; 
        }
        return answer;
    }
}