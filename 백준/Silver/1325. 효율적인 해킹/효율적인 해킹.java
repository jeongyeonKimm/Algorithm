import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<List<Integer>> graph;
    static boolean[] visited;
    static int[] count;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        count = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
        }

        for (int i = 1; i < N + 1; i++) {
            visited = new boolean[N + 1];
            dfs(i);
        }

        int maxCount = 0;
        for (int i = 1; i < N + 1; i++) {
            maxCount = Math.max(maxCount, count[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            if (count[i] == maxCount) {
                sb.append(i + " ");
            }
        }

        System.out.println(sb);
    }

    static void dfs(int x) {
        visited[x] = true;

        for (int i : graph.get(x)) {
            if (visited[i]) continue;
            count[i]++;
            dfs(i);
        }
    }
}
