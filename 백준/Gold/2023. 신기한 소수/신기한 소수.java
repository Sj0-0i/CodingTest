import java.io.*;

public class Main {
    static int N; 
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        int[] startPrimes = {2, 3, 5, 7};
        
        for (int prime : startPrimes) {
            dfs(prime, 1);
        }
    }
    
    static void dfs(int num, int len) {
        if (len == N) {
            System.out.println(num);
            return;
        }
        for (int i = 1; i <= 9; i += 2) {
            int next = num * 10 + i;
            if (isPrime(next)) {
                dfs(next, len + 1);
            }
        }
    }
    
    static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= (int)Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}