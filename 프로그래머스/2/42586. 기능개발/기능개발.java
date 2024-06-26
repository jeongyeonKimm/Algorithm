import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int days = (100 - progresses[i]) % speeds[i] == 0 ?
                        (100 - progresses[i]) / speeds[i] : 
                        ((100 - progresses[i]) / speeds[i]) + 1;
            queue.offer(days);
        }
        
        List<Integer> deploy = new ArrayList<>();
        
        int prev = queue.poll();
        int count = 1;
        while (!queue.isEmpty()) {
            int cur = queue.peek();
            if (prev >= cur) {
                count++;
                queue.poll();
            } else {
                deploy.add(count);
                prev = queue.poll();
                count = 1;
            }
        }
        deploy.add(count);
        
        return deploy.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}