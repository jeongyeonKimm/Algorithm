import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] gear;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        gear = new int[4][8];
        StringTokenizer st;
        for (int i = 0; i < 4; i++) {
            String input = br.readLine();
            for (int j = 0; j < 8; j++) {
                gear[i][j] = input.charAt(j) - '0';
            }
        }

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            operateGear(index - 1, direction);
        }

        int result = 0;
        for (int i = 0; i < 4; i++) {
            if (gear[i][0] == 1) {
                result += Math.pow(2, i);
            }
        }

        System.out.println(result);
    }

    private static void operateGear(int index, int direction) {
        leftSide(index - 1, -direction);
        rightSide(index + 1, -direction);
        rotation(index, direction);
    }
    
    private static void leftSide(int index, int direction) {
        if (index < 0) return;
        if (gear[index][2] == gear[index + 1][6]) return;
        leftSide(index - 1, -direction);
        rotation(index, direction);
    }

    private static void rightSide(int index, int direction) {
        if (index > 3) return;
        if (gear[index - 1][2] == gear[index][6]) return;
        rightSide(index + 1, -direction);
        rotation(index, direction);
    }
    
    private static void rotation(int index, int direction) {
        if (direction == 1) {
            int tmp = gear[index][7];
            for (int i = 6; i >= 0; i--) {
                gear[index][i + 1] = gear[index][i];
            }
            gear[index][0] = tmp;
            return;
        }

        int tmp = gear[index][0];
        for (int i = 1; i < 8; i++) {
            gear[index][i - 1] = gear[index][i];
        }
        gear[index][7] = tmp;
    }
}
