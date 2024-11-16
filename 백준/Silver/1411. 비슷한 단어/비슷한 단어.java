import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static int answer = 0;
    private static int N;
    private static int[] numbers;
    private static String[] words;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        words = new String[N];
        numbers = new int[2];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            words[i] = makeWord(input);
        }

        countPairs(0, 0);
        System.out.println(answer);
    }

    private static String makeWord(String input) {
        Map<Character, Character> map = new HashMap<>();
        char alphabet = 'a';
        String word = "";

        for (int i = 0; i < input.length(); i++) {
            if (!map.containsKey(input.charAt(i))) {
                map.put(input.charAt(i), alphabet);
                alphabet++;
            }
            word += map.get(input.charAt(i));
        }

        return word;
    }

    private static void countPairs(int start, int count) {
        if (count == 2) {
            if (words[numbers[0]].equals(words[numbers[1]])) {
                answer++;
            }
            return;
        }

        for (int i = start; i < N; i++) {
            numbers[count] = i;
            countPairs(i + 1, count + 1);
        }
    }
}
