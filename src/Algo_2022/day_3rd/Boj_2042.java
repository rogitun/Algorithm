package Algo_2022.day_3rd;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_2042 {
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st  = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        int S=1;
        while(S<=n){
            S*=2;
        }

        arr = new long[S*2+1];
        int idx = S;
        for(int i=0;i<n;i++){
            arr[idx++] = Long.parseLong(br.readLine());
        } //최적화 불가능 (입력)
        //S == 8

        //바텀업 초기화
        for(int i=(S+n-1)/2;i>=1;i--){
            arr[i] = arr[i*2] + arr[i*2+1];
        }

        //나머지 쿼리 입력
        for(int i=0;i<m+k;i++){ //입력 최적화 불가능
            st = new StringTokenizer(br.readLine()," ");
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if(a==2){
                bw.write(query(1,S,1,b,c) + "\n");
                bw.flush();
            }
            else if(a==1){
                long dif = c - arr[(int) (S+b-1)];
                update(1,S,1,b,dif);
            }
        }
        bw.close();

    }

    public static long query(int left,int right,int node,long queryLeft,long queryRight){
        if(right < queryLeft || left > queryRight) return 0; //범위 밖 -> 무시

        else if(queryLeft <= left && right <= queryRight) return arr[node];

        else { //걸침
            int mid = (left+right)/2;
            long leftValue = query(left,mid,node*2,queryLeft,queryRight);
            long rightValue = query(mid+1,right,node*2+1,queryLeft,queryRight);
            return leftValue+rightValue;
        }
    }
    public static void update(int left,int right,int node,long target,long diff){
        if(target < left || target > right) return; //타켓 미포함 -> 무시
        else{
            arr[node]+=diff;
            int mid = (left+right)/2;
            if(left==right)return;
            //왼쪽 탐색
            update(left,mid,node*2,target,diff);
            //오른쪽 탐색
            update(mid+1,right,node*2+1,target,diff);
        }
    }
}
