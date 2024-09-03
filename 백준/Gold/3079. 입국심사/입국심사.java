import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] time = new long[n];
        for (int i = 0; i < n; i++) {
            time[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(time);

        long result = binarySearch(time, m);
        System.out.println(result);
    }

    static long binarySearch(long[] arr, int m) {
        long start = 1;
        long end = arr[arr.length - 1] * m;

        long result = Long.MAX_VALUE;

        while (start <= end) {
            long mid = (start + end) / 2;

            long sum = 0;
            for (long i : arr) {
                long count = mid / i;

                if (sum >= m) break;

                sum += count;
            }

            if (sum >= m) {
                end = mid - 1;
                result = Math.min(result, mid);
            } else {
                start = mid + 1;
            }
        }

        return result;
    }
}
