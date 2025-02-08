import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        int size = (int) (max - min + 1);
        int sqrt = (int) Math.sqrt(max);

        boolean[] check = new boolean[size]; // 제곱ㄴㄴ수는 false

        for (long i = 2; i <= sqrt; i++) {  // 제곱ㄴㄴ수의 후보
            long squared = i * i;
            long start = min % squared == 0 ? min / squared : min / squared + 1;
            // 에라토스테네스의 체 방식 이용
            // start 값은 효율성을 위해(수의 크기가 크기 때문에 i로 나누어 지기 이전의 낭비가 큼) min을 나눴을 때 나누어 떨어지는 수의 몫(+1)으로 설정
            // start 부터 하나씩 늘려가며 제곱수의 베수를 true로 표시(제곱수의 배수는 제곱ㄴㄴ수가 아님)
            // - min을 하는 이유는 check 배열의 크기가 max - min + 1이기 때문
            for (long j = start; j * squared <= max; j++) {
                check[(int) (j * squared - min)] = true;
            }
        }

        int result = 0;
        for (int i = 0; i < size; i++) {
            if (!check[i]) {
                result++;
            }
        }
        System.out.println(result);
    }
}
