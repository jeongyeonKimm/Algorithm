import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Line[] lines = new Line[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lines[i] = new Line(start, end);
        }

        Arrays.sort(lines);

        int maxEnd = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (maxEnd > lines[i].start) {
                if (maxEnd > lines[i].end) {
                    continue;
                }
                sum += (lines[i].end - maxEnd);
            } else {
                sum += (lines[i].end - lines[i].start);
            }

            maxEnd = Math.max(maxEnd, lines[i].end);
        }

        System.out.println(sum);
    }

    static class Line implements Comparable<Line> {

        int start;
        int end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Line o) {
            if (this.start == o.start) {
                return this.end - o.end;
            }

            return this.start - o.start;
        }
    }
}
