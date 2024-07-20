import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] numbers = br.readLine().split(" ");

        int[] line = new int[n];

        for (int i = n - 1, j = 0; i >= 0; i--, j++) {
            int num = Integer.parseInt(numbers[i]);
            if (num == j) {
                line[j] = i + 1;
            } else {
                for (int k = j; k > num; k--) {
                    line[k] = line[k - 1];
                }
                line[num] = i + 1;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i : line) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}
