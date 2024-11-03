import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static HashMap<Long, Long> map;
    static long N, P, Q, X, Y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());
        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());

        map = new HashMap<>();

        System.out.println(findResult(N));
    }

    static long findResult(long n) {
        if (n <= 0) {
            return 1L;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }

        long num1 = findResult((long) (Math.floor(n / P) - X));
        long num2 = findResult((long) (Math.floor(n / Q) - Y));
        long sum = num1 + num2;

        map.put(n, sum);

        return sum;
    }
}
