import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        result = new int[3];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, n);

        for (int i = 0; i < 3; i++) {
            System.out.println(result[i]);
        }
    }

    static void divide(int row, int col, int size) {
        if (checkPaper(row, col, size)) {
            int num = map[row][col];
            result[num + 1]++;
            return;
        }

        int newSize = size / 3;

        divide(row, col, newSize);
        divide(row, col + newSize, newSize);
        divide(row, col + (newSize * 2), newSize);
        divide(row + newSize, col, newSize);
        divide(row + newSize, col + newSize, newSize);
        divide(row + newSize, col + (newSize * 2), newSize);
        divide(row + (newSize * 2), col, newSize);
        divide(row + (newSize * 2), col + newSize, newSize);
        divide(row + (newSize * 2), col + (newSize * 2), newSize);
    }

    static boolean checkPaper(int row, int col, int size) {
        int num = map[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (num != map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
