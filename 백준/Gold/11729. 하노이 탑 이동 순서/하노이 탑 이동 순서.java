import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        hanoi(n, 1, 2, 3);

        System.out.println((int) Math.pow(2, n) - 1);
        System.out.println(sb.toString());
    }

    private static void hanoi(int n, int from, int aux, int to) {
        if (n == 1) {
            sb.append(from + " " + to).append("\n");
            return;
        }

        hanoi(n - 1, from, to, aux);
        sb.append(from + " " + to).append("\n");
        hanoi(n - 1, aux, from, to);
    }
}
