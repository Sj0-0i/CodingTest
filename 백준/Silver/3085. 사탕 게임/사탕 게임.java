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
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j + 1 < N) {
                    swap(i, j, i, j + 1);
                    max = Math.max(max, check());
                    swap(i, j, i, j + 1);
                }
                if (i + 1 < N) {
                    swap(i, j, i + 1, j);
                    max = Math.max(max, check());
                    swap(i, j, i + 1, j);
                }
            }
        }
        
        System.out.println(max);
    }
    
    private static void swap(int x1, int y1, int x2, int y2) {
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }
    
    private static int check() {
        int max = 1;
        
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