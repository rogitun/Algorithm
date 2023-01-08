package Algo_2022.SwExpert.data_structure;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Sw1232 {
    static Node[] trees;
    static int N;
    static Stack<String> stack;

    static class Node {
        int idx;
        String num;
        int left;
        int right;

        public Node(int idx, String num, int left, int right) {
            this.idx = idx;
            this.num = num;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/Algo_2022.SwExpert/sample.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int T = 1; T <= 10; T++) {
            N = Integer.parseInt(br.readLine());
            trees = new Node[1001];
            stack = new Stack<>();
            for (int i = 0; i < N; i++) {
                String[] s = br.readLine().split(" ");
                int idx = Integer.parseInt(s[0]);
                if (s.length == 2) trees[idx] = new Node(idx, s[1], 0, 0);
                else trees[idx] = new Node(idx, s[1], Integer.parseInt(s[2]), Integer.parseInt(s[3]));
            }//i iter

            inOrder(1);
            double v = Double.parseDouble(stack.pop());
            System.out.println("#" + T + " " + (int)v);
        }
    }

    private static void inOrder(int idx) {
        if (trees[idx].left == 0) {
            stack.push(trees[idx].num);
            return;
        }
        inOrder(trees[idx].left);
        stack.push(trees[idx].num);
        inOrder(trees[idx].right);
        calc();
    }

    private static void calc() {
        double n2 = Double.parseDouble(stack.pop());//2
        String op = stack.pop();//
        double n1 = Double.parseDouble(stack.pop());//

        switch (op){
            case "*" :
                stack.push(Double.toString(n1 * n2));
                break;
            case "/" :
                stack.push(Double.toString(n1 / n2));
                break;
            case "+" :
                stack.push(Double.toString(n1 + n2));
                break;
            case "-" :
                stack.push(Double.toString(n1 - n2));
                break;
        }
    }
    // 9 / 6 - 4
}
