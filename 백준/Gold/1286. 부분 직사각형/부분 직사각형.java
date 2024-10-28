import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] count = new long[26];

        for (int i = 0; i < N; i++) {
            int x = (i + 1) * (2 * N - i) + (i + N + 1) * (N - i);
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                int y = (j + 1) * (2 * M - j) + (j + M + 1) * (M - j);
                count[input.charAt(j) - 'A'] += x * y;
            }
        }

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            answer.append(count[i] + "\n");
        }

        System.out.println(answer);
    }
}
