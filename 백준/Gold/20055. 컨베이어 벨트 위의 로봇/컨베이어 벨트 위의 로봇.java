import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] belt = new int[2 * n];
        boolean[] robot = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        while (true) {
            result++;

            int tmp = belt[2 * n - 1];
            for (int i = 2 * n - 1; i > 0; i--) {
                belt[i] = belt[i - 1];
            }
            belt[0] = tmp;

            for (int i = n - 1; i > 0; i--) {
                robot[i] = robot[i - 1];
            }
            robot[0] = false;
            robot[n - 1] = false;

            for (int i = n - 1; i > 0; i--) {
                if (robot[i - 1] && !robot[i] && belt[i] > 0) {
                    robot[i - 1] = false;
                    robot[i] = true;
                    belt[i]--;
                }
            }

            if (belt[0] > 0) {
                robot[0] = true;
                belt[0]--;
            }

            int cnt = 0;
            for (int i = 0; i < 2 * n; i++) {
                if (belt[i] <= 0) cnt++;
            }

            if (cnt >= k) break;
        }

        System.out.println(result);
    }
}
