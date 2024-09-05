import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] arr = new char[r][c];

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        int start = binarySearch(r, c, arr);

        System.out.println(start);
    }

    private static int binarySearch(int r, int c, char[][] arr) {
        int start = 0;
        int end = r - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (checkDuplication(r, c, arr, mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private static boolean checkDuplication(int r, int c, char[][] arr, int mid) {
        List<String> strings = new ArrayList<>();

        for (int i = 0; i < c; i++) {
            StringBuilder newStr = new StringBuilder();
            for (int j = mid + 1; j < r; j++) {
                newStr.append(arr[j][i]);
            }

            if (strings.contains(newStr.toString())) {
                return true;
            }

            strings.add(newStr.toString());
        }

        return false;
    }
}
