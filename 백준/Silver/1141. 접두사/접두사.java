import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        Arrays.sort(words, (a, b) -> b.length() - a.length());  // 단어들을 길이 내림차순으로 정렬

        int count = 0;

        for (int i = 0; i < N; i++) {
            boolean isPrefix = false;
            for (int j = 0; j < i; j++) {
                if (words[j].startsWith(words[i])) {
                    isPrefix = true;
                    break;
                }
            }

            if (!isPrefix) {
                count++;
            }
        }

        System.out.println(count);
    }
}
