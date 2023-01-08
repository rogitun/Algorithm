package Algo_2022.TT2_FEB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_15684 {
    static int N; //세로 선 개수
    static int M; //가로 선 개수 -> 주어지는 기본 가로선
    static int H; //가로 선 가능한 위치 H
    static ArrayList<Point> arrayList = new ArrayList<Point>();
    static int[][] ladder;

    public static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        ladder = new int[H + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            ladder[h][p] = p + 1;
            ladder[h][p + 1] = p;
        }
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= N; j++) {
                if (ladder[i][j] == 0) {
                    arrayList.add(new Point(i, j));
                }
            }
        }

        //사다리 이동 함수=> 이동해서 원하는 결과인지 i 가 i인지 판단도 해야함
        if (move()) {
            System.out.println(0);
        }
        else {
            for (int i = 1; i <= 3; i++) {
                boolean test = setting(i);
                if (test) {
                    System.out.println(i);
                    return;
                }
            }
            System.out.println(-1);
        }


    }

    //line = 추가 선 몇개로 가능한지
    //number = 추가 선 증가
    public static boolean setting(int line) {
        //추가 사다리 배치
        boolean result = false;

        if (line == 1) { //추가 선 1개로만
            for (int i = 0; i < arrayList.size(); i++) {
                Point next = arrayList.get(i);
                if (next.x + 1 <= N && ladder[next.y][next.x] == 0 && ladder[next.y][next.x + 1] == 0) {
                    ladder[next.y][next.x] = next.x + 1;
                    ladder[next.y][next.x + 1] = next.x;
                    result = move();
                    if (result) {
                        return true;
                    }
                    ladder[next.y][next.x] = 0;
                    ladder[next.y][next.x + 1] = 0;
                }
            }
        } else if (line == 2) { //추가 선 2개로
            for (int i = 0; i < arrayList.size(); i++) {
                Point first = arrayList.get(i); //첫번째 선
                if (first.x + 1 <= N && ladder[first.y][first.x + 1] == 0 && ladder[first.y][first.x] == 0) {
                    ladder[first.y][first.x] = first.x + 1;
                    ladder[first.y][first.x + 1] = first.x;
                    for (int j = i + 1; j < arrayList.size(); j++) {
                        Point second = arrayList.get(j);
                        if (second.x + 1 <= N && ladder[second.y][second.x + 1] == 0 && ladder[second.y][second.x] == 0) { //범위를 벗어나지 않으면
                            ladder[second.y][second.x] = second.x + 1;
                            ladder[second.y][second.x + 1] = second.x;
                            result = move();
                            if (result)
                                return true;
                            else if (!result) {
                                ladder[second.y][second.x] = 0;
                                ladder[second.y][second.x + 1] = 0;
                            }
                        }
                    }
                    ladder[first.y][first.x] = 0;
                    ladder[first.y][first.x + 1] = 0;
                }
            }
        } else {
            for (int i = 0; i < arrayList.size(); i++) {
                Point first = arrayList.get(i); //첫번째 선
                if (first.x + 1 <= N && ladder[first.y][first.x + 1] == 0 && ladder[first.y][first.x] == 0) {
                    ladder[first.y][first.x] = first.x + 1;
                    ladder[first.y][first.x + 1] = first.x;
                    for (int j = i + 1; j < arrayList.size(); j++) {
                        Point second = arrayList.get(j);
                        if (second.x + 1 <= N && ladder[second.y][second.x + 1] == 0 && ladder[second.y][second.x] == 0) { //범위를 벗어나지 않으면
                            ladder[second.y][second.x] = second.x + 1;
                            ladder[second.y][second.x + 1] = second.x;
                            for (int k = j + 1; k < arrayList.size(); k++) {
                                Point third = arrayList.get(k);
                                if (third.x + 1 <= N && ladder[third.y][third.x + 1] == 0 && ladder[third.y][third.x] == 0) {
                                    ladder[third.y][third.x] = third.x + 1;
                                    ladder[third.y][third.x + 1] = third.x;
                                    result = move();
                                    if (result)
                                        return true;
                                    else if (!result) {
                                        ladder[third.y][third.x] = 0;
                                        ladder[third.y][third.x + 1] = 0;
                                    }
                                }
                            } //for-k
                            ladder[second.y][second.x] = 0;
                            ladder[second.y][second.x + 1] = 0;
                        }
                    }
                    ladder[first.y][first.x] = 0;
                    ladder[first.y][first.x + 1] = 0;
                }
            }
        }
        return false;
    }

    public static boolean move() {
        for (int i = 1; i <= N; i++) {
            int x = i;
            int y = 1;
            while (y <= H) {
                if (ladder[y][x] == 0) { //그냥 아래로 한칸 내려감
                    y++;
                } else {
                    x = ladder[y][x];
                    y++;
                }
            }
            if (i != x) {//시작과 끝이 같은 라인이다.
                return false;
            }
        }
        return true;
    }

}
