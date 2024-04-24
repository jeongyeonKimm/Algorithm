import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int[][] map;
    private static boolean[][] visited;
    private static int n, m;
    private static int count = 0;

    static class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        int doyeonX = 0;
        int doyeonY = 0;

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'I') {
                    doyeonX = i;
                    doyeonY = j;
                }
            }
        }

        bfs(doyeonX, doyeonY);

        if (count == 0) {
            System.out.println("TT");
        } else {
            System.out.println(count);
        }
    }

    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || map[nx][ny] == 'X') {
                    continue;
                }

                if (map[nx][ny] == 'P') {
                    count++;
                }

                queue.add(new Point(nx, ny));
                visited[nx][ny] = true;
            }
        }
    }
}
