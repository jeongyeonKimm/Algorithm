import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int[] newArr;
    static boolean[] visited;
    static int n;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        newArr = new int[n];
        visited = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0);

        System.out.println(result);
    }

    static void backtracking(int depth) {
        if (depth == n) {
            int cur = getResult();
            result = Math.max(result, cur);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                newArr[depth] = arr[i];
                backtracking(depth + 1);
                visited[i] = false;
            }
        }
    }

    static int getResult() {
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            result += Math.abs(newArr[i] - newArr[i + 1]);
        }
        return result;
    }
}
