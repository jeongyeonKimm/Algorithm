import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();

        int len = N.length();
        StringBuilder S = new StringBuilder(N);
        boolean flag = false;

        if (S.toString().equals("9".repeat(len))) {
            for (int i = 0; i < len; i++) {
                S.setCharAt(i, '0');
            }
            S.setCharAt(0, '1');
            S.append('1');
            N = "0" + N;
            len++;
        }

        for (int i = len - 1; i >= len / 2; i--) {
            S.setCharAt(i, S.charAt(len - i - 1));
        }

        for (int i = 0; i < len; i++) {
            if (S.charAt(i) != N.charAt(i)) {
                flag = S.charAt(i) > N.charAt(i);
                break;
            }
        }

        for (int i = len / 2; !flag && i < len ; i++) {
            if (S.charAt(i) > N.charAt(i) || S.charAt(len - i - 1) > N.charAt(len - i - 1)) {
                break;
            }

            if (S.charAt(i) == '9') {
                if (len % 2 == 0 || i != len / 2) {
                    S.setCharAt(len - i - 1, '0');
                }
                S.setCharAt(i, '0');
                continue;
            }

            if (S.charAt(i) <= N.charAt(i)) {
                if (i != len - i - 1) {
                    S.setCharAt(len - i - 1, (char) (S.charAt(len - i - 1) + 1));
                }
                S.setCharAt(i, (char) (S.charAt(i) + 1));
                i--;
            }
        }

        System.out.println(S.toString());
    }
}
