import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] chart;
    static boolean[] isLine;
    static int answer = 0;
    static int fullMask;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        chart = new int[N];
        isLine = new boolean[51];
        int maxDogs = 0;
        fullMask = (1 << N) - 1;    // 모든 차트를 탐색한 상태

        for (int i = 0; i < N; i++) {
            chart[i] = Integer.parseInt(st.nextToken());
            maxDogs = Math.max(maxDogs, chart[i]);
        }

        if (maxDogs > 50) {
            System.out.println(0);
            return;
        }

        if (maxDogs == 50) {
            System.out.println(1);
            return;
        }

        isLine[0] = true;
        makeChart(0, false, 0, 0);

        System.out.println(answer);
    }

    static void makeChart(int sum, boolean isSix, int lineCount, int mask) {
        if (mask == fullMask) {
            answer = Math.max(answer, lineCount);
            return;
        }

        for (int i = 0; i < N; i++) {
            if ((mask & (1 << i)) >= 1) {   // 이미 탐색한 영역
                continue;
            }

            int tmp = sum + chart[i];

            if (!isSix) {   // 12시 부터 시작
                if (tmp >= 50) {    // 50%를 넘어서 6시 이후로 넘어갈 때
                    if (isLine[tmp % 50]) { // 직선이 생길 떄
                        makeChart(tmp % 50, true, lineCount + 1, mask | (1 << i));  // mask | (1 << i)는 i번째 차트는 탐색 했다는 의미
                    } else {
                        makeChart(tmp % 50, true, lineCount, mask | (1 << i));
                    }
                } else {    // 50% 넘어가지 않을 때
                    isLine[tmp] = true;
                    makeChart(tmp, false, lineCount, mask | (1 << i));
                    isLine[tmp] = false;
                }
            } else {    // 6시 부터 시작
                if (isLine[tmp]) {  // 직선 생길 떄
                    makeChart(tmp, true, lineCount + 1, mask | (1 << i));
                } else {
                    makeChart(tmp, true, lineCount, mask | (1 << i));
                }
            }
        }
    }
}
