package Mar_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_15666 {
    static int n,m;
    static ArrayList<Integer> al;
    static String[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] tmp = new int[n];
        al = new ArrayList<>();
        result = new String[m];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            tmp[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tmp);

        al.add(tmp[0]);
        for(int i=1;i<tmp.length;i++){
            if(tmp[i-1] == tmp[i])continue;
            al.add(tmp[i]);
        }

       dfs(0,0);
    }

    private static void dfs(int idx, int level) {
        if(level==m){
            for(int i=0;i<m;i++){
                System.out.print(result[i] + " ");
            }
            System.out.println();
        }

        else{
            for(int i=idx;i<al.size();i++){
                    result[level] = Integer.toString(al.get(i));
                    dfs(i, level + 1);
            }
        }
    }
}
