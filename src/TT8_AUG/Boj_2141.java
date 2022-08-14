package TT8_AUG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2141 {
    static class Point implements Comparable<Point> {
        int pox;
        int num;

        public Point(int pox, int num) {
            this.pox = pox;
            this.num = num;
        }

        @Override
        public int compareTo(Point o) {
            return this.pox - o.pox;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/TT8_AUG/sample.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        Point[] town = new Point[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            town[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(town);


        long[] townSum = new long[n];
        townSum[0] = town[0].num;
        for (int i = 1; i < n; i++) { //누적합
            townSum[i] = town[i].num + townSum[i - 1];
        }

        long sum = townSum[n - 1]; //최대합

        //왼쪽 오른쪽 비교한다
        //그 차이가 가장 작은 쪽이 최적이다.
        //오른쪽이 왼쪽보다 작아지는 순간 최적을 벗어난다.

        long result = 0;

        for(int i=0;i<n;i++){
            long left = townSum[i];
            long right = sum - townSum[i];
            if(right <= left){
                result = town[i].pox;
                break;
            }
        }
        System.out.println(result);
    }
}
