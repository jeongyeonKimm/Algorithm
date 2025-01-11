import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int allTypeCount = new HashSet<>(Arrays.asList(gems)).size();
        int n = gems.length;
        
        Map<String, Integer> map = new HashMap<>();
        int minLength = n + 1;
        int start = 0;
        
        int[] answer = new int[2];
        
        for (int end = 0; end < n; end++) {
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
            
            while (map.get(gems[start]) > 1) {
                map.put(gems[start], map.get(gems[start]) - 1);
                start++;
            }
            
            if (map.size() == allTypeCount && minLength > (end - start)) {
                minLength = end - start;
                answer[0] = start + 1;
                answer[1] = end + 1;
            }
        }
        
        return answer;
    }
}