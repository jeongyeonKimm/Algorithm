import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int N, M;
    static int[][] farm;
    static boolean[][] visited;
    static boolean[][] peaks;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        farm = new int[N][M];
        visited = new boolean[N][M];
        peaks = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                farm[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) {
                    continue;
                }
                if (isPeak(i, j)) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    static boolean isPeak(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        visited[x][y] = true;
        int height = farm[x][y];

        boolean flag = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < 8; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if (farm[nx][ny] > height) {
                    flag = false;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                if (farm[nx][ny] == height) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }

            }
        }

        return flag;
    }
}
