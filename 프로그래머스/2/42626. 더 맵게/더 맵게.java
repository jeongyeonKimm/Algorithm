import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int s : scoville) {
            pq.offer(s);
        }
        
        int count = 0;
        
        while (pq.size() > 1 && pq.peek() < K) {
            int first = pq.poll();
            int second = pq.poll();
            int mix = first + (second * 2);
            pq.offer(mix);
            count++;
        }
        
        if (pq.peek() < K) return -1;
        return count;
    }
}