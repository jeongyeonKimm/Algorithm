import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] down = new int[n / 2];
        int[] up = new int[n / 2];

        for (int i = 0; i < n / 2; i++) {
            down[i] = Integer.parseInt(br.readLine());
            up[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(down);
        Arrays.sort(up);

        int min = n;
        int count = 0;

        for (int i = 1; i <= h; i++) {
            int num = binarySearch(down, i) + binarySearch(up, h - i + 1);

            if (num == min) {
                count++;
                continue;
            }

            if (num < min) {
                min = num;
                count = 1;
            }
        }

        System.out.println(min + " " + count);
    }

    static int binarySearch(int[] arr, int height) {
        int start = 0;
        int end = arr.length;

        while (start < end) {
            int mid = (start + end) / 2;

            if (arr[mid] >= height) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return arr.length - end;
    }
}
