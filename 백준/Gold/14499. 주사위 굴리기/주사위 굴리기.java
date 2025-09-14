import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};
    private static int n, m, x, y, k;
    private static int[][] map;
    private static int[] dice;
    private static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dice = new int[6];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int direction = Integer.parseInt(st.nextToken());
            move(direction);
        }

        System.out.println(result);
    }

    private static void move(int direction) {
        int nx = x + dx[direction - 1];
        int ny = y + dy[direction - 1];

        if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
            return;
        }

        rotate(direction);

        if (map[nx][ny] == 0) {
            map[nx][ny] = dice[5];
        } else {
            dice[5] = map[nx][ny];
            map[nx][ny] = 0;
        }

        result.append(dice[0]).append("\n");

        x = nx;
        y = ny;
    }

    private static void rotate(int direction) {
        int tmp = dice[5];
        switch (direction) {
            case 1:
                dice[5] = dice[2];
                dice[2] = dice[0];
                dice[0] = dice[3];
                dice[3] = tmp;
                break;
            case 2:
                dice[5] = dice[3];
                dice[3] = dice[0];
                dice[0] = dice[2];
                dice[2] = tmp;
                break;
            case 3:
                dice[5] = dice[1];
                dice[1] = dice[0];
                dice[0] = dice[4];
                dice[4] = tmp;
                break;
            case 4:
                dice[5] = dice[4];
                dice[4] = dice[0];
                dice[0] = dice[1];
                dice[1] = tmp;
                break;
        }
    }
}
