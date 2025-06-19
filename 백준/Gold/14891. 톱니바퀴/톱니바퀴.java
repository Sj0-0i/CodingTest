import java.io.*;
import java.util.*;

public class Main {
    static List<Deque<Character>> gears = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 4; i++) {
            Deque<Character> gear = new ArrayDeque<>();
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                gear.addLast(line.charAt(j));
            }
            gears.add(gear);
        }

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gearNum = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());

            int[] rotateDirs = new int[4];
            rotateDirs[gearNum] = direction;

            for (int j = gearNum - 1; j >= 0; j--) {
                if (gears.get(j).toArray()[2].equals(gears.get(j + 1).toArray()[6])) break;
                rotateDirs[j] = -rotateDirs[j + 1];
            }

            for (int j = gearNum + 1; j < 4; j++) {
                if (gears.get(j - 1).toArray()[2].equals(gears.get(j).toArray()[6])) break;
                rotateDirs[j] = -rotateDirs[j - 1];
            }

            for (int j = 0; j < 4; j++) {
                if (rotateDirs[j] == 1) rotateClockwise(gears.get(j));
                else if (rotateDirs[j] == -1) rotateCounterClockwise(gears.get(j));
            }
        }

        int result = 0;
        for (int i = 0; i < 4; i++) {
            if (gears.get(i).peekFirst() == '1') {
                result += (1 << i);
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void rotateClockwise(Deque<Character> gear) {
        gear.addFirst(gear.pollLast());
    }

    static void rotateCounterClockwise(Deque<Character> gear) {
        gear.addLast(gear.pollFirst());
    }
}
