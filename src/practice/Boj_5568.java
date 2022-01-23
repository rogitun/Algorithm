package practice;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Boj_5568 {
    static int N;
    static int K;
    static int[] arr;
    static int[] visited;
    static ArrayList<Integer> arrayList = new ArrayList<>();
    static HashSet<String> set = new HashSet<>();
    public static void dfs(int start,StringBuilder number,int count){
        if(count == K) {
            String tmp = "";
            for(int i=0;i<arrayList.size();i++){
                tmp+=arrayList.get(i);
            }
            set.add(tmp);
            //System.out.println(tmp);
            return;
        }
        else{
            for(int i=0;i<N;i++) {
                if (visited[i] == 0) {
                    visited[i] = 1;
                    arrayList.add(arr[i]);
                    dfs(i+1, number, count + 1);
                    visited[i] = 0;
                    arrayList.remove(arrayList.size()-1);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        StringBuilder sb = new StringBuilder();

        dfs(0,sb,0);

        System.out.println(set.size());




    }
}
