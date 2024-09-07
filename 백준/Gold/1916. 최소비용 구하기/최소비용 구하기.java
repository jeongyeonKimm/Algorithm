import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<List<Node>> busInfo;
    static int[] distance;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        busInfo = new ArrayList<>();
        distance = new int[n + 1];
        visited = new boolean[n + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i < n + 1; i++) {
            busInfo.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight  = Integer.parseInt(st.nextToken());

            busInfo.get(start).add(new Node(end, weight));
        }

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        dijkstra(A);

        System.out.println(distance[B]);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curValue = cur.value;

            if (!visited[curValue]) {
                visited[curValue] = true;

                for (Node node : busInfo.get(curValue)) {
                    int value = node.value;
                    int weight = node.weight;

                    if (!visited[value] && distance[value] > distance[curValue] + weight) {
                        distance[value] = distance[curValue] + weight;
                        pq.add(new Node(value, distance[value]));
                    }
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int value;
        int weight;

        public Node(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {  // PriorityQueue에 Node를 넣기 때문에 compareTo 메소드 정의 해야함
            return this.weight - o.weight;
        }
    }
}
