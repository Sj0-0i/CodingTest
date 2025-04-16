import java.util.*;

public class Main {
    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i <= 9; i++) {
            dfs(i, i);
        }

        Collections.sort(list);

        if (N >= list.size()) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(N));
        }
    }

    static void dfs(long num, int last) {
        list.add(num);

        for (int i = 0; i < last; i++) {
            dfs(num * 10 + i, i);
        }
    }
}
