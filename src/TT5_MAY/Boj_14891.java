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
            //톱니바퀴 번호 + 방향(1=시계, -1 = 반시계)
            String[] s = br.readLine().split(" ");
            int num = Integer.parseInt(s[0]);//톱니번호
            int dir = Integer.parseInt(s[1]);// 방향
            visit = new boolean[5];
            rotate(num, dir);
        }

        //8개씩 받음
        //0~7/ 8~15/ 16~23/ 24~31

        //첫번쨰 톱니 => 2,6
        //두번째 => 10, 14
        //세번째 => 18, 22
        //네번째 => 26, 30
        int[] idxs = {0, 8, 16, 24};
        int[] multi = {1, 2, 4, 8};
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += al.get(idxs[i]) * multi[i];
        }
        System.out.println(sum);
    }



    public static void rotate(int idx, int dir) {
        int left = 0;
        int right = 0;
        int first = 0;
        int last = 0;
        switch (idx) {
            case 1:
                first = 0;
                left = 6;
                right = 2;
                last = 7;
                break;
            case 2:
                first = 8;
                left = 14;
                right = 10;
                last = 15;
                break;
            case 3:
                first = 16;
                left = 22;
                right = 18;
                last = 23;
                break;
            case 4:
                first = 24;
                left = 30;
                right = 26;
                last = 31;
                break;
        }
        visit[idx] = true;
        if (idx == 2 || idx == 3) { //양쪽도 검사후 rotate 돌려야함
            //자기 톱니 rotate , 1이면 시계, -1이면 반시계
            //본인기존 왼쪽=> left-12, 오른쪽 => right+12;
            if (al.get(left - 12) != al.get(left) && !visit[idx - 1]) { //왼쪽이 같은 극인지
                rotate(idx - 1, (dir == 1) ? -1 : 1);
            }
            if (al.get(right + 12) != al.get(right) && !visit[idx + 1]) {
                rotate(idx + 1, (dir == 1) ? -1 : 1);
            }
        } else { //자기 오른쪽 혹은 왼쪽만
            if (idx == 1) { //오른쪽만
                if (al.get(right + 12) != al.get(right) && !visit[idx + 1]) {
                    rotate(idx + 1, (dir == 1) ? -1 : 1);
                }
            } else { //왼쪽만
                if (al.get(left - 12) != al.get(left) && !visit[idx - 1]) {
                    rotate(idx - 1, (dir == 1) ? -1 : 1);
                }
            }
        }

        if (dir == 1) {
            Integer poll = al.remove(last);
            al.add(first, poll);
        } else {
            Integer poll = al.remove(first);
            al.add(last, poll);
        }
    }
}
