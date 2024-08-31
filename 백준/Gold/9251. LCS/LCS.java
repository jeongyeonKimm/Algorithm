import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

//    static Integer[][] dp;
    static int[][] dp;
    static String str1, str2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str1 = br.readLine();
        str2 = br.readLine();

        int len1 = str1.length();
        int len2 = str2.length();

//        dp = new Integer[len1][len2];

//        int result = lcs(len1 - 1, len2 - 1);   // top-down 방식

        dp = new int[len1 + 1][len2 + 1]; // 인덱스 0은 공집합

        // bottom-up 방식
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[len1][len2]);
    }

//    static int lcs(int x, int y) {
//        if (x == -1 || y == -1) {
//            return 0;
//        }
//
//        if (dp[x][y] == null) {
//            if (str1.charAt(x) == str2.charAt(y)) {
//                dp[x][y] = lcs(x - 1, y - 1) + 1;
//            } else {
//                dp[x][y] = Math.max(lcs(x - 1, y), lcs(x, y - 1));
//            }
//        }
//
//        return dp[x][y];
//    }
}
