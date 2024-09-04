import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = null;
        StringBuilder sb = new StringBuilder();

        while ((s = br.readLine()) != null) {
            int x = Integer.parseInt(s) * 10000000;
            int n = Integer.parseInt(br.readLine());

            int[] rego = new int[n];

            for (int i = 0; i < n; i++) {
                rego[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(rego);

            int left = 0;
            int right = n - 1;
            boolean flag = false;

            while (left < right) {
                int sum = rego[left] + rego[right];

                if (sum == x) {
                    flag = true;
                    break;
                } else if (sum > x) {
                    right--;
                } else {
                    left++;
                }
            }

            if (flag) System.out.printf("yes %d %d\n", rego[left], rego[right]);
            else System.out.println("danger");
        }

        System.out.println(sb.toString());
    }
}
