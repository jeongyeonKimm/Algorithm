import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static Set<Character> usedShortCuts;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        usedShortCuts = new HashSet<>();

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String option = br.readLine();
            String[] words = option.split(" ");

            String result = checkFirstLetter(words);
            if (result != null) {
                answer.append(result).append("\n");
                continue;
            }

            result = checkOtherLetters(words);
            if (result != null) {
                answer.append(result).append("\n");
                continue;
            }

            answer.append(option).append("\n");
        }

        System.out.println(answer);
    }

    private static String checkFirstLetter(String[] words) {
        for (int i = 0; i < words.length; i++) {
            char first = words[i].toLowerCase().charAt(0);

            if (!usedShortCuts.contains(first)) {
                usedShortCuts.add(first);
                return makeStringWithBracket(words, i, 0);
            }
        }
        return null;
    }

    private static String checkOtherLetters(String[] words) {
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                char letter = word.toLowerCase().charAt(j);

                if (!usedShortCuts.contains(letter)) {
                    usedShortCuts.add(letter);
                    return makeStringWithBracket(words, i, j);
                }
            }
        }
        return null;
    }


    private static String makeStringWithBracket(String[] words, int wordIdx, int letterIdx) {
        StringBuilder newStr = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            if (i > 0) {
                newStr.append(" ");
            }
            
            if (i == wordIdx) {
                newStr.append(word.substring(0, letterIdx))
                        .append("[")
                        .append(word.charAt(letterIdx))
                        .append("]")
                        .append(word.substring(letterIdx + 1));
            } else {
                newStr.append(word);
            }
        }
        
        return newStr.toString();
    }
}
