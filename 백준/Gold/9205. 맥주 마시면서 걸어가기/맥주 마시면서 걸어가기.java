import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }
    }

    static int n; 
    static Point[] locations;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); 

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine()); 
            locations = new Point[n + 2]; 
            visited = new boolean[n + 2];

            for (int i = 0; i < n + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                locations[i] = new Point(x, y);
            }

            if (bfs()) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }
        }
    }

    static boolean bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(0); // 집부터 시작
        visited[0] = true;

        while (!q.isEmpty()) {
            int current = q.poll();
            Point currPoint = locations[current];

            // 현재 위치에서 모든 다른 지점 확인
            for (int i = 0; i < n + 2; i++) {
                if (!visited[i]) {
                    int dist = Math.abs(currPoint.x - locations[i].x)
                             + Math.abs(currPoint.y - locations[i].y);

                    if (dist <= 1000) {
                        q.offer(i);
                        visited[i] = true;
                    }
                }
            }
        }

        return visited[n + 1]; 
    }
}
