import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static HashMap<Long, Long> map;
    static long N, P, Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        map = new HashMap<>();
        map.put(0L, 1L);

        System.out.println(findResult(N));
    }

    static long findResult(long n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        long num1 = findResult((long) Math.floor(n / P));
        long num2 = findResult((long) Math.floor(n / Q));
        long sum = num1 + num2;

        map.put(n, sum);

        return num1 + num2;
    }
}
