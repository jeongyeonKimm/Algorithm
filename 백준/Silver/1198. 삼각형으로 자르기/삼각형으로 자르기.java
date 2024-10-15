import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Point> points;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        points = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Integer.parseInt(st.nextToken());
            double y = Integer.parseInt(st.nextToken());

            Point point = new Point(x, y);
            points.add(point);
        }

        double result = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    double area = calculateArea(i, j, k);
                    result = Math.max(result, area);
                }
            }
        }

        System.out.println(result);
    }

    static double calculateArea(int i, int j, int k) {
        Point first = points.get(i);
        Point second = points.get(j);
        Point third = points.get(k);

        double a = first.x * second.y + second.x * third.y + third.x * first.y;
        double b = first.x * third.y + third.x * second.y + second.x * first.y;

        double area = Math.abs(a - b) / 2;
        return area;
    }

    static class Point {

        double x;
        double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}
