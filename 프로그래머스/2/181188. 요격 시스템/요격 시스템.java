import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);
        
        int count = 0;
        int prev = 0;
        for (int i = 0; i < targets.length; i++) {
            if (prev <= targets[i][0]) {
                prev = targets[i][1];
                count++;
            }
        }
        
        return count;
    }
}