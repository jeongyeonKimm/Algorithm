import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N, K;
    static int result = Integer.MAX_VALUE;
    static boolean[] visited;
    static final int MAX_POS = 100000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        visited = new boolean[MAX_POS + 1];

        bfs();

        System.out.println(result);
    }

    static void bfs() {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(N, 0));

        while (!queue.isEmpty()) {
            Position cur = queue.poll();
            visited[cur.pos] = true;

            if (cur.pos == K) {
                result = Math.min(result, cur.time);
            }

            if (cur.pos * 2 <= MAX_POS && !visited[cur.pos * 2]) {
                queue.offer(new Position(cur.pos * 2, cur.time));
            }
            if (cur.pos - 1 >= 0 && !visited[cur.pos - 1]) {
                queue.offer(new Position(cur.pos - 1, cur.time + 1));
            }
            if (cur.pos + 1 <= MAX_POS && !visited[cur.pos + 1]) {
                queue.offer(new Position(cur.pos + 1, cur.time + 1));
            }
        }
    }

    static class Position {

        int pos;
        int time;

        public Position(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }
    }
}
