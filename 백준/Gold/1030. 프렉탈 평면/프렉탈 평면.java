import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int s, N, K, R1, R2, C1, C2;
    private static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R1 = Integer.parseInt(st.nextToken());
        R2 = Integer.parseInt(st.nextToken());
        C1 = Integer.parseInt(st.nextToken());
        C2 = Integer.parseInt(st.nextToken());

        result = new int[R2 - R1 + 1][C2 - C1 + 1];

        fractal(0, 0, (int) Math.pow(N, s), false);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R2 - R1 + 1; i++) {
            for (int j = 0; j < C2 - C1 + 1; j++) {
                sb.append(result[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void fractal(int x, int y, int size, boolean isBlack) {
        if (x > R2 || x + size <= R1 || y > C2 || y + size <= C1) {
            return;
        }

        if (size == 1) {
            result[x - R1][y - C1] = isBlack ? 1 : 0;
            return;
        }

        int nSize = size / N;
        int blackStart = (N - K) / 2;
        int blackEnd = N - ((N - K) / 2);

        for (int i = 0; i < N; i++) {
            int nx = x + nSize * i;
            for (int j = 0; j < N; j++) {
                int ny = y + nSize * j;
                fractal(nx, ny, nSize,
                        isBlack || (i >= blackStart) && (i < blackEnd) && (j >= blackStart) && (j < blackEnd));
            }
        }
    }
}
