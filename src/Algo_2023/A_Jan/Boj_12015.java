package Algo_2023.A_Jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_12015 {
    static ArrayList<Integer> stack;

    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/lis/sample.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        stack = new ArrayList<>();
        stack.add(Integer.parseInt(st.nextToken()));
        for (int i = 1; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            insert(num);
        }
        //System.out.println(stack.toString());
        System.out.println(stack.size());
    }

    private static void insert(int num) {
        if (stack.size() == 1 && stack.get(0) < num) stack.add(num);
        else if(stack.get(stack.size()-1) < num) stack.add(num);
        else {
            int idx = binarySearch(num, stack.get(stack.size() - 1), 0, stack.size() - 1);
            //System.out.println("idx = " + idx + " num : " + num);
            stack.set(idx,num);
        }
    }

    private static int binarySearch(int lower, int upper, int start, int end) {
        if (start == end) return start;
        int mid = (start + end) / 2;
        int idx = start;
        if (lower <= stack.get(mid) && stack.get(mid) < upper) {
            idx = binarySearch(lower, upper, start, mid);
        } else {
            idx = binarySearch(lower, upper, mid + 1, end);
        }
        return idx;
    }
}
