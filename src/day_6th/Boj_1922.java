package day_6th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//크루스칼 알고리즘
public class Boj_1922 {
    static int N;
    static int M;

    public static class link implements Comparable<link> {
        int start;
        int end;
        int dis;
        public link(int start, int end,int dis) {
            this.start = start;
            this.end = end;
            this.dis = dis;
        }

        @Override
        public int compareTo(link o) {
            return this.dis - o.dis;
        }

        @Override
        public String toString() {
            return "link{" +
                    "start=" + start +
                    ", end=" + end +
                    ", dis=" + dis +
                    '}';
        }
    }
    static ArrayList<link> arrayList = new ArrayList<>();
    static int[] degree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        StringTokenizer st;

        degree = new int[N+1];
        for(int i=1;i<=N;i++){
            degree[i] = i;
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            arrayList.add(new link(s,e,d));
        }
        Collections.sort(arrayList);

        for(int i=0;i<arrayList.size();i++){
            link tmp = arrayList.get(i);
            if(find(tmp.start) != find(tmp.end)){
                union(tmp.start,tmp.end,tmp.dis);
            }
            else{

            }

        }
        System.out.println(sum);

    }
    static int sum=0;
    private static void union(int start, int end,int dis) {
        int aG = find(start);
        int bG = find(end);
        sum+=dis;
        degree[aG] = degree[bG];
    }

    private static int find(int start) {
        if(degree[start] == start) return start;
        else {
            return degree[start] = find(degree[start]);
        }
    }
}
