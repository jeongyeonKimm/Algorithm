import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[] arr;
    private static int n;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        // Queen이 서로 공격하지 못하려면 같은 행, 열, 대각선에 위치하지 않으면 됨
        dfs(0);
        System.out.println(count);
    }

    private static void dfs(int depth) {
        if (depth == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            // 하나의 행에는 하나의 값만 가짐
            arr[depth] = i;
            if (possible(depth)) {
                dfs(depth + 1);
            }
        }
    }

    private static boolean possible(int col) {
        for (int i = 0; i < col; i++) {
            // 같은 열에 존재
            if (arr[col] == arr[i]) {
                return false;
            }

            // 대각선에 존재
            if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }

        return true;
    }
}
