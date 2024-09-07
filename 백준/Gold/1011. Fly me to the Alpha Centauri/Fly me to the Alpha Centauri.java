import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int distance = y - x;
            int max = (int) Math.sqrt(distance);

            if (max == Math.sqrt(distance)) {
                sb.append(2 * max - 1).append("\n");
            } else if (distance <= max * max + max) {
                sb.append(2 * max).append("\n");
            } else {
                sb.append(2 * max + 1).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
