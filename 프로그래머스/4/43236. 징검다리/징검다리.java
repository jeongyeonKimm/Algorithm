import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int min = 1;
        int max = distance; // min, max는 가능한 바위 간 거리의 min, max
        int answer = 0;
        
        Arrays.sort(rocks);
        
        while (min <= max) {
            int mid = (min + max) / 2;
            
            int prev = 0;
            int count = 0;  // 제거된 바위 개수
            for (int rock : rocks) {
                if (rock - prev < mid) {
                    count++;
                    continue;
                }
                prev = rock;
            }
            
            if (distance - prev < mid) count++;
            
            if (count <= n) {
                answer = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        
        return answer;
    }
}