import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] triangle = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] sum = new int[n][n];
        sum[0][0] = triangle[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) sum[i][j] += triangle[i][0] + sum[i - 1][0];
                else if (j == i) sum[i][j] += (triangle[i][i] + sum[i - 1][i - 1]);
                else sum[i][j] = Math.max(triangle[i][j] + sum[i - 1][j - 1], triangle[i][j] + sum[i - 1][j]);
            }
        }

        Arrays.sort(sum[n - 1]);

        System.out.println(sum[n - 1][n - 1]);
    }
}
