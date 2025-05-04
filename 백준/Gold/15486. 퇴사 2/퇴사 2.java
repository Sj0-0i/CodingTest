import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N + 2]; 
        int[] P = new int[N + 2];  
        int[] dp = new int[N + 2]; 

        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            T[i] = Integer.parseInt(input[0]);
            P[i] = Integer.parseInt(input[1]);
        }

        for (int i = N; i >= 1; i--) {
            int endDay = i + T[i];
            if (endDay <= N + 1) {
                dp[i] = Math.max(P[i] + dp[endDay], dp[i + 1]);
            } else {
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[1]);
    }
}
