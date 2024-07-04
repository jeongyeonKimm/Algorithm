class Solution {
    public String solution(int n, int t, int m, int p) {
        String numbers = "";
        for (int i = 0; i <= t * m; i++) {
            numbers += Integer.toString(i, n);
        }
        
        numbers = numbers.toUpperCase();
        
        String answer = "";
        for (int i = p - 1; i < numbers.length(); i += m) {
            answer += numbers.charAt(i);
            if (answer.length() == t) break;
        }
        
        return answer;
    }
}