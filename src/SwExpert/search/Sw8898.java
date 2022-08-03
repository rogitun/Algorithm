package SwExpert.search;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Sw8898 {

    static int[] cows;
    static int min;
    static int pair;

    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/SwExpert/sample.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt(); //소의 수
            int m = sc.nextInt(); //말의 수
            // map = new HashMap<>();
            cows = new int[n];
            //소들의 위치

            min = 100000000;
            //c1 , c2
            int c1 = sc.nextInt(); //소의 위치는 (c1, 0, zi)
            int c2 = sc.nextInt(); //말의 위치는 (c2, 0, zj)

            for (int i = 0; i < n; i++) {
                cows[i] = sc.nextInt();
            }
            Arrays.sort(cows);
            for (int i = 0; i < m; i++) {
                int horse = sc.nextInt();
                //나보다 작은 최대값.
                binSearch(horse, cows.length);
                //나보다 큰 최소값
                minSearch(horse, cows.length);
            }


            int realDif = min + Math.abs(c2-c1);
            System.out.println("#" + t + " " + realDif + " " + pair);
        }
    }

    //나보다 큰 최소값
    private static void minSearch(int cow, int length) {
        int s = 0;
        int e = length-1;

        if(cows[e] < cow) return;

        while (s <= e) {
            int mid = (s + e) / 2;
            if (cows[mid] < cow) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }

        }
        if(s >= length) return;
        int dif = Math.abs(cows[s] - cow);

        if(dif == min) pair++;
        else if(dif < min){
            min = dif;
            pair = 1;
        }
    }

    //나보다 작은 최대값.
    private static void binSearch(int cow, int length) {
        //소와 말 거리의 식은 |c2 -c1| + |zj - zi|
        int s = 0;
        int e = length-1;

        if(cows[s] > cow) return;

        //cow보다 작은데 최고값 찾는다.
        while (s <= e) {
            int mid = (s + e) / 2;
            if (cows[mid] < cow) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        if(e < 0) return;

        int dif = Math.abs(cows[e] - cow);

        // System.out.println("max cow : " + cow + " dif : " + dif + " horse : " + horses[e]);
        if(dif == min) pair++;
        else if(dif < min){
            min = dif;
            pair = 1;
        }
    }
}