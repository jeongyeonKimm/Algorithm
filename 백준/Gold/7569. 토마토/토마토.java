import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, 0, -1, 1};
    static int[] dz = {-1, 1, 0, 0, 0, 0};
    static int[][][] box;
    static int m, n, h;
    static int minDay = 0;
    static Queue<Tomato> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        box = new int[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 1) {
                        queue.offer(new Tomato(i, j, k, 0));
                    }
                }
            }
        }

        bfs();

        if (checkBox()) System.out.println(minDay);
        else System.out.println(-1);
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();
            minDay = tomato.count;
            for (int i = 0; i < 6; i++) {
                int nx = tomato.x + dx[i];
                int ny = tomato.y + dy[i];
                int nz = tomato.z + dz[i];

                if (nx < 0 || nx >= h || ny < 0 || ny >= n || nz < 0 || nz >= m) {
                    continue;
                }

                if (box[nx][ny][nz] == 0) {
                    queue.offer(new Tomato(nx, ny, nz, minDay + 1));
                    box[nx][ny][nz] = 1;
                }
            }
        }
    }

    static boolean checkBox() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (box[i][j][k] == 0) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    static class Tomato {
        int x;
        int y;
        int z;
        int count;

        public Tomato(int x, int y, int z, int count) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.count = count;
        }
    }
}
