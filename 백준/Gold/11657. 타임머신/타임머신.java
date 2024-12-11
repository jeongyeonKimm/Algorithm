import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static final int INF = Integer.MAX_VALUE;
    private static int n, m;
    private static long[] d;
    private static ArrayList<Bus> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph.add(new Bus(A, B, C));
        }

        d = new long[n + 1];
        for (int i = 0; i < n + 1; i++) {
            d[i] = INF;
        }

        StringBuilder sb = new StringBuilder();

        if (bellmanFord(1)) {
            sb.append("-1\n");
        } else {
            for (int i = 2; i < n + 1; i++) {
                if (d[i] == INF) {
                    sb.append("-1\n");
                } else {
                    sb.append(d[i] + "\n");
                }
            }
        }

        System.out.println(sb);
    }

    private static boolean bellmanFord(int start) {
        d[start] = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < m; j++) {
                Bus bus = graph.get(j);
                int s = bus.depart;
                int e = bus.dest;
                int t = bus.time;
                
                if (d[s] == INF) continue;
                if (d[e] > d[s] + t) {
                    d[e] = d[s] + t;
                    if (i == n) return true;
                }
            }
        }
        
        return false;
    }

    static class Bus {

        int depart;
        int dest;
        int time;

        public Bus(int depart, int dest, int time) {
            this.depart = depart;
            this.dest = dest;
            this.time = time;
        }
    }
}
