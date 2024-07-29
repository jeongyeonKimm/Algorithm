import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> onBridge = new LinkedList<>();
        
        for (int i = 0; i < bridge_length; i++) {
            onBridge.offer(0);
        }
        
        int second = 0;
        int sum = 0;
        int idx = 0;
        
        while (idx < truck_weights.length) {
            sum -= onBridge.poll();
            second++;
            
            if (sum + truck_weights[idx] <= weight) {
                onBridge.offer(truck_weights[idx]);
                sum += truck_weights[idx];
                idx++;
            } else {
                onBridge.offer(0);
            }
        }
        
        while (!onBridge.isEmpty()) {
            onBridge.poll();
            second++;
        }
    
        return second;
    }
}