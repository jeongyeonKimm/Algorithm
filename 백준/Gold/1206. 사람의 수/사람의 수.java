import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        double[] scores = new double[N];

        for (int i = 0; i < N; i++) {
            double score = Double.parseDouble(br.readLine());
            score = score - Math.floor(score);
            scores[i] = Math.round(score * 1000.0) / 1000.0;    // 입력 받은 각 문항의 평균 점수를 소수점 부분만 남김
        }

        double[] avg = new double[1001];

        for (int i = 1; i < 1001; i++) {    // i는 가능한 사람 수. 1 ~ 1000(입력된 평균 점수가 소수점 셋째 자리까지 표현되기 때문에 가능한 사람수의 최대는 1000)
            for (int j = 1; j <= i; j++) {  // j는 i명의 사람들의 총 점수의 합 범위(1 ~ 사람 수). 입력을 소수점 부분만 받아서 그 이상은 의미 X. j로 사람은 i명, 총 정수의 합은 j일 때의 평균 구하기.
                avg[j] = Math.floor(((double) j / i) * 1000) / 1000.0;
            }

            boolean flag = true;
            for (int j = 0; j < N; j++) {
                // 입력받은 N개의 문항의 평균 값이 모두 있는지 binarySearch로 확인.(i명의 사람의 평균이라는 의미) 하나라도 없으면 i명이 아님.
                if (Arrays.binarySearch(avg, 0, i + 1, scores[j]) < 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                System.out.println(i);
                return;
            }
        }
    }
}
