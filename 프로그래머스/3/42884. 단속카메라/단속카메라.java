import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        
        int camera = -30000;
        int answer = 0;
        
        for (int[] r : routes) {
            if (camera < r[0]) {
                answer++;
                camera = r[1];
            }
        }
        
        return answer;
    }
}