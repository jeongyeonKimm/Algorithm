import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[] buildings;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        buildings = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, countBuildings(i));
        }

        System.out.println(answer);
    }

    private static int countBuildings(int cur) {
        int count = 0;
        double prev = 0;

        for (int i = cur - 1; i >= 0; i--) {
            double slope = (double) (buildings[cur] - buildings[i]) / (cur - i);
            if (i == cur - 1 || slope < prev) {
                count++;
                prev = slope;
            }
        }

        for (int i = cur + 1; i < N; i++) {
            double slope = (double) (buildings[i] - buildings[cur]) / (i - cur);
            if (i == cur + 1 || slope > prev) {
                count++;
                prev = slope;
            }
        }

        return count;
    }
}
