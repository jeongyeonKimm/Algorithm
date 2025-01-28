class Solution {
    public int solution(int n, int[] money) {
        int[] dp = new int[n + 1];
        
        for (int m : money) {
            if (m > n) continue;
            
            dp[m]++;
            for (int i = 1; i <= n; i++) {
                if (i - m >= 0) {
                    dp[i] += (dp[i - m] % 1000000007);
                    dp[i] %= 1000000007;
                }
            }
        }
        
        return dp[n];
    }
}