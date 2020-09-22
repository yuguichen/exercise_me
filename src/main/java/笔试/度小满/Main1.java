package 笔试.度小满;

import java.util.LinkedList;
import java.util.Scanner;


class Node{
    public int x;
    public int y;
    public int step;

    public Node(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }
}

public class Main1{
    private static final int MAX = 1005;
    private static final int BASE = 500;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean[][] visited = new boolean[MAX][MAX];
        int x = scanner.nextInt() + BASE;
        int y = scanner.nextInt() + BASE;
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++){
            int px = scanner.nextInt() + BASE;
            int py = scanner.nextInt() + BASE;
            visited[px][py] = true;
        }
        scanner.close();

        System.out.println(bfs(visited, x, y));
    }

    private static int bfs(boolean[][] visited, int ex, int ey){
        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        visited[BASE][BASE] = true;

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(BASE, BASE, 0));

        while (!queue.isEmpty()){
            Node node = queue.pollFirst();

            for(int[] dir : dirs){
                int x = node.x + dir[0];
                int y = node.y + dir[1];

                if(x < 0 || x > MAX || y < 0 || y > MAX)
                    continue;

                if(visited[x][y])
                    continue;

                if(x == ex && y == ey)
                    return node.step + 1;

                visited[x][y] = true;
                queue.add(new Node(x, y, node.step + 1));
            }
        }

        return -1;
    }

}