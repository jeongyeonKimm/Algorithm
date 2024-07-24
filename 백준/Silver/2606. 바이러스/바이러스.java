import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int n, pair;
    public static int result = 0;
    public static int[][] map = new int[101][101];
    public static boolean[] visited = new boolean[101];

    public static void dfs(int x) {
        visited[x] = true;

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && map[x][i] == 1) {
                result++;
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        pair = Integer.parseInt(br.readLine());

        for (int i = 0; i < pair; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }

        dfs(1);

        System.out.println(result);
    }
}
