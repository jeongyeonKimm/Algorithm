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
            int idx = 0;
            while (idx < L.length() && L.charAt(idx) == R.charAt(idx)) {
                if (L.charAt(idx) == '8') {
                    result++;
                }
                idx++;
            }
        }

        System.out.println(result);
    }
}
