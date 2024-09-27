import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int deleteNode;
    static int[] parent;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        parent = new int[N];
        visited = new boolean[N];
        int root = -1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            parent[i] = Integer.parseInt(st.nextToken());

            if (parent[i] == -1) {
                root = i;
            } else {
                graph[parent[i]].add(i);
            }
        }

        deleteNode = Integer.parseInt(br.readLine());
        if (deleteNode == root) {
            System.out.println(0);
            return;
        }

        dfs(root);

        System.out.println(result);
    }

    static void dfs(int root) {
        visited[root] = true;

        int count = 0;
        for (int child : graph[root]) {
            if (child != deleteNode && !visited[child]) {
                count++;
                dfs(child);
            }
        }

        if (count == 0) {
            result++;
        }
    }
}
