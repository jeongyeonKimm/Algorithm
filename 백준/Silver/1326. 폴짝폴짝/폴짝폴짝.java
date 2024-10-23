import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] bridge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        bridge = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            bridge[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int result = bfs(a, b);

        System.out.println(result);
    }

    static int bfs(int start, int end) {
        boolean[] visited = new boolean[N + 1];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int next = cur[0];
            int count = cur[1];
            int num = bridge[next];

            while (true) {
                next += num;

                if (next > N) break;
                if (visited[next]) continue;

                visited[next] = true;

                if (next == end) {
                    return count + 1;
                }
                queue.add(new int[] {next, count + 1});
            }

            next = cur[0];
            while (true) {
                next -= num;

                if (next < 1) break;
                if (visited[next]) continue;

                visited[next] = true;

                if (next == end) {
                    return count + 1;
                }
                queue.add(new int[] {next, count + 1});
            }
        }

        return -1;
    }
}
