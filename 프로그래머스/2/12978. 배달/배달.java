import java.util.*;

class Solution {
    
    ArrayList<ArrayList<Node>> graph;
    int[] distance;
    
    public int solution(int N, int[][] road, int K) {
        graph = new ArrayList<>();
        
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        
        distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        for (int i = 0; i < road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int dist = road[i][2];
            
            graph.get(a).add(new Node(b, dist));
            graph.get(b).add(new Node(a, dist));
        }
        
        dijkstra(1);
        
        int result = 0;
        for (int i = 1; i < N + 1; i++) {
            if (distance[i] <= K) {
                result++;
            }
        }
        
        return result;
    }
    
    void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance[start] = 0;
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int node = cur.value;
            int d = cur.dist;
            
            for (Node next : graph.get(node)) {
                int cost = distance[node] + next.dist;
                if (cost < distance[next.value]) {
                    distance[next.value] = cost;
                    pq.offer(new Node(next.value, cost));
                }
            }
        }
    }
    
    class Node implements Comparable<Node> {
        
        int value;
        int dist;
        
        public Node(int value, int dist) {
            this.value = value;
            this.dist = dist;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }
}