import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] height = new int[W];  // 블럭 높이 저장 배열
        int answer = 0;

        for (int i = 0; i < W; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < W - 1; i++) {
            int left = 0, right = 0;

            // 좌측 최대 높이 블럭
            for (int j = 0; j < i; j++) {
                left = Math.max(left, height[j]);
            }
            // 우측 최대 높이 블럭
            for (int j = i + 1; j < W; j++) {
                right = Math.max(right, height[j]);
            }
            // 현재 열 블럭이 좌측, 우측 블럭보다 작을 때
            if (height[i] < left && height[i] < right) {
                answer += Math.min(left, right) - height[i];
            }
        }
        System.out.println(answer);
    }

}