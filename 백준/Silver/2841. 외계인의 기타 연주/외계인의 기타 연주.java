import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); 
        int P = Integer.parseInt(st.nextToken()); 

        Stack<Integer>[] stacks = new Stack[7]; 
        for (int i = 1; i <= 6; i++) {
            stacks[i] = new Stack<>();
        }

        int moveCount = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());  
            int fret = Integer.parseInt(st.nextToken());  

            Stack<Integer> stack = stacks[line];
            while (!stack.isEmpty() && stack.peek() > fret) {
                stack.pop();
                moveCount++;
            }

            if (!stack.isEmpty() && stack.peek() == fret) {
                continue;
            }

            stack.push(fret);
            moveCount++;
        }

        System.out.println(moveCount);
    }
}
