import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] requests = new int[n];
        int total = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            requests[i] = Integer.parseInt(st.nextToken());
            total += requests[i];
        }

        Arrays.sort(requests);

        int m = Integer.parseInt(br.readLine());

        if (total <= m) {
            System.out.println(requests[n - 1]);
            return;
        }

        int start = 0;
        int end = requests[n - 1];
        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;

            int sum = 0;
            for (int r : requests) {
                if (r >= mid) sum += mid;
                else sum += r;
            }

            if (sum <= m) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}
