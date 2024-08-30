import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Position> houses = new ArrayList<>();
    static List<Position> chickens = new ArrayList<>();
    static int[][] map;
    static boolean[] visited;
    static int n, m;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    houses.add(new Position(i, j));
                } else if (map[i][j] == 2) {
                    chickens.add(new Position(i, j));
                }
            }
        }

        visited = new boolean[chickens.size()];
        result = Integer.MAX_VALUE;

        backtracking(0, 0);

        System.out.println(result);
    }
    
    static void backtracking(int depth, int start) {
        if (depth == m) {
            int minDistance = 0;    // 집과 치킨집 사이의 최소 거리(치킨거리)의 합
            for (int i = 0; i < houses.size(); i++) {
                int tmp = Integer.MAX_VALUE;
                for (int j = 0; j < chickens.size(); j++) {
                    if (visited[j]) {
                        int distance = Math.abs(houses.get(i).x - chickens.get(j).x) + Math.abs(houses.get(i).y - chickens.get(j).y);
                        tmp = Math.min(distance, tmp);  // 치킨거리
                    }
                }
                minDistance += tmp;
            }

            result = Math.min(result, minDistance); // 치킨거리의 합 중 최소값
            return;
        }

        // m개의 치킨 집 선택
        for (int i = start; i < chickens.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(depth + 1, i + 1);    // start + 1이 아니라 i + 1을 넘겨줘 시간초과 방지
                visited[i] = false;
            }
        }
    }

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
