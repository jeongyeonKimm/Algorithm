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

        int left = 0;
        int right = n - 1;
        int min = Integer.MAX_VALUE;

        int result1 = liquids[left];
        int result2 = liquids[right];

        while (left < right) {
            int sum = liquids[left] + liquids[right];

            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                result1 = liquids[left];
                result2 = liquids[right];
            }

            if (sum < 0) left++;
            else right--;
        }

        System.out.println(result1 + " " + result2);
    }
}
