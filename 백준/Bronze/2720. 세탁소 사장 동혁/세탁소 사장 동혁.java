import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            int c = Integer.parseInt(br.readLine());
            
            int q = c / 25;
            c %= 25;
            int d = c / 10;
            c %= 10;
            int n = c / 5;
            c %= 5;
            int p = c;
            
            System.out.println(q + " " + d + " " + n + " " + p);
        }
    }
}