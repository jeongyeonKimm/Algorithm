class Solution {
    public int solution(int n) {
        int prev1 = 0;
        int prev2 = 1;
        
        if (n == 0 || n == 1) return n;
        else {
            int tmp;
            for (int i = 2; i <= n; i++) {
                tmp = prev2;
                prev2 = (prev1 + prev2) % 1234567;
                prev1 = tmp % 1234567;
            }
            return prev2;
        }
    }
}