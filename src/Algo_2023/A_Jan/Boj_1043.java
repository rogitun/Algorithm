package Algo_2023.A_Jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_1043 {
    static int[] group;
    static boolean[] trueSeekers;

    public static void main(String[] args) throws IOException {


        // 1. 입력받은 내용으로 우선 거짓말하면 안되는 그룹을 추린다.
        // 2. 각 파티의 인원을 별도로 저장해서 for문을 돌리며 해당 인원이 거짓말하면 안되는 그룹에 속하는지 boolean 검사를 한다.

        System.setIn(new java.io.FileInputStream("./src/Algo_2023/A_Jan/sample.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //사람의 수
        int m = Integer.parseInt(st.nextToken()); //파티의 수

        st = new StringTokenizer(br.readLine());
        int tsNumber = Integer.parseInt(st.nextToken());

        group = new int[n + 1];
        trueSeekers = new boolean[n + 1];
        ArrayList<Integer>[] party = new ArrayList[m + 1];
        for (int i = 0; i < tsNumber; i++) {
            trueSeekers[Integer.parseInt(st.nextToken())] = true;
        }

        for (int i = 1; i <= n; i++) {
            group[i] = i;
        }

        for (int i = 1; i <= m; i++) { //파티
            party[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int join = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());
            party[i].add(first);

            for (int j = 1; j < join; j++) {
                int next = Integer.parseInt(st.nextToken());
                party[i].add(next);
                union(first, next);
                first = next;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (trueSeekers[i]) {
                trueSeekers[find(i)] = true;
            }
        }
        int result = 0;

        for (int i = 1; i < party.length; i++) {
            boolean flag = true;
            for (int x : party[i]) {
                if (trueSeekers[find(x)]) {
                    flag = false;
                    break;
                }
            }
            if (flag) result++;
        }
        System.out.println(result);


    }

    private static void union(int std, int next) {
        int sG = find(std);
        int nG = find(next);
        if (sG != nG) {
            if (sG < nG) {
                group[nG] = sG;
            } else {
                group[sG] = nG;
            }
        }
    }

    private static int find(int idx) {
        if (idx == group[idx]) return idx;
        else {
            return group[idx] = find(group[idx]);
        }
    }
}
