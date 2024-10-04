import java.util.*;

class Solution {
    
    ArrayList<ArrayList<Integer>> graph;
    boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        graph = new ArrayList<>();
        
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        
        int result = n;
        
        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            graph.get(v1).remove(Integer.valueOf(v2));
            graph.get(v2).remove(Integer.valueOf(v1));
            
            result = Math.min(result, bfs(n, 1));
            
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        
        return result;
    }
    
    int bfs(int n, int start) {
        visited = new boolean[n + 1];
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        int count = 1;
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            
            for (int i = 0; i < graph.get(cur).size(); i++) {
                int next = graph.get(cur).get(i);
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                    count++;
                }
            }
        }
        
        return (int) Math.abs(count - (n - count));
    }
}