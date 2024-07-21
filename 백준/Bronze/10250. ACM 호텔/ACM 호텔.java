import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            String floor;
            if (n % h == 0) floor = String.valueOf(h);
            else floor = String.valueOf(n % h);

            String room;
            if (n % h == 0) room = String.valueOf(n / h);
            else room = String.valueOf((n / h) + 1);

            if (room.length() < 2) room = "0" + room;

            System.out.println(floor + room);
        }
    }
}
