import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static int n, k, l;
    private static int[][] map;
    private static Map<Integer, Character> info = new HashMap<>();
    private static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        map = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            map[row - 1][col - 1] = 1;
        }

        l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            info.put(x, c);
        }

        move();

        System.out.println(time);
    }

    private static void move() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        map[0][0] = 2;

        int x = 0;
        int y = 0;
        int d = 0;
        time = 0;

        while (true) {
            time++;

            int nx = x + dx[d];
            int ny = y + dy[d];

            if (isFinished(nx, ny)) {
                break;
            }

            if (map[nx][ny] == 0) {
                int[] tail = queue.poll();
                map[tail[0]][tail[1]] = 0;
            }
            map[nx][ny] = 2;
            queue.add(new int[] {nx, ny});

            if (info.containsKey(time)) {
                if (info.get(time).equals('L')) {
                    d = (d - 1 + 4) % 4;
                } else {
                    d = (d + 1) % 4;
                }
            }

            x = nx;
            y = ny;
        }
    }

    private static boolean isFinished(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n) {
            return true;
        }

        if (map[x][y] == 2) {
            return true;
        }

        return false;
    }
}
