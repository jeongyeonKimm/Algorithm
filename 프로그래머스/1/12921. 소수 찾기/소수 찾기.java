class Solution {
    public int solution(int n) {
        int[] arr = new int[n + 1];
        
        for (int i = 2; i <= n; i++) {
            if (arr[i] == 1) continue;
            
            for (int j = 2 * i; j <= n; j += i) {
                arr[j] = 1;
            }
        }
        
        int result = 0;
        for (int i = 2; i <= n; i++) {
            if (arr[i] != 1) result++;
        }
        return result;
    }
}