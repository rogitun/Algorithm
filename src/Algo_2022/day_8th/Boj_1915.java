package Algo_2022.day_8th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1915 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            String tmp = br.readLine();
            for(int j=1;j<=m;j++){
                arr[i][j] = Integer.parseInt(String.valueOf(tmp.charAt(j-1)));
            }
        }
        int result = 0;
        for(int y=1;y<=n;y++){
            for(int x=1;x<=n;x++){
                if(arr[y][x]!=0) {
                    arr[y][x] = Math.min(Math.min(arr[y - 1][x - 1], arr[y - 1][x]), arr[y][x - 1]) + 1;
                    result = Math.max(result,arr[y][x]);
                }
            }
        }

//        for(int y=1;y<=n;y++){
//            for(int x=1;x<=n;x++){
//                System.out.print(arr[y][x]+ " ");
//            }
//            System.out.println();
//        }
        System.out.println(result*result);

    }
}
