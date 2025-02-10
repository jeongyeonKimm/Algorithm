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
        int count = 0;
        
        for (int[] score : scores) {
            if (score[1] < maxCoWorker) {
                if (score[0] == first && score[1] == second) {
                    return -1;
                }
            } else {
                maxCoWorker = score[1];
                if (score[0] + score[1] > first + second) {
                    count++;
                }
            }
        }
        
        return count + 1;
    }
}