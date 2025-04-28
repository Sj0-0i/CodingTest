import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] board;
    static boolean[][][][] visited;
    static int[] dx = {0, 0, -1, 1}; 
    static int[] dy = {-1, 1, 0, 0};

    static class State {
        int y1, x1, y2, x2, moves;

        State(int y1, int x1, int y2, int x2, int moves) {
            this.y1 = y1;
            this.x1 = x1;
            this.y2 = y2;
            this.x2 = x2;
            this.moves = moves;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        visited = new boolean[N][M][N][M];

        List<int[]> coins = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'o') {
                    coins.add(new int[]{i, j});
                }
            }
        }

        System.out.println(bfs(coins.get(0)[0], coins.get(0)[1], coins.get(1)[0], coins.get(1)[1]));
    }

    static int bfs(int y1, int x1, int y2, int x2) {
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(y1, x1, y2, x2, 0));
        visited[y1][x1][y2][x2] = true;

        while (!queue.isEmpty()) {
            State cur = queue.poll();

            if (cur.moves >= 10) return -1;

            for (int dir = 0; dir < 4; dir++) {
                int ny1 = cur.y1 + dy[dir];
                int nx1 = cur.x1 + dx[dir];
                int ny2 = cur.y2 + dy[dir];
                int nx2 = cur.x2 + dx[dir];

                boolean fall1 = isOut(ny1, nx1);
                boolean fall2 = isOut(ny2, nx2);

                if (fall1 && fall2) continue;

                if (fall1 || fall2) {
                    return cur.moves + 1;
                }

                if (!fall1 && board[ny1][nx1] == '#') {
                    ny1 = cur.y1;
                    nx1 = cur.x1;
                }
                if (!fall2 && board[ny2][nx2] == '#') {
                    ny2 = cur.y2;
                    nx2 = cur.x2;
                }

                if (!visited[ny1][nx1][ny2][nx2]) {
                    visited[ny1][nx1][ny2][nx2] = true;
                    queue.offer(new State(ny1, nx1, ny2, nx2, cur.moves + 1));
                }
            }
        }

        return -1; // 실패
    }

    static boolean isOut(int y, int x) {
        return y < 0 || x < 0 || y >= N || x >= M;
    }
}
