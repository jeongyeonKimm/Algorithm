import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int TILE_SIZE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        TILE_SIZE = 2 * N - 1;

        int height = r2 - r1 + 1;
        int width = c2 - c1 + 1;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < height; i++) {
            int row = r1+ i;
            for (int j = 0; j < width; j++) {
                int col = c1 + j;
                sb.append(getAlphabet(row, col));
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static char getAlphabet(int row, int col) {
        int x = row % TILE_SIZE;
        int y = col % TILE_SIZE;

        // (N - 1, N - 1)의 a를 중심으로 다이아몬드에 채워지는 알파벳은 a로부터의 가로 길이와 세로길이의 합에 해당하는 순서의 알파벳
        int seq = Math.abs(N - 1 - x) + Math.abs(N - 1 - y);

        if (seq < N) {
            return (char) ('a' + (seq % 26));
        }
        return '.';
    }

}
