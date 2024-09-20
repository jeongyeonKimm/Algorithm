import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        while (true) {
            int min = n / l - ((l - 1) / 2);
            if (min < 0 || l > 100) {
                sb.append(-1);
                break;
            }

            int sum = (l * min) + ((l - 1) * l / 2);    // min ~ min + (l - 1) 수열의 합
            if (sum == n) {
                for (int i = min; i < min + l; i++) {
                    sb.append(i + " ");
                }
                break;
            }

            l++;    // 길이가 l이고 합이 n인 수열을 찾을 수 없어 l 증가(길이가 적어도 l인 수열을 찾으라고 했기 때문)
        }

        System.out.println(sb);
    }
}
