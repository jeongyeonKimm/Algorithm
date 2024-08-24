import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[] censors = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            censors[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(censors);

        int[] distances = new int[n - 1];

        for (int i = 0; i < n - 1; i++) {
            distances[i] = censors[i + 1] - censors[i];
        }

        Arrays.sort(distances);

        int sum = 0;
        for (int i = 0; i < n - k; i++) {
            sum += distances[i];
        }

        System.out.println(sum);
    }
}
