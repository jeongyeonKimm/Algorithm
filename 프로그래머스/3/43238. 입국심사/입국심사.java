import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        int m = times.length;
        long left = 0;
        long right = (long) times[m - 1] * n;
        long answer = 0;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            
            long processed = 0;
            for (int i = 0; i < m; i++) {
                processed += (mid / times[i]);  // mid 시간 동안 각 심사대에서 처리 가능한 사람 수의 합 계산    
            }
            
            if (processed < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }
        
        return answer;
    }
}