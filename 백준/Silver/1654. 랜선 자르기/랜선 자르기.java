import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] lanLength = new int[k];
        long max = 0;

        for (int i = 0; i < k; i++) {
            lanLength[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lanLength[i]);
        }

        max++;

        long min = 0;

        while (min < max) {
            long mid = (min + max) / 2;

            int count = 0;
            for (int i = 0; i < k; i++) {
                count += lanLength[i] / mid;
            }

            if (count < n) max = mid;
            else min = mid + 1;
        }

        System.out.println(max - 1);
    }
}
