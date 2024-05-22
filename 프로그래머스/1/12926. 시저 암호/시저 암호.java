class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i)) && s.charAt(i) + n > 'Z') 
                answer += (char)('A' + s.charAt(i) + n - 'Z' - 1);
            else if (Character.isLowerCase(s.charAt(i)) && s.charAt(i) + n > 'z') 
                answer += (char)('a' + s.charAt(i) + n - 'z' - 1);
            else if (Character.isAlphabetic(s.charAt(i))) 
                answer += (char)(s.charAt(i) + n);
            else answer += s.charAt(i);
         }
        return answer;
    }
}