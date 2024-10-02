import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int ALPHABET_COUNT = 26;
    static final int MAX_WORD_COUNT = 200000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] wordAlphabet = new int[MAX_WORD_COUNT][ALPHABET_COUNT];
        int wordCount = 0;

        while (true) {
            String word = br.readLine();
            if (word.equals("-")) {
                break;
            }

            for (int i = 0; i < word.length(); i++) {
                wordAlphabet[wordCount][word.charAt(i) - 'A']++;
            }
            wordCount++;
        }

        StringBuilder result = new StringBuilder();

        while (true) {
            String puzzle = br.readLine();
            if (puzzle.equals("#")) {
                break;
            }

            int[] puzzleCount = new int[ALPHABET_COUNT];
            for (int i = 0; i < puzzle.length(); i++) {
                puzzleCount[puzzle.charAt(i) - 'A']++;
            }

            int[] noDuplicate = new int[ALPHABET_COUNT];

            for (int i = 0; i < wordCount; i++) {
                if (!isValid(wordAlphabet[i], puzzleCount)) {
                    continue;
                }

                for (int j = 0; j < ALPHABET_COUNT; j++) {
                    if (wordAlphabet[i][j] != 0) {
                        noDuplicate[j]++;
                    }
                }
            }

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < ALPHABET_COUNT; i++) {
                if (puzzleCount[i] == 0) {
                    continue;
                }
                min = Math.min(min, noDuplicate[i]);
                max = Math.max(max, noDuplicate[i]);
            }

            StringBuilder minAlphabets = new StringBuilder();
            StringBuilder maxAlphabets = new StringBuilder();

            for (int i = 0; i < ALPHABET_COUNT; i++) {
                if (puzzleCount[i] != 0 && noDuplicate[i] == min) {
                    minAlphabets.append((char) ('A' + i));
                }
                
                if (puzzleCount[i] != 0 && noDuplicate[i] == max) {
                    maxAlphabets.append((char) ('A' + i));
                }
            }

            result.append(minAlphabets + " " + min + " ");
            result.append(maxAlphabets + " " + max + "\n");
        }

        System.out.println(result);
    }

    static boolean isValid(int[] word, int[] puzzle) {
        for (int i = 0; i < ALPHABET_COUNT; i++) {
            if (word[i] > puzzle[i]) {
                return false;
            }
        }
        return true;
    }
}
