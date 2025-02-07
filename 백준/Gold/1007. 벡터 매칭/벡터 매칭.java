import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] points;
    private static boolean[] visited;
    private static double result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            result = Double.MAX_VALUE;
            points = new int[n][2];
            visited = new boolean[n];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                points[j][0] = Integer.parseInt(st.nextToken());
                points[j][1] = Integer.parseInt(st.nextToken());
            }
            combination(0, 0, n);
            System.out.println(result);
        }
    }

    private static void combination(int start, int depth, int n) {
        if (depth == n / 2) {
            double vector = calculateVector(n);
            result = Math.min(result, vector);
        }

        for (int i = start; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            combination(i + 1, depth + 1, n);
            visited[i] = false;
        }
    }

    private static double calculateVector(int n) {
        int x = 0;
        int y = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                x += points[i][0];
                y += points[i][1];
            } else {
                x -= points[i][0];
                y -= points[i][1];
            }
        }

        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
}
