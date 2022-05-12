package TT5_MAY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Boj_14891 {
    static ArrayList<Integer> al = new ArrayList<>();
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            String input = br.readLine();
            for (int j = 0; j < 8; j++) {
                char c = input.charAt(j);
                al.add(Integer.parseInt(String.valueOf(c)));
            }
        }

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            String[] s = br.readLine().split(" ");
            visit = new boolean[5];
            rotate(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }

        int[] idxs = {0, 8, 16, 24};
        int[] multi = {1, 2, 4, 8};
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += al.get(idxs[i]) * multi[i];
        }
        System.out.println(sum);
    }

    public static void rotate(int idx, int dir) {
        int first = 0;
        int last = 0;
        switch (idx) {
            case 1:
                first = 0;
                last = 7;
                break;
            case 2:
                first = 8;
                last = 15;
                break;
            case 3:
                first = 16;
                last = 23;
                break;
            case 4:
                first = 24;
                last = 31;
                break;
        }
        visit[idx] = true;
        int nextDir = (dir == 1) ? -1 : 1;

        //좌
        if (idx>1 && al.get(last-13) != al.get(last-1) && !visit[idx - 1]) {
            rotate(idx - 1, nextDir);
        }
        //우
        if (idx<4 && al.get(first+14) != al.get(first+2) && !visit[idx + 1]) {
            rotate(idx + 1, nextDir);
        }

        if (dir == 1) {
            al.add(first, al.remove(last));
        } else {
            al.add(last, al.remove(first));
        }
    }
}
