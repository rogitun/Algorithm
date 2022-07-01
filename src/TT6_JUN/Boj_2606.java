package TT6_JUN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int pair = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] al = new ArrayList[101];

        for(int i=0;i<101;i++) al[i] = new ArrayList<>();
        StringTokenizer st;
        for(int i=0;i<pair;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            al[s].add(e);
            al[e].add(s);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vist = new boolean[101];
        q.offer(1);
        vist[1] = true;
        int cnt =0;
        while(!q.isEmpty()){
            Integer now = q.poll();
            for(int i=0;i<al[now].size();i++){
                Integer next = al[now].get(i);
                if(!vist[next]) {
                    q.offer(next);
                    cnt++;
                    vist[next]=true;
                }
            }
        }
        System.out.println(cnt);
    }
}
