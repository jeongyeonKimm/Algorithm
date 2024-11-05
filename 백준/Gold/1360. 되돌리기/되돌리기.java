import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Command> commands;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        commands = new ArrayList<>();
        commands.add(new Command("", 0));
        
        for (int cur = 1; cur <= N; cur++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            if (str.equals("type")) {
                char text = st.nextToken().charAt(0);
                int time = Integer.parseInt(st.nextToken());
                type(cur, text, time);
            } else {
                int back = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                undo(cur, back, time);
            }
        }

        System.out.println(commands.get(N).str);
    }

    private static void type(int cur, char text, int time) {
        Command prev = commands.get(cur - 1);
        String newStr = prev.str + text;
        commands.add(new Command(newStr, time));
    }

    private static void undo(int cur, int back, int time) {
        int targetTime = time - back - 1;
        boolean flag = false;
        for (int i = cur - 1; i >= 0; i--) {
            if (targetTime < 0) {
                break;
            }

            Command curCommand = commands.get(i);
            if (curCommand.time <= targetTime) {
                commands.add(new Command(curCommand.str, time));
                flag = true;
                break;
            }
        }

        if (!flag) {
            commands.add(new Command("", time));
        }
    }

    static class Command {

        String str;
        int time;

        public Command(String str, int time) {
            this.str = str;
            this.time = time;
        }
    }
}
