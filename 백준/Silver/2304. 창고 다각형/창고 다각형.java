import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[] pillars = new int[10001];
        int start = 1001;
        int end = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            pillars[l] = h;
            start = Math.min(start, l); // 가장 왼쪽에 있는 기둥의 왼쪽 면 위치
            end = Math.max(end, l); // 가장 왼쪽에 있는 기둥의 왼쪽 면 위치
        }

        Stack<Integer> stack = new Stack<>();
        int area = 0;

        int tmp = pillars[start];   // 지붕과 옆면이 닿는 기둥의 높이
        for (int i = start + 1; i <= end; i++) {
            /**
             * 오목하게 들어간 부분이 없기 때문에 앞에 있는 기둥보다 낮은 기둥 또는 기둥이 없는 곳은 스택에 넣고 패스
             * pillars[i] 값이 0인 곳은 기둥이 없는 곳
             */
            if (tmp > pillars[i]) {
                stack.push(i);
                continue;
            }

            /**
             * 스택에 쌓여 있는 낮은 기둥을 스택에서 다 꺼내서 해당 기둥의 높이를 tmp로
             */
            while (!stack.isEmpty()) {
                pillars[stack.pop()] = tmp;
            }

            tmp = pillars[i];   // 지붕의 높이가 바뀜
        }

        stack.clear();

        tmp = pillars[end];
        for (int i = end - 1; i >= start; i--) {
            if (tmp > pillars[i]) {
                stack.push(i);
                continue;
            }

            while (!stack.isEmpty()) {
                pillars[stack.pop()] = tmp;
            }

            tmp = pillars[i];
        }

        for (int i = start; i <= end; i++) {
            area += pillars[i];
        }

        System.out.println(area);
    }
}
