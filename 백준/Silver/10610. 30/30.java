import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num = br.readLine();
        char[] numbers = num.toCharArray();

        Arrays.sort(numbers);

        int sum = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = numbers.length - 1; i >= 0; i--) {
            sum += numbers[i];
            sb.append(numbers[i]);
        }

        if (numbers[0] != '0' || sum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(sb.toString());
    }
}
