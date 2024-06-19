import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> tangerineCount = new HashMap<>();
        for (int t : tangerine) {
            tangerineCount.put(t, tangerineCount.getOrDefault(t, 0) + 1);
        }
        
        List<Integer> counts = new ArrayList<>(tangerineCount.values());
        Collections.sort(counts, Collections.reverseOrder());
       
        int sum = 0;
        int answer = 0;
        for (int c : counts) {
            if (sum + c >= k) {
                answer++;
                break;
            } else {
                sum += c;
                answer++;
            }
        }
        
        return answer;
    }
}