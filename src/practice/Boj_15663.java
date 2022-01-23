package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_15663 {
    static int N;
    static int M;
    static int arr[];
    static boolean visit[];
    static ArrayList<Integer> arrayList = new ArrayList<>();
    static HashMap<String,Integer> hashSet = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0);
    }

    private static void dfs(int count) {
        if(count==M) {
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<arrayList.size();i++){
                sb.append(arrayList.get(i));
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            if(hashSet.getOrDefault(sb.toString(),0)==0){
                System.out.println(sb.toString());
                hashSet.put(sb.toString(),1);
            }

            return;
        }
        else{
            for(int i=0;i<N;i++){
                if(!visit[i]){
                    visit[i] = true;
                    arrayList.add(arr[i]);
                    dfs(count+1);
                    visit[i]=false;
                    arrayList.remove(arrayList.size()-1);
                }
            }
        }
    }
}
