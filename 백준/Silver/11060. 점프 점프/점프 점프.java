import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] map = new int[n];
        long[] dp = new long[n];

        for (int i = 0; i < n; i++) {
            map[i] = Integer.parseInt(st.nextToken());
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= map[i]; j++) {
                if (i + j >= n) break;
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }

        if (dp[n - 1] != Integer.MAX_VALUE) System.out.println(dp[n - 1]);
        else System.out.println(-1);
    }
}
