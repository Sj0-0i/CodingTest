import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] temp = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }
        
        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += temp[i];
        }
        
        int max = sum;
        
        for (int i = K; i < N; i++) {
            sum = sum - temp[i - K] + temp[i];
            max = Math.max(max, sum);
        }
        
        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}