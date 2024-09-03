import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] liquids = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            liquids[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(liquids);

        int start = 0;
        int end = n - 1;
        int min = Integer.MAX_VALUE;

        int result1 = liquids[start];
        int result2 = liquids[end];

        while (start < end) {
            int sum = liquids[start] + liquids[end];
            
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                result1 = liquids[start];
                result2 = liquids[end];
            }

            if (sum < 0) start++;
            else end--;
        }

        System.out.println(result1 + " " + result2);
    }
}
