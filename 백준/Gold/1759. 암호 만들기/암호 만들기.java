import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static char[] alphabets;
    static char[] password;
    static int l, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        alphabets = new char[c];
        password = new char[l];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            alphabets[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(alphabets);

        backtracking(0, 0);
    }

    static void backtracking(int depth, int start) {
        if (depth >= l) {
            if (isValidPassword()) {
                System.out.println(new String(password));
            }
            return;
        }

        for (int i = start; i < c; i++) {
            password[depth] = alphabets[i];
            backtracking(depth + 1, i + 1);
        }
    }

    static boolean isValidPassword() {
        int vowel = 0;
        int consonant = 0;

        for (int i = 0; i < l; i++) {
            if (password[i] == 'a' || password[i] == 'e' || password[i] == 'i' || password[i] == 'o' || password[i] == 'u') {
                vowel++;
            } else {
                consonant++;
            }
        }

        if (vowel >= 1 && consonant >= 2) return true;
        else return false;
    }
}
