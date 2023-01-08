package Algo_2022.day_4th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2243 {
    static long candy[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int S=1;
        while(S<1000000){
            S *= 2;
        }
        candy = new long[S*2];
        
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a==1){ //사탕 꺼내고 감소하는 업데이트
                int removeIdx = query(1,S,1,b);
                System.out.println(removeIdx);
                update(1,S,1,removeIdx,-1);
            }
            else{ //사탕 추가하는 업데이트
                long c = Long.parseLong(st.nextToken());
                update(1,S,1,b,c);
            }
//            for(int j=1;j<16;j++){
//                System.out.print(candy[j] +  " ");
//            }
//            System.out.println();

        }


    }

    private static int query(int left,int right,int idx,long Q) {
        int mid = (left+right)/2;
       // System.out.println(idx);
        if(left==right){
            return left;
        }
        if(candy[idx*2] >= Q) {//왼쪽
            return query(left,mid,idx*2,Q);
        }
        else{ //오른쪽
            return query(mid+1,right,idx*2+1,Q-candy[idx*2]);
        }
    }

    private static void update(int left,int right,int idx,int Q,long dif) {
//        if(left > Q || right <Q) return;
//        else{
//            int mid = (left+right)/2;
//            candy[idx]+=dif;
//            if(left==right)return;
//            update(left,mid,idx*2,Q,dif);
//            update(mid+1,right,idx*2+1,Q,dif);
//        }
        if(left <= Q && Q <= right){
            candy[idx] += dif;
            if(left!=right){
                int mid = (left+right)/2;
                update(left,mid,idx*2,Q,dif);
                update(mid+1,right,idx*2+1,Q,dif);
            }
        }
    }
}
