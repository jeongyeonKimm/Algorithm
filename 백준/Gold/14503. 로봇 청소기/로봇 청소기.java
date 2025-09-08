import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int n, m, r, c, d;
    private static int[][] map;
    private static int result = 1;  // 첫 칸은 무조건 청소

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cleaning(r, c, d);

        System.out.println(result);
    }

    private static void cleaning(int x, int y, int d) {
        map[x][y] = -1;

        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4;    // 반시계 90도 회전
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
            }

            if (map[nx][ny] == 0) {
                result++;
                cleaning(nx, ny, d);
                return;
            }
        }

        int back = (d + 2) % 4;
        int bx = x + dx[back]; // 후진했을 때 위치
        int by = y + dy[back]; // 후진했을 때 위치

        if (bx >= 0 && bx < n && by >= 0 && by < m && map[bx][by] != 1) {
            cleaning(bx, by, d); // 후진해도 방향은 유지
        }
    }
}
