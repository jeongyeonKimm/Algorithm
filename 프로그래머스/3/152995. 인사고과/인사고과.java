import java.util.Arrays;

class Solution {
    public int solution(int[][] scores) {
        int first = scores[0][0];
        int second = scores[0][1];
        
        Arrays.sort(scores, (s1, s2) -> {
            if (s1[0] == s2[0]) {
                return s1[1] - s2[1];
            }
            return s2[0] - s1[0];
        });
        
        int maxCoWorker = scores[0][1];
        
        for (int i = 1; i < scores.length; i++) {
            if (scores[i][1] < maxCoWorker) {
                if (scores[i][0] == first && scores[i][1] == second) {
                    return -1;
                }
                
                scores[i][0] = -1;
                scores[i][1] = -1;
            } else {
                maxCoWorker = scores[i][1];
            }
        }
        
        Arrays.sort(scores, (s1, s2) -> (s2[0] + s2[1]) - (s1[0] + s1[1]));
        
        int count = 0;
        
        for (int i = 0; i < scores.length; i++) {
            if (scores[i][0] + scores[i][1] <= first + second) {
                break;
            }
            
            count++;
        }
        
        return count + 1;
    }
}