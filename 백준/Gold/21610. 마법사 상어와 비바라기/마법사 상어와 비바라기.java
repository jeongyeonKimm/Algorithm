import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
    private static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int n, m;
    private static int[][] map;
    private static boolean[][] visited;
    private static Queue<Position> clouds = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clouds.add(new Position(n - 1, 0));
        clouds.add(new Position(n - 1, 1));
        clouds.add(new Position(n - 2, 0));
        clouds.add(new Position(n - 2, 1));

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());

            addWater(d, s);
            waterCopyBug();
            createClouds();
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += map[i][j];
            }
        }

        System.out.println(sum);
    }

    private static void addWater(int d, int s) {
        for (Position cloud : clouds) {
            cloud.r = (cloud.r + (n + dr[d]) * s) % n;
            cloud.c = (cloud.c + (n + dc[d]) * s) % n;
            map[cloud.r][cloud.c]++;
        }
    }

    private static void waterCopyBug() {
        while (!clouds.isEmpty()) {
            Position cloud = clouds.poll();
            visited[cloud.r][cloud.c] = true;

            int count = 0;
            for (int i = 1; i < 8; i += 2) {
                int nr = cloud.r + dr[i];
                int nc = cloud.c + dc[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                    continue;
                }

                if (map[nr][nc] > 0) {
                    count++;
                }
            }

            map[cloud.r][cloud.c] += count;
        }
    }

    private static void createClouds() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] >= 2) {
                    map[i][j] -= 2;
                    clouds.add(new Position(i, j));
                }
            }
        }

        visited = new boolean[n][n];
    }

    static class Position {
        int r;
        int c;

        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
