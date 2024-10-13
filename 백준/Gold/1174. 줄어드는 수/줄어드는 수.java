import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static int[] numbers = {9, 8, 7, 6, 5, 4 ,3, 2, 1, 0};
    static ArrayList<Long> numList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        numList = new ArrayList<>();

        dfs(0, 0);

        Collections.sort(numList);

        if (N <= numList.size()) {
            System.out.println(numList.get(N - 1));
        } else {
            System.out.println(-1);
        }
    }

    static void dfs(long num, int depth) {
        if (depth == 10) {
            if (!numList.contains(num)) {
                numList.add(num);
            }
            return;
        }

        dfs(num, depth + 1);
        dfs(num * 10 + numbers[depth], depth + 1);
    }
}
