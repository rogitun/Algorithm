package Algo_2022.SwExpert.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sw3000 {
    static PriorityQueue<Integer> maxHeap;
    static PriorityQueue<Integer> minHeap;

    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/Algo_2022.SwExpert/sample2.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            minHeap = new PriorityQueue<>();
            long result = 0;
            int n = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());
            maxHeap.offer(first);

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                minHeap.offer(l);
                maxHeap.offer(r);

                if (maxHeap.peek() > minHeap.peek()) {
                    int num = minHeap.poll();
                    int num2 = maxHeap.poll();
                    minHeap.offer(num2);
                    maxHeap.offer(num);
                }
                result = (result + maxHeap.peek()) % 20171109;
            }
            System.out.println("#" + (t + 1) + " " + result);
        }
    }
    // max : 5, 3, 2, 1
    // min : 6, 8, 9
    //최대 힙은 항상 최소 힙보다 1개 더 많아야함
    //최대 힙의 top이 최소힙의 top보다 크면 스왑
}
