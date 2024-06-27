import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int p : priorities) {
            queue.offer(p);
        }

        int count = 0;
        while (!queue.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == queue.peek()) {
                    queue.poll();
                    count++;
                    if (i == location) {
                        return count;
                    }
                }
            }      
        }
        return count;
    }
}