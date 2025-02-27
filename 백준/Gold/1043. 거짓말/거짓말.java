import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static List<Integer> known;
    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int knownCount = Integer.parseInt(st.nextToken());
        if (knownCount == 0) {
            System.out.println(m);
            return;
        }

        known = new ArrayList<>();
        for (int i = 0; i < knownCount; i++) {
            known.add(Integer.parseInt(st.nextToken()));
        }

        parents = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parents[i] = i;
        }

        List<List<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            parties.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int partyCount = Integer.parseInt(st.nextToken());

            int x = Integer.parseInt(st.nextToken());
            parties.get(i).add(x);
            for (int j = 0; j < partyCount - 1; j++) {
                int y = Integer.parseInt(st.nextToken());
                // 같은 파티에 있는 사람들 중 진실을 알고 있는 사람을 루트노드로 만들고 
                // 이후에 진실을 아는 사람 그룹에 포함되어 있는지 확인하여 거짓말을 할 수 없는 파티 카운트
                union(x, y);
                parties.get(i).add(y);
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            boolean flag = true;

            for (int p : parties.get(i)) {
                if (known.contains(findParent(p))) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static void union(int x, int y) {
        int px = findParent(x);
        int py = findParent(y);

        if (known.contains(py)) {   // py가 진실을 알고 있는 사람이면 py가 px의 부모가 되어야 하기 때문에 px <-> py swap
            int tmp = py;
            py = px;
            px = tmp;
        }

        parents[py] = px;   // px가 py의 부모
    }

    private static int findParent(int x) {
        if (parents[x] == x) {
            return x;
        }
        return findParent(parents[x]);
    }
}
