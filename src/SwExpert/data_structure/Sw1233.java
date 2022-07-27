package SwExpert.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Sw1233 {
    static String[] trees;
    static int N;
    static Stack<String> stack;
    static boolean result;

    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/SwExpert/sample.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int T = 1; T <= 10; T++) {
            trees = new String[201];
            stack = new Stack<>();
            N = Integer.parseInt(br.readLine());
            result = true;

            for (int i = 0; i < N; i++) {
                String[] s = br.readLine().split(" ");
                trees[Integer.parseInt(s[0])] = s[1];
            }
            inOrder(1);
            System.out.println("#" + T + " " + (result?"1":"0"));
        }
    }

    private static boolean calc() {
        String num2 = stack.pop();
        String op = stack.pop();
        String num = stack.pop();

        if (num.equals("-") || num.equals("+") || num.equals("/") || num.equals("*")) return false;
        if (num2.equals("-") || num2.equals("+") || num2.equals("/") || num2.equals("*")) return false;
        int sum = 0;
        switch (op) {
            case "*":
                sum = Integer.parseInt(num) * Integer.parseInt(num2);
                stack.push(Integer.toString(sum));
                break;
            case "-":
                sum = Integer.parseInt(num) - Integer.parseInt(num2);
                stack.push(Integer.toString(sum));
                break;
            case "/":
                sum = Integer.parseInt(num) / Integer.parseInt(num2);
                stack.push(Integer.toString(sum));
                break;
            case "+":
                sum = Integer.parseInt(num) + Integer.parseInt(num2);
                stack.push(Integer.toString(sum));
                break;
        }
        return true;
    }

    private static void inOrder(int idx) {
        if (!result || idx > N  || trees[idx] == null) return;
        inOrder(idx * 2);
        //
        stack.push(trees[idx]);
        if (stack.size() == 3) {
            if (!calc()) {
                result = false;
                return;
            }
        }
        inOrder(idx * 2 + 1);
    }
}
