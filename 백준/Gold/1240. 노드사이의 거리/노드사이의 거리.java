import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<ArrayList<Node>> graph;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(e, d));
            graph.get(e).add(new Node(s, d));
        }

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int distance = search(node1, node2);
            answer.append(distance + "\n");
        }

        System.out.println(answer);
    }

    static int search(int node1, int node2) {
        boolean[] visited = new boolean[N + 1];

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(node1, 0));
        visited[node1] = true;

        int totalDistance = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int v = cur.value;
            int d = cur.distance;

            if (v == node2) {
                totalDistance = d;
                break;
            }

            for (int i = 0; i < graph.get(v).size(); i++) {
                Node next = graph.get(v).get(i);
                if (!visited[next.value]) {
                    queue.add(new Node(next.value, d + next.distance));
                    visited[next.value] = true;
                }
            }
        }

        return totalDistance;
    }

    static class Node {

        int value;
        int distance;

        public Node(int value, int distance) {
            this.value = value;
            this.distance = distance;
        }
    }
}
