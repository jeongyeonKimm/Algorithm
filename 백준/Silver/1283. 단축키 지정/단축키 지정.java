import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[] isUsed = new boolean[26];

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String option = br.readLine();
            String input = option.toLowerCase();
            String[] words = input.split(" ");

            int repIdx = -1;
            int tmp = 0;
            for (int j = 0; j < words.length; j++) {
                int idx = words[j].charAt(0) - 'a';
                if (!isUsed[idx]) {
                    isUsed[idx] = true;
                    repIdx = tmp;
                    break;
                }
                tmp += words[j].length();
                tmp++;  // 공백 count
            }

            if (repIdx > -1) {
                answer.append(option.substring(0, repIdx) + "[" + option.charAt(repIdx)
                        + "]" + option.substring(repIdx + 1) + "\n");
                continue;
            }

            for (int j = 1; j < input.length(); j++) {
                int idx = input.charAt(j) - 'a';

                if (option.charAt(j) == ' ') {
                    j++;
                    continue;
                }

                if (!isUsed[idx]) {
                    isUsed[idx] = true;
                    repIdx = j;
                    break;
                }
            }

            if (repIdx > -1) {
                answer.append(option.substring(0, repIdx) + "[" + option.charAt(repIdx)
                        + "]" + option.substring(repIdx + 1) + "\n");
            } else {
                answer.append(option + "\n");
            }
        }

        System.out.println(answer);
    }
}
