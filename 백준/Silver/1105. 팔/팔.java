import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] numbers = br.readLine().split(" ");
        String L = numbers[0];
        String R = numbers[1];

        int result = 0;

        if (L.length() == R.length()) {
            for (int i = 0; i < L.length(); i++) {
                if (L.charAt(i) != R.charAt(i)) {
                    break;
                }

                if (L.charAt(i) == '8') {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
