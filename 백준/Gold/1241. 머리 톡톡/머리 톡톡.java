import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];
        int[] wroteCount = new int[1000001];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            wroteCount[numbers[i]]++;
        }

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int sqrtNum = (int) Math.sqrt(numbers[i]);
            int count = 0;
            for (int j = 1; j <= sqrtNum; j++) {
                if (numbers[i] % j == 0) {  // j가 numbers[i]의 약
                    if (numbers[i] / j != j) {
                        count += wroteCount[j] + wroteCount[numbers[i] / j];    // j의 범위가 numbers[i]의 제곱근까지니까 j와 곱해서 numbers[i]가 되는 수의 개수도 같이 더함
                    } else {
                        count += wroteCount[j];
                    }
                }
            }

            count--;    // 자기 자신 제외

            answer.append(count + "\n");
        }

        System.out.println(answer);
    }
}
