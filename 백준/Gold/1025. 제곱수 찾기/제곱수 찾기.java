import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }

        int result = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int di = -n; di <= n; di++) {  // 행의 공차 -n ~ n
                    for (int dj = -m; dj <= m; dj++) {  // 열의 공차 -m ~ m
                        if (di == 0 && dj == 0) continue;   // 공차가 (0, 0)이면 안움직임

                        int ni = i;
                        int nj = j; // 현재 위치
                        int now = 0;

                        while (0 <= ni && ni < n && 0 <= nj && nj < m) {
                            now = now * 10 + arr[ni][nj];

                            int sqrtNow = (int) Math.sqrt(now);
                            if (sqrtNow * sqrtNow == now) result = Math.max(result, now);

                            ni += di;
                            nj += dj;
                        }
                    }
                }
            }
        }

        System.out.println(result);
    }
}
