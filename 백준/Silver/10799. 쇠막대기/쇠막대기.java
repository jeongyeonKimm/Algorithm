import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] info = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < info.length; i++) {
            if (info[i] == '(') {
                stack.push('(');
            } else {
                stack.pop();

                if (info[i - 1] == '(') {
                    result += (stack.size());
                } else {
                    result += 1;
                }
            }
        }

        System.out.println(result);
    }
}
