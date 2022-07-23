package SwExpert;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Sw1248 {
    static int[][] tree;
    static ArrayList<Integer> a1;
    static ArrayList<Integer> a2;
    static int result;

    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/SwExpert/sample.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            String[] input = br.readLine().split(" ");//정점, 간선, 공통조상 2개 번호
            int nodeNum = Integer.parseInt(input[0]);
            int edgeNum = Integer.parseInt(input[1]);
            int one = Integer.parseInt(input[2]);
            int two = Integer.parseInt(input[3]);
            tree = new int[nodeNum + 1][3];
            ArrayList<Integer> a1 = new ArrayList<>();
            ArrayList<Integer> a2 = new ArrayList<>();
            result = 0;

            String[] nums = br.readLine().split(" ");
            for (int j = 0; j < nums.length; j += 2) {
                int s = Integer.parseInt(nums[j]);
                int e = Integer.parseInt(nums[j + 1]);
                tree[e][0] = s;

                if (tree[s][1] == 0) tree[s][1] = e;
                else tree[s][2] = e;

            }
            find(one, a1);
            find(two, a2);
            int common = compare(a1, a2);
            search(common);
            System.out.println("#" + i + " " + common + " " + result);
        }
    }

    private static void search(int idx) {
        result++;
        if (tree[idx][1] != 0) search(tree[idx][1]);
        if (tree[idx][2] != 0) search(tree[idx][2]);
    }

    private static int compare(ArrayList<Integer> a1, ArrayList<Integer> a2) {
        int idx1 = 0;
        int idx2 = 0;

        if (a1.size() > a2.size()) idx1 = a1.size() - a2.size();
        else if (a2.size() > a1.size()) idx2 = a2.size() - a1.size();

        while (idx1 < a1.size()) {
            int num1 = a1.get(idx1++);
            int num2 = a2.get(idx2++);
            if (num1 == num2) {
                return num1;
            }
        }
        return 1;
    }

    private static void find(int idx, ArrayList<Integer> al) {
        if (idx == 1) {
            al.add(1);
            return;
        }
        al.add(idx);
        find(tree[idx][0], al);
    }
}
