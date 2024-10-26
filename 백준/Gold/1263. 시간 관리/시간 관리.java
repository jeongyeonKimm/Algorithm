import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Todo[] todos = new Todo[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            todos[i] = new Todo(t, s);
        }

        Arrays.sort(todos);

        int wakeTime = 1000000;

        for (Todo todo : todos) {
            wakeTime = Math.min(wakeTime, todo.s) - todo.t;
            if (wakeTime < 0) {
                wakeTime = -1;
                break;
            }
        }

        System.out.println(wakeTime);
    }

    static class Todo implements Comparable<Todo> {

        int t;
        int s;

        public Todo(int t, int s) {
            this.t = t;
            this.s = s;
        }

        @Override
        public int compareTo(Todo o) {
            return o.s - this.s;
        }
    }
}
