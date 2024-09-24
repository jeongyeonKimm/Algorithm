import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        int[] dice = new int[6];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        long[] result = new long[3];
        result[0] = 5 * (long) Math.pow(N - 2, 2) + 4 * (N - 2);
        result[1] = 8 * (N - 2) + 4;
        result[2] = 4;

        if (N == 1) {
            Arrays.sort(dice);
            int sum = 0;
            for (int i = 0; i < 5; i++) {
                sum += dice[i];
            }
            System.out.println(sum);
            return;
        }

        // A(0)-F(5), B(1)-E(4), C(2)-D(3)
        long oneSide = Long.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            oneSide = Math.min(oneSide, dice[i]);
        }

        long twoSide = Long.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                if (i + j != 5) {
                    twoSide = Math.min(twoSide, dice[i] + dice[j]);
                }
            }
        }

        long threeSide = 0;
        for (int i = 0; i < 3; i++) {
            threeSide += Math.min(dice[i], dice[5 - i]);
        }


        result[0] *= oneSide;
        result[1] *= twoSide;
        result[2] *= threeSide;

        System.out.println(result[0] + result[1] + result[2]);
    }
}
