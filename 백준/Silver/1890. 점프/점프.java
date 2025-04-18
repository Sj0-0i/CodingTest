import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] board = new int[N][N];
        long[][] dp = new long[N][N]; // 경로 개수
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dp[0][0] = 1;
        
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                int jump = board[y][x];
                if (jump == 0 || dp[y][x] == 0) 
                    continue;
                if (x + jump < N)
                    dp[y][x + jump] += dp[y][x];
                if (y + jump < N)
                    dp[y + jump][x] += dp[y][x];
            }
        }
        System.out.println(dp[N - 1][N - 1]); // 도착점
    }
}