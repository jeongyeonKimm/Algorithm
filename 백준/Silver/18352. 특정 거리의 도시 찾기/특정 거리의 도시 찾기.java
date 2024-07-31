import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        int[] distance = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            distance[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(x);
        distance[x] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i = 0; i < graph.get(cur).size();i++) {
                int next = graph.get(cur).get(i);

                if (distance[next] == -1) {
                    queue.offer(next);
                    distance[next] = distance[cur] + 1;
                }
            }
        }

        boolean flag = false;

        for (int i = 1; i <= n; i++) {
            if (distance[i] == k) {
                System.out.println(i);
                flag = true;
            }
        }

        if (!flag) System.out.println(-1);
    }
}
