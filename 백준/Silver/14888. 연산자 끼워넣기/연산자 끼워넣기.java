import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int maxResult = Integer.MIN_VALUE;
    private static int minResult = Integer.MAX_VALUE;
    private static int n;
    private static int[] numbers;
    private static int[] operators = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        numbers = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(numbers[0], 1);

        System.out.println(maxResult);
        System.out.println(minResult);
    }

    private static void backtracking(int value, int cnt) {
        if (cnt == n) {
            maxResult = Math.max(value, maxResult);
            minResult = Math.min(value, minResult);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;

                switch (i) {
                    case 0:
                        backtracking(value + numbers[cnt], cnt + 1);
                        break;
                    case 1:
                        backtracking(value - numbers[cnt], cnt + 1);
                        break;
                    case 2:
                        backtracking(value * numbers[cnt], cnt + 1);
                        break;
                    case 3:
                        backtracking(value / numbers[cnt], cnt + 1);
                        break;
                }

                operators[i]++;
            }
        }
    }
}
