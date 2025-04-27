import java.io.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        solve();
        System.out.println(answer);
    }

    static void solve() {
        // 모든 시작 위치
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                for (int dr = -N; dr <= N; dr++) {
                    for (int dc = -M; dc <= M; dc++) {
                        if (dr == 0 && dc == 0) continue;

                        int nr = r;
                        int nc = c;
                        int num = 0;

                        while (0 <= nr && nr < N && 0 <= nc && nc < M) {
                            num = num * 10 + map[nr][nc];

                            if (isPerfectSquare(num)) {
                                answer = Math.max(answer, num);
                            }

                            nr += dr;
                            nc += dc;
                        }
                    }
                }
            }
        }
    }

    static boolean isPerfectSquare(int num) {
        if (num < 0) return false;
        int sqrt = (int)Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}
