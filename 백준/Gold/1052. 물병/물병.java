import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        if (n <= k) {
            System.out.println(0);
            return;
        }

        int result = 0;
        while (true) {
            int cur = n + result;
            int count = 0;

            while (cur > 0) {
                if (cur % 2 != 0) {
                    count++;
                }
                cur /= 2;
            }

            if (count <= k) {
                break;
            }
            result++;
        }

        System.out.println(result);
    }
}
