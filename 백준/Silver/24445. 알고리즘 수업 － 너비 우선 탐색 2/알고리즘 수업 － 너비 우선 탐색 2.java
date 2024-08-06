import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static List<List<Integer>> graph;
    private static boolean[] visited;
    private static int[] sequence;
    private static int n, m, r;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        visited = new boolean[n + 1];
        sequence = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
            Collections.reverse(graph.get(i));
        }

        bfs();

        for (int i = 1; i <= n; i++) {
            System.out.println(sequence[i]);
        }
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        int idx = 1;

        queue.offer(r);
        visited[r] = true;
        sequence[r] = idx++;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 0; i < graph.get(cur).size(); i++) {
                int next = graph.get(cur).get(i);

                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                    sequence[next] = idx++;
                }
            }
        }
    }
}
