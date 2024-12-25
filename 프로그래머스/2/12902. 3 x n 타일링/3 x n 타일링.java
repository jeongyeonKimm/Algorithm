class Solution {
    public int solution(int n) {
        int[] dp = new int[n + 1];
        
        dp[1] = 2;
        dp[2] = 3;
        
        for (int i = 3; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i - 1] % 1000000007 + dp[i - 2] % 1000000007;
            } else {
                dp[i] = (dp[i - 1] * 2 % 1000000007) + dp[i - 2] % 1000000007;
            }
            dp[i] %= 1000000007;
        }
        
        return dp[n];
    }
}