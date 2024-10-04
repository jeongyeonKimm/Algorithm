import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    public int solution(String[][] book_time) {
        int[][] times = new int[book_time.length][2];
        
        for (int i = 0; i < book_time.length; i++) {
            int start = Integer.parseInt(book_time[i][0].replace(":", ""));
            int end = Integer.parseInt(book_time[i][1].replace(":", ""));
            
            end += 10;
            
            if (end % 100 > 59) {
                end += 40;
            }
            
            times[i][0] = start;
            times[i][1] = end;
        }
        
        Arrays.sort(times, (a, b) -> a[0] - b[0]);  // 시작 시간 기준 정렬
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));  // 종료 시각 기준 정렬
        for (int[] t : times) {
            if (pq.isEmpty()) {
                pq.add(t);
                continue;
            }
            
            int[] prev = pq.peek();
            if (prev[1] <= t[0]) {
                pq.poll();
            }
            pq.add(t);
        }
        
        return pq.size();
    }
}