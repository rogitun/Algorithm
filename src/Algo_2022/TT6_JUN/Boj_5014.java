package Algo_2022.TT6_JUN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_5014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] button  = new int[1000001];
        Queue<Integer> q = new LinkedList<>();
        q.offer(S);
        button[S]=1;
        while(!q.isEmpty()){
            Integer now = q.poll();

            if(now==G){
                System.out.println(button[now]-1);
                return;
            }
            if(now+U <= F && button[now+U]==0){
                button[now+U] = button[now]+1;
                q.offer(now+U);
            }
            if(now-D > 0 && button[now-D]==0){
                button[now-D] = button[now]+1;
                q.offer(now-D);
            }
        }
        System.out.println("use the stairs");
    }
}
