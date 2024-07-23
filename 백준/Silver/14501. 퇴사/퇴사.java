import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] T = new int[n];
        int[] P = new int[n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            T[i] = Integer.parseInt(input[0]);
            P[i] = Integer.parseInt(input[1]);
        }

        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (i + T[i] <= n) {
                dp[i + T[i]] = Math.max(dp[i] + P[i], dp[i + T[i]]);
            }
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }

        System.out.println(dp[n]);
    }
}
