import java.io.*;

public class Main {
    static int N;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int max = 0;

        // 모든 인접한 쌍 교환 시도 (오른쪽, 아래쪽만)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                // 오른쪽 교환
                if (j + 1 < N) {
                    swap(i, j, i, j + 1);
                    max = Math.max(max, check());
                    swap(i, j, i, j + 1); // 원상복구
                }

                // 아래쪽 교환
                if (i + 1 < N) {
                    swap(i, j, i + 1, j);
                    max = Math.max(max, check());
                    swap(i, j, i + 1, j); // 원상복구
                }
            }
        }

        System.out.println(max);
    }

    // 두 위치의 사탕 교환
    static void swap(int x1, int y1, int x2, int y2) {
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }

    // 현재 보드에서 가장 긴 연속 부분 찾기
    static int check() {
        int max = 1;

        // 각 행 검사
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 1; j < N; j++) {
                if (board[i][j] == board[i][j - 1]) {
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 1;
                }
            }
        }

        // 각 열 검사
        for (int j = 0; j < N; j++) {
            int count = 1;
            for (int i = 1; i < N; i++) {
                if (board[i][j] == board[i - 1][j]) {
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 1;
                }
            }
        }

        return max;
    }
}
