package Algo_2022.TT8_AUG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Boj_2036 {
    public static void main(String[] args) throws IOException {
        //n개의 정수로 이루어진 수열
        //한 정수 혹은 두 정수 제거 가능.
        //한 정수 제거 시 -> 점수에 추가
        //두 정수 제거 시 -> 곱이 점수에 추가
        //-> 수열에 아무 수도 남지 않게 되었을 때 점수의 총 합의 '최대'
        //ex) -1, 5, -3, 5 ,1
        //long형을 사용해야한다.
        System.setIn(new java.io.FileInputStream("./src/Algo_2022.TT8_AUG/sample.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Long> plus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Long> minus = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            long val = Long.parseLong(br.readLine());
            if (val > 0) plus.offer(val);
            else minus.offer(val);
        }

        long result = 0;

        while (!plus.isEmpty()) {
            Long poll = plus.poll();
            if (!plus.isEmpty()) {
                Long poll2 = plus.poll();
                result += Math.max(poll + poll2, poll2 * poll);
            } else {
                result += poll;
            }
        }

        while (!minus.isEmpty()) {
            Long poll = minus.poll();
            if (!minus.isEmpty()) {
                Long poll2 = minus.poll();
                result += poll * poll2;
            } else {
                result += poll;
            }
        }

        System.out.println(result);
    }
}
