import java.util.*;

class Solution {
    
    private boolean[] opened;
    private int count;
    
    public int solution(int[] cards) {
        int n = cards.length;
        
        opened = new boolean[n + 1];
        List<Integer> scores = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (!opened[i + 1]) {
                count = 1;
                opened[i + 1] = true;
                dfs(cards, cards[i]);
                scores.add(count);
            }
        }
        
        if (scores.size() < 2) return 0;
        
        Collections.sort(scores, Collections.reverseOrder());
        
        return scores.get(0) * scores.get(1); 
    }
    
    private void dfs(int[] cards, int num) {
        if (!opened[num]) {
            opened[num] = true;
            count++;
            dfs(cards, cards[num - 1]);
        }
    }
}