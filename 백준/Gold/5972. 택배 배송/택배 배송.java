import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] cow;
    static ArrayList<ArrayList<Node>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cow = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            cow[i] = Integer.MAX_VALUE;
        }

        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph.get(A).add(new Node(B, C));
            graph.get(B).add(new Node(A, C));
        }

        dijkstra(1);

        System.out.println(cow[N]);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        cow[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curNum = cur.number;
            int curCow = cur.cows;

            if (cow[curNum] < curCow) continue;

            for (int i = 0; i < graph.get(curNum).size(); i++) {
                Node next = graph.get(curNum).get(i);
                int cows = cow[curNum] + next.cows;
                if (cows < cow[next.number]) {
                    cow[next.number] = cows;
                    pq.offer(new Node(next.number, cow[next.number]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {

        int number;
        int cows;

        public Node(int number, int cows) {
            this.number = number;
            this.cows = cows;
        }

        @Override
        public int compareTo(Node o) {
            if (this.cows < o.cows) {
                return -1;
            }
            return 1;
        }
    }
}
