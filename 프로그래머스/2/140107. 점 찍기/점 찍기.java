class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for (int i = 0; i <= d; i += k) {
            long dd = (long) d * d;
            long ii = (long) i * i;
            int b = (int) Math.sqrt(dd - ii);
            answer += b / k + 1;
        }
        
        return answer;
    }
}