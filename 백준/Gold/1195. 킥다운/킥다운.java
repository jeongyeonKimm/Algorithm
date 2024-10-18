import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String up = br.readLine();
        String down = br.readLine();

        int answer = up.length() + down.length();

        for (int i = -down.length(); i <= up.length(); i++) {
            boolean isMatch = true;

            for (int j = 0; j < up.length(); j++) {
                int upNum = up.charAt(j) - '0';
                int downNum = ((j - i) < 0 || (j - i) >= down.length()) ? 0 : down.charAt(j - i) - '0'; // (j - i) < 0 || (j - i) >= down.length() 이 조건은 up, down이 겹치지 않는 부분
                if (upNum + downNum > 3) {
                    isMatch = false;
                    break;
                }
            }

            if (isMatch) {
                answer = Math.min(answer, Math.max(i + down.length(), up.length()) - Math.min(0, i));
            }
        }

        System.out.println(answer);
    }
}
