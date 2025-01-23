import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int n = jobs.length;
        
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        int idx = 0;
        int endTime = 0;
        int totalTime = 0;
        int doneCount = 0;
        
        while (doneCount < n) {
            while (idx < n && jobs[idx][0] <= endTime) {
                pq.offer(jobs[idx]);
                idx++;
            }
            
            if (pq.isEmpty()) {
                endTime = jobs[idx][0];
            } else {
                int[] cur = pq.poll();
                totalTime += (cur[1] + endTime - cur[0]);
                endTime += cur[1];
                doneCount++;
            }
        }
        
        return totalTime / n;
    }
}