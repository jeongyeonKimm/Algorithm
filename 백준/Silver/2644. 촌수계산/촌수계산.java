import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static int count = -1;
    private static List<List<Integer>> relation;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] mans = br.readLine().split(" ");
        int man1 = Integer.parseInt(mans[0]);
        int man2 = Integer.parseInt(mans[1]);

        int m = Integer.parseInt(br.readLine());

        relation = new ArrayList<>();
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            relation.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            mans = br.readLine().split(" ");
            int x = Integer.parseInt(mans[0]);
            int y = Integer.parseInt(mans[1]);
            relation.get(x).add(y);
            relation.get(y).add(x);
        }

        dfs(man1, man2, 0);

        System.out.println(count);
    }

    private static void dfs(int start, int end, int depth) {
        if (start == end) {
            count = depth;
            return;
        }

        visited[start] = true;

        for (int i = 0; i < relation.get(start).size(); i++) {
            int child = relation.get(start).get(i);

            if (!visited[child]) {
                dfs(child, end, depth + 1);
            }
        }
    }
}
