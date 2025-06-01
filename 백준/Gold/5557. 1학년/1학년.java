import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        long[][] dp = new long[N - 1][21]; 
        dp[0][nums[0]] = 1; 
        
        for (int i = 1; i < N - 1; i++) {
            for (int sum = 0; sum <= 20; sum++) {
                if (dp[i - 1][sum] > 0) {
                    int plus = sum + nums[i];
                    int minus = sum - nums[i];
                    if (plus <= 20) {
                        dp[i][plus] += dp[i - 1][sum];
                    }
                    if (minus >= 0) {
                        dp[i][minus] += dp[i - 1][sum];
                    }
                }
            }
        }

        System.out.println(dp[N - 2][nums[N - 1]]);
    }
}
