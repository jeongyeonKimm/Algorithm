class Solution {
    public long solution(int[] sequence) {
        int n = sequence.length;
        
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        boolean isPlus = true;
        
        for (int i = 0; i < n; i++) {
            arr1[i] = isPlus ? sequence[i] : -sequence[i];
            arr2[i] = isPlus ? -sequence[i] : sequence[i];
            isPlus = !isPlus;
        }
        
        long[] dp1 = new long[n];
        long[] dp2 = new long[n];
        
        dp1[0] = arr1[0];        
        dp2[0] = arr2[0];
        
        for (int i = 1; i < n; i++) {
            dp1[i] = Math.max(arr1[i] + dp1[i - 1], arr1[i]);
            dp2[i] = Math.max(arr2[i] + dp2[i - 1], arr2[i]);
        }
        
        long maxSum = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, dp1[i]);
            maxSum = Math.max(maxSum, dp2[i]);
        }
        
        return maxSum;
    }
}