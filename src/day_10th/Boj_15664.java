package day_10th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//dfs / solved
public class Boj_15664 {
    static int N;
    static int M;
    static int[] arr;
    static int[] visit;
    static ArrayList<Integer> stock = new ArrayList<>();
    static HashMap<String,Integer> hashMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr =new int[N];
        visit = new int[10001];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        dfs(0,0);

    }

    private static void dfs(int i,int len) {
        if(len==M){
            StringBuilder sb= new StringBuilder();
            for(int j=0;j<stock.size();j++){
                sb.append(stock.get(j) + " ");
            }
            if(hashMap.getOrDefault(sb.toString(),0)==0) {
                System.out.println(sb.toString());
                hashMap.put(sb.toString(), 1);
            }
            return;
        }
        else{
            for(int j=i;j<N;j++){
                if(visit[j]==0) {
                    visit[j]=1;
                    stock.add(arr[j]);
                    dfs(j + 1, len + 1);
                    visit[j]=0;
                    stock.remove(stock.size()-1);
                }
            }
        }
    }
}
