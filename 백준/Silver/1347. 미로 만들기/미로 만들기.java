import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dx = {-1, 0, 1, 0};    // 북, 동, 남, 서
    static int[] dy = {0, 1, 0, -1};
    static int direction = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[] path = new char[N];

        String input = br.readLine();
        for (int i = 0; i < N; i++) {
            path[i] = input.charAt(i);
        }

        char[][] map = new char[101][101];
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                map[i][j] = '#';
            }
        }

        map[50][50] = '.';
        int x = 50;
        int y = 50;

        for (int i = 0; i < N; i++) {
            char turn = path[i];

            if (turn == 'F') {
                x += dx[direction];
                y += dy[direction];
                map[x][y] = '.';
            } else {
                changeDirection(turn);
            }
        }

        int leftX = 101;
        int rightX = 0;
        int leftY = 101;
        int rightY = 0;

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (map[i][j] == '.') {
                    leftX = Math.min(i, leftX);
                    leftY = Math.min(j, leftY);
                    rightX = Math.max(i, rightX);
                    rightY = Math.max(j, rightY);
                }
            }
        }

        for (int i = leftX; i <= rightX; i++) {
            for (int j = leftY; j <= rightY; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    static void changeDirection(char turn) {
        if (turn == 'R') {
            direction += 1;
            if (direction > 3) {
                direction = 0;
            }
        } else {
            direction -= 1;
            if (direction < 0) {
                direction = 3;
            }
        }
    }
}
