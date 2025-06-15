import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] lab;
    static int maxSafe = 0;
    static List<int[]> virusList = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lab = new int[N][M];
        List<int[]> empty = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 0) {
                    empty.add(new int[]{i, j});
                } else if (lab[i][j] == 2) {
                    virusList.add(new int[]{i, j});
                }
            }
        }

        int size = empty.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                for (int k = j + 1; k < size; k++) {
                    int[] w1 = empty.get(i);
                    int[] w2 = empty.get(j);
                    int[] w3 = empty.get(k);

                    lab[w1[0]][w1[1]] = 1;
                    lab[w2[0]][w2[1]] = 1;
                    lab[w3[0]][w3[1]] = 1;

                    bfs();

                    lab[w1[0]][w1[1]] = 0;
                    lab[w2[0]][w2[1]] = 0;
                    lab[w3[0]][w3[1]] = 0;
                }
            }
        }

        System.out.println(maxSafe);
    }

    static void bfs() {
        int[][] temp = new int[N][M];
        for (int i = 0; i < N; i++) {
            temp[i] = lab[i].clone();
        }

        Queue<int[]> q = new LinkedList<>();
        for (int[] v : virusList) {
            q.offer(v);
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && temp[nx][ny] == 0) {
                    temp[nx][ny] = 2;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        int safe = 0;
        for (int[] row : temp) {
            for (int cell : row) {
                if (cell == 0) safe++;
            }
        }
        maxSafe = Math.max(maxSafe, safe);
    }
}