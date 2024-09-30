import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long W = sc.nextInt();
        long H = sc.nextInt();
        long f = sc.nextInt();
        long c = sc.nextInt();
        long x1 = sc.nextInt();
        long y1 = sc.nextInt();
        long x2 = sc.nextInt();
        long y2 = sc.nextInt();

        long total = W * H;
        long colored = (x2 - x1) * (y2 - y1) * (c + 1);

        if (f <= W / 2) {
            if (f > x1) {
                colored += (Math.min(f, x2) - x1) * (y2 - y1) * (c + 1);
            }
        } else {
            if (x1 + f < W) {
                colored += (Math.min(W, f + x2) - (f + x1)) * (y2 - y1) * (c + 1);
            }
        }

        System.out.println(total - colored);
    }
}
