import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static boolean[] isPrime;
    static ArrayList<Integer> primeNumbers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        primeNumbers = new ArrayList<>();
        isPrime = new boolean[B + 1];
        Arrays.fill(isPrime, true);

        checkPrime();

        int result = 0;

        for (int i = A; i <= B; i++) {
            if (isPrime[i]) {   // 이미 자신이 소수인 수
                continue;
            }

            int num = i;
            int primeCount = 0;

            for (int p : primeNumbers) {
                while (num > 1 && num % p == 0) {
                    primeCount++;
                    num /= p;
                }

                if (num == 1) {
                    break;
                }
            }

            if (isPrime[primeCount]) {
                result++;
            }
        }

        System.out.println(result);
    }

    static void checkPrime() {
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                primeNumbers.add(i);
                for (int j = i * 2; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}
