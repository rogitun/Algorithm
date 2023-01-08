package Algo_2022.day_6th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//위상정렬
public class Boj_2252 {
    static int[] degree;
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        degree = new int[N+1];

        for(int i=0;i<=N;i++){
            arrayList.add(new ArrayList<>());
        }


        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            arrayList.get(L).add(R);
            degree[R]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<degree.length;i++){
            if(degree[i]==0)
                queue.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            int out = queue.poll();
            //out == 4
            sb.append(out);
            sb.append(" ");
            //뽑은 학생이 가르키는 곳
            List<Integer> p = arrayList.get(out);

            for(int i=0;i<p.size();i++){
                int tmp = p.get(i);
                degree[tmp]--;
                if(degree[tmp]==0) {
                    queue.offer(tmp);
                }
            }
        }
        System.out.println(sb.toString());

    }
}
