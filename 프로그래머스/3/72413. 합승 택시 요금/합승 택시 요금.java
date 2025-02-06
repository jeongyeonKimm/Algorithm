import java.util.*;

class Solution {
    
    private ArrayList<ArrayList<Edge>> graph;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] fare : fares) {
            int u = fare[0];
            int v = fare[1];
            int c = fare[2];
            
            graph.get(u).add(new Edge(v, c));
            graph.get(v).add(new Edge(u, c));
        }
        
        int[] together = dijkstra(n, s);
        int[] aloneA = dijkstra(n, a);
        int[] aloneB = dijkstra(n, b);
        
        int minCost = Integer.MAX_VALUE;
        for (int i = 1; i < n + 1; i++) {
            minCost = Math.min(minCost, together[i] + aloneA[i] + aloneB[i]);    
        }
        
        return minCost;
    }
    
    private int[] dijkstra(int n, int start) {
        int[] cost = new int[n + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        cost[start] = 0;
        
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int cIndex = cur.index;
            int cCost = cur.cost;
            
            if (cost[cIndex] < cCost) continue;
            
            ArrayList<Edge> edges = graph.get(cIndex);
            for (Edge e : edges) {
                int c = cCost + e.cost;
                if (c < cost[e.index]) {
                    cost[e.index] = c;
                    pq.offer(new Edge(e.index, c));
                }
            }
        }
        
        return cost;
    }
    
    static class Edge implements Comparable<Edge> {
        
        int index;
        int cost;
        
        public Edge(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Edge e) {
            return this.cost - e.cost;
        }
    }
}