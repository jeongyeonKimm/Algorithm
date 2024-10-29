import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int friendly = 0;
        int enemy = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    char color = map[i][j];
                    int count = bfs(i, j, color);
                    if (color == 'W') {
                        friendly += count;
                    } else {
                        enemy += count;
                    }
                }
            }
        }

        System.out.println(friendly + " " + enemy);
    }

    static int bfs(int x, int y, char color) {
        Queue<Soldier> queue = new LinkedList<>();
        queue.offer(new Soldier(x, y, color));
        visited[x][y] = true;

        int count = 0;

        while (!queue.isEmpty()) {
            Soldier cur = queue.poll();
            int curX = cur.x;
            int curY = cur.y;
            char curColor = cur.color;

            count++;

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (!isValid(nx, ny, curColor)) {
                    continue;
                }

                queue.offer(new Soldier(nx, ny, curColor));
                visited[nx][ny] = true;
            }
        }

        return count * count;
    }

    static boolean isValid(int x, int y, char color) {
        return x >= 0 && x < M && y >= 0 && y < N && !visited[x][y] && map[x][y] == color;
    }

    static class Soldier {

        int x;
        int y;
        char color;

        public Soldier(int x, int y, char color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }
}
