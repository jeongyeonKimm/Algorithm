import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        int maxHeight = 0;
        int maxWidth = 0;
        int maxHeightIdx = 0;
        int maxWidthIdx = 0;

        int[] length = new int[6];

        for (int i = 0; i < 6; i++) {
            String[] input = br.readLine().split(" ");
            int direction = Integer.parseInt(input[0]);
            length[i] = Integer.parseInt(input[1]);

            if (direction == 1 || direction == 2) {
                if (maxWidth < length[i]) {
                    maxWidth = length[i];
                    maxWidthIdx = i;
                }
            } else {
                if (maxHeight < length[i]) {
                    maxHeight = length[i];
                    maxHeightIdx = i;
                }
            }
        }

        int cutWidth = length[(maxHeightIdx + 3) % 6];
        int cutHeight = length[(maxWidthIdx + 3) % 6];

        int result = ((maxHeight * maxWidth) - (cutHeight * cutWidth)) * k;

        System.out.println(result);
    }
}
