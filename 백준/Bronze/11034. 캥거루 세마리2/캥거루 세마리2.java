import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String location;

        while ((location = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(location);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int cnt = Math.max(b - a, c - b) - 1;
            System.out.println(cnt);
        }
    }
}