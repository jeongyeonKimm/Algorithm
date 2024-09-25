import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int result = 0;

        while (Integer.bitCount(n) > k) {
            result += n & (-n);
            n += n & (-n);
        }

        System.out.println(result);
    }
}
