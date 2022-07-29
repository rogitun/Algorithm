package SwExpert.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Sw2930 {
    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/SwExpert/sample2.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        //연산1 - 3 삽입, 연산2 최대값 출력 후 삭제

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            StringTokenizer st;
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<n;i++) {
                st = new StringTokenizer(br.readLine());
                int cmd = Integer.parseInt(st.nextToken());
                if(cmd==1){
                    int num = Integer.parseInt(st.nextToken());
                    pq.offer(num);
                }
                else{
                    if(pq.isEmpty()) sb.append("-1 ");
                    else sb.append(pq.poll() + " ");
                }
            }
            System.out.println("#" + (t+1) + " " + sb.toString());
        }
    }
}
