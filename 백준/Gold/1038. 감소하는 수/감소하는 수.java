import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static ArrayList<Long> numbers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        if (N <= 10) {
            System.out.println(N);
            return;
        }

        if (N >= 1023) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < 10; i++) {
            makeNum(1, i);
        }

        Collections.sort(numbers);

        System.out.println(numbers.get(N));
    }

    static void makeNum(int depth, long num) {
        if (depth > 10) return;

        numbers.add(num);
        for (int i = 0; i < num % 10; i++) {
            makeNum(depth + 1, num * 10 + i);
        }
    }
}
