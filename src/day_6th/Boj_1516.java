package day_6th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1516 {
    static int N;
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] dis = new int[N + 1];
        int[] degree = new int[N + 1];
        boolean[] before = new boolean[N + 1];
        StringTokenizer st;

        for (int i = 0; i <= N; i++) {
            arrayList.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int tmp = Integer.parseInt(st.nextToken());
            dis[i] = tmp;
            while (true) {
                tmp = Integer.parseInt(st.nextToken());
                if (tmp == -1) break;
                else {
                    arrayList.get(tmp).add(i);
                    degree[i]++;
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        int[] answer = new int[N+1];
        for(int i=1;i<=N;i++){
            if(degree[i]==0){
                queue.offer(i);
                answer[i] = dis[i];
            }
        }

        while(!queue.isEmpty()){
            int out  = queue.poll();
            ArrayList<Integer> tmp = arrayList.get(out);
            for(int i=0;i<tmp.size();i++){
                int idx = tmp.get(i);
                degree[idx]--;
                answer[idx] = Math.max(answer[idx],dis[idx]+answer[out]);
                if(degree[idx]==0) queue.offer(idx);
            }
        }

        for(int i=1;i<=N;i++){
            System.out.println(answer[i]);
        }


    }

}

