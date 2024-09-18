import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            triangle.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                triangle.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        int[][] sum = new int[n][n];
        sum[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            List<Integer> cur = triangle.get(i);
            for (int j = 0; j < cur.size(); j++) {
                if (j == 0) sum[i][j] += (cur.get(j) + sum[i - 1][0]);
                else if (j == (cur.size() - 1)) sum[i][j] += (cur.get(j) + sum[i - 1][j - 1]);
                else sum[i][j] = Math.max(cur.get(j) + sum[i - 1][j - 1], cur.get(j) + sum[i - 1][j]);
            }
        }

        Arrays.sort(sum[n - 1]);

        System.out.println(sum[n - 1][n - 1]);
    }
}
