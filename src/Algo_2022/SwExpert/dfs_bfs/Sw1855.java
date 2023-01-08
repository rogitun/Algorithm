package Algo_2022.SwExpert.dfs_bfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sw1855 {

    static class Point{
        int index;
        int depth;
        LinkedList<Point> child;

        public Point(int index, int depth) {
            this.index = index;
            this.depth = depth;
            this.child = new LinkedList<>();
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/Algo_2022.SwExpert/sample2.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] tree = new int[n+1][18];
            Point[] data = new Point[n+1];
            data[1] = new Point(1,1);

            String[] s = br.readLine().split(" ");
            for (int i = 0; i < n-1; i++) {
                int p = Integer.parseInt(s[i]);
                data[i+2] = new Point(i+2,data[p].depth+1);
                tree[i+2][0] = data[p].index;
                data[p].child.add(data[i+2]);
            }
            for(int i=0;i<17;i++){
                for(int j=1;j<=n;j++){
                    if(tree[j][i]!=0) tree[j][i+1] = tree[tree[j][i]][i];
                }
            }
            long result=0L;
            Point prev = data[1];
            Queue<Point> queue = new LinkedList<>();
            queue.offer(data[1]);

            while(!queue.isEmpty()) {
                Point current = queue.poll();
                for(Point c : current.child) queue.offer(c);

                int a;
                int b;
                if(current.depth >= prev.depth) {
                    a = current.index;
                    b = prev.index;
                } else {
                    a = prev.index;
                    b = current.index;
                }
                int diff = data[a].depth - data[b].depth;
                for(int i = 0; diff > 0; i++) {
                    if(diff % 2 == 1) a = tree[a][i];
                    diff = diff >> 1;
                }

                if(a != b) {
                    for(int i = (18 - 1); i >= 0; i--) {
                        if(tree[a][i] != 0 && tree[a][i] != tree[b][i]) {
                            a = tree[a][i];
                            b = tree[b][i];
                        }
                    }
                    a = tree[a][0];
                }
                result += (current.depth + prev.depth) - (data[a].depth << 1);
                prev = current;
            }
            System.out.println("#" + (t+1) + " " + result);
        }
    }
}
