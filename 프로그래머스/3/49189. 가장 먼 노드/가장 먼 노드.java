import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int[] distance = new int[n + 1];
        Arrays.fill(distance, (int) (1e9));
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        
        pq.offer(new int[] {0, 1});
        distance[1] = 0;
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0];
            int now = cur[1];
            
            if (distance[now] < d) {
                continue;
            }
            
            for (int i = 0; i < graph.get(now).size(); i++) {
                int idx = graph.get(now).get(i);
                int cost = d + 1;
                if (cost < distance[idx]) {
                    distance[idx] = cost;
                    pq.offer(new int[] {cost, idx});
                }
            }
        }
        
        int maxDistance = 0;
        for (int i = 1; i < n + 1; i++) {
            maxDistance = Math.max(maxDistance, distance[i]);
        }
        
        int result = 0;
        for (int i = 1; i < n + 1; i++) {
            if (distance[i] == maxDistance) result++;
        }
        
        return result;
    }
}