import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] alphabetCount = new int[26];
    static String S;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();

        for (int i = 0; i < S.length(); i++) {
            alphabetCount[S.charAt(i) - 'a']++;
        }

        backtracking(0, ' ');
        System.out.println(count);
    }

    static void backtracking(int depth, char prev) {
        if (depth == S.length()) {
            count++;
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (alphabetCount[i] == 0) {
                continue;
            }

            char cur = (char) ('a' + i);
            if (cur != prev) {
                alphabetCount[i]--;
                backtracking(depth + 1, cur);
                alphabetCount[i]++;
            }
        }
    }
}
