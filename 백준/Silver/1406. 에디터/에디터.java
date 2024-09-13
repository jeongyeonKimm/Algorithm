import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int m = Integer.parseInt(br.readLine());

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (char c : str.toCharArray()) {
            left.push(c);
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            char command = st.nextToken().charAt(0);
            switch (command) {
                case 'L':
                    if (!left.isEmpty()) {
                        right.push(left.pop());
                    }
                    break;
                case 'D':
                    if (!right.isEmpty()) {
                        left.push(right.pop());
                    }
                    break;
                case 'B':
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                    break;
                case 'P':
                    char addChar = st.nextToken().charAt(0);
                    left.push(addChar);
                    break;
            }
        }

        while(!left.isEmpty()) {
            right.push(left.pop());
        }

        StringBuilder sb = new StringBuilder();
        while (!right.isEmpty()) {
            sb.append(right.pop());
        }

        System.out.println(sb);
    }
}
