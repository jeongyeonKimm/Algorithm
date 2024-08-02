import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        System.out.println(bfs(a, b));
    }

    private static int bfs(long a, long b) {
        Queue<Long> queue = new LinkedList<>();

        queue.offer(a);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                long num = queue.poll();

                if (num == b) {
                    return count + 1;
                }

                if (num * 2 <= b) {
                    queue.offer(num * 2);
                }
                if (num * 10 + 1 <= b) {
                    queue.offer(num * 10 + 1);
                }
            }
            count++;
        }

        return -1;
    }
}
