import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < operations.length; i++) {
            String[] op = operations[i].split(" ");
            String command = op[0];
            int data = Integer.parseInt(op[1]);
            
            if (command.equals("I")) {
                minHeap.offer(data);
                maxHeap.offer(data);
            } else if (command.equals("D")) {
                if (minHeap.isEmpty() && maxHeap.isEmpty()) continue;
                
                if (data == 1) {
                    int maxData = maxHeap.poll();
                    minHeap.remove(maxData);
                } else if (data == -1) {
                    int minData = minHeap.poll();
                    maxHeap.remove(minData);
                }
            }
        }
        
        int[] answer = new int[2];
        
        if (!minHeap.isEmpty() && !maxHeap.isEmpty()) {
            answer[0] = maxHeap.poll();
            answer[1] = minHeap.poll();
        }
        
        return answer;
    }
}