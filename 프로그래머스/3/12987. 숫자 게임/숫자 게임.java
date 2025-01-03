import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int a : A) {
            pq.offer(a);
        }
        
        Arrays.sort(B);
        
        Deque<Integer> deque = new ArrayDeque<>();
        for (int b : B) {
            deque.add(b);
        }
        
        // A >= B : 승점 X -> B에 있는 것 중 가장 작은 값 출전
        // A < B : 승점 O
        int score = 0;
        
        while (!deque.isEmpty()) {
            int a = pq.poll();
            int b = deque.peekLast();
            
            if (a < b) {
                score++;
                deque.pollLast();
            } else {
                deque.pollFirst();
            }
        }
        
        return score;
    }
}