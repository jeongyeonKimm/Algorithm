import java.util.*;

class Solution {
    
    private List<List<Integer>> graph;
    private int[] distance;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < roads.length; i++) {
            graph.get(roads[i][0]).add(roads[i][1]);
            graph.get(roads[i][1]).add(roads[i][0]);
        }
        
        distance = new int[n + 1];
        Arrays.fill(distance, -1);
        
        bfs(destination);
        
        int[] result = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            result[i] = distance[sources[i]];
        }
        
        return result;
    }
    
    private void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(start);
        distance[start] = 0;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int i = 0; i < graph.get(cur).size(); i++) {
                int next = graph.get(cur).get(i);
                if (distance[next] == -1) {
                    q.offer(next);
                    distance[next] = distance[cur] + 1;
                }
            }
        }
    }
}