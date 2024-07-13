import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] A = new int[n];
        int[] B = new int[n];

        String inputA = br.readLine();
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(inputA.split(" ")[i]);
        }

        String inputB = br.readLine();
        for (int i = 0; i < n; i++) {
            B[i] = Integer.parseInt(inputB.split(" ")[i]);
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int S = 0;

        for (int i = 0; i < n; i++) {
            S += A[i] * B[n - 1 - i];
        }

        System.out.println(S);
    }
}
