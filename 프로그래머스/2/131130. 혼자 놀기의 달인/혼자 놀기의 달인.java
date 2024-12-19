import java.util.*;

class Solution {
    
    public int solution(int[] cards) {
        int n = cards.length;
        
        boolean[] opened = new boolean[n];
        List<Integer> scores = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int num = i;
            int count = 0;
            
            while (!opened[num]) {
                count++;
                opened[num] = true;
                num = cards[num] - 1;
            }
            scores.add(count);
        }
        
        if (scores.size() < 2) return 0;
        
        Collections.sort(scores, Collections.reverseOrder());
        
        return scores.get(0) * scores.get(1); 
    }
}