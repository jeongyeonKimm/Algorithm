import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] B = new int[N];
        int[] gap = new int[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            gap[i] = A[i] - B[i];
        }

        Arrays.sort(gap);

        if (N % 2 == 0) System.out.println(Math.abs(gap[N / 2] - gap[N / 2 - 1] + 1));
        else System.out.println(1);
    }
}
