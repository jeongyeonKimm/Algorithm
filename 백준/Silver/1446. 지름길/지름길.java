import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, D;

    static int[] distance;
    static ArrayList<ArrayList<Node>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        distance = new int[10001];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = i;
        }

        graph = new ArrayList<>();
        for (int i = 0; i < 10001; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end, dist));
        }

        dijkstra(0);

        System.out.println(distance[D]);
    }

    static void dijkstra(int start) {
        if (start > D) return;

        if (distance[start + 1] > distance[start] + 1) {
            distance[start + 1] = distance[start] + 1;
        }

        for (int i = 0; i < graph.get(start).size(); i++) {
            Node next = graph.get(start).get(i);
            int cost = distance[start] + next.distance;
            if (cost < distance[next.value]) {
                distance[next.value] = cost;
            }
        }

        dijkstra(start + 1);
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
