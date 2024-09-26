import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static char[][] graph;
    static boolean[][] friend;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        graph = new char[N][N];
        friend = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            graph[i] = br.readLine().toCharArray();
        }

        countFriend();

        int maxFriend = 0;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                if (friend[i][j]) sum++;
            }
            maxFriend = Math.max(maxFriend, sum);
        }

        System.out.println(maxFriend);
    }

    static void countFriend() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {   // j가 공통 친구
                if (graph[i][j] == 'Y') {
                    friend[i][j] = true;
                    for (int k = 0; k < N; k++) {
                        if (i != k && graph[j][k] == 'Y') {
                            friend[i][k] = true;
                        }
                    }
                }
            }
        }
    }
}
