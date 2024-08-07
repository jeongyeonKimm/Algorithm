import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int n, m;
    private static int dx[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int dy[] = {0, 1, 1, 1, 0, -1, -1, -1};
    private static int[][] map;

    public static class Position {
        int x;
        int y;
        int count;

        public Position(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxCount = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    int count = bfs(i, j);
                    maxCount = Math.max(maxCount, count);
                }
            }
        }

        System.out.println(maxCount);
    }

    private static int bfs(int x, int y) {
        Queue<Position> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        queue.offer(new Position(x, y, 0));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Position cur = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                
                if (visited[nx][ny]) {
                    continue;
                }
                
                if (map[nx][ny] == 1) {
                    return cur.count + 1;
                }

                queue.offer(new Position(nx, ny, cur.count + 1));
                visited[nx][ny] = true;
            }
        }

        return -1;
    }
}