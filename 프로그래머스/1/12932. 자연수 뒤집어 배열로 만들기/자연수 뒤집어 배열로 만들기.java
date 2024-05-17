class Solution {
    public int[] solution(long n) {
        String num = String.valueOf(n);
        
        int[] answer = new int[num.length()];
        int idx = 0;
        
        while (n > 0) {
            answer[idx++] = (int)(n % 10);
            n /= 10;
        }
        
        return answer;
    }
}