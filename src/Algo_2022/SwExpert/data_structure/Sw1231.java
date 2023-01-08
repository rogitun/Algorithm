package Algo_2022.SwExpert.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw1231 {

    static class Node {
        char alp;
        int left;
        int right;

        public Node(String a, String l, String r) {
            this.alp = a.charAt(0);
            left = (l == null) ? 0 : Integer.parseInt(l);
            right = (r == null) ? 0 : Integer.parseInt(r);
        }
    }
    static Node[] trees;
    static StringBuilder result;
    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/Algo_2022.SwExpert/sample.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t = 1 ;t<=10;t++) {
            int n = Integer.parseInt(br.readLine());
            trees = new Node[101];
            result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                String[] s = br.readLine().split(" ");
                Node node = makeNode(s);
                trees[i + 1] = node;
            }
            inOrder(1);
            System.out.println("#" + t + " " + result);
        }
    }

    private static void inOrder(int idx) {
        if(trees[idx]==null) return;
        inOrder(idx*2);
        result.append(trees[idx].alp);
        inOrder(idx*2+1);
    }

    private static Node makeNode(String[] s) {
        if (s.length == 4) {
            return new Node(s[1], s[2], s[3]);
        } else if (s.length == 3) {
            return new Node(s[1], s[2], null);
        } else {
            return new Node(s[1], null, null);
        }
    }
}
