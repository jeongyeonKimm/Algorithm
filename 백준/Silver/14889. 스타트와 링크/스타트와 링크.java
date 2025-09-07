import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int[][] S;
    private static boolean[] visited;
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        S = new int[n][n];
        visited = new boolean[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(0, 0);

        System.out.println(result);
    }

    private static void backtracking(int start, int cnt) {
        if (cnt == n / 2) {
            calculateDiff();
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(i + 1, cnt + 1);
                visited[i] = false;
            }
        }
    }

    private static void calculateDiff() {
        int teamStart = 0;
        int teamLink = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visited[i] && visited[j]) {
                    teamStart += S[i][j];
                    teamStart += S[j][i];
                } else if (!visited[i] && !visited[j]) {
                    teamLink += S[i][j];
                    teamLink += S[j][i];
                }
            }
        }

        int diff = Math.abs(teamStart - teamLink);
        result = Math.min(result, diff);
    }
}
