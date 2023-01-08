package Algo_2022.TT5_MAY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_14427 {

    static int N; // 수열의 수
    static int S = 1; //세그먼트 트리 가장 아래층 시작 인덱스
    static int[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        while(S < N){
            S *= 2;
        }
        tree = new int[S*2+1];

        for(int i=0;i<S*2;i++){
            tree[i] = 1000000000;
        }
        String[] s = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            tree[S+i] = Integer.parseInt(s[i]);
            update((S+i)/2);
        }

        int m = Integer.parseInt(br.readLine());

        for(int i=0;i<m;i++){
            String input = br.readLine();
            if(input.length()!=1){//update
                String[] c = input.split(" ");
                int idx = Integer.parseInt(c[1])+S-1;
                int number = Integer.parseInt(c[2]);
                tree[idx]=number;
                update(idx/2);
            }
            else{ //find
                int num = find(1,S,1,tree[1]);
                System.out.println(num-S+1);
            }
        }
    }

    private static int find(int left, int right,int idx,int num) {
        int mid = (left+right)/2;
        if(left==right){ //마지막 지점
            return idx;
        }
        if(tree[idx*2]==num){ //왼쪽에 있다.
            return find(left,mid,idx*2,num);
        }
        else {//오른쪽에 있다.
            return find(mid + 1, right, idx * 2 + 1, num);
        }
    }

    private static void update(int idx) {
        //bottom-up
        if(idx <=0) return;
        int leftIdx = (idx*2);
        int rightIdx = (idx*2)+1;

        tree[idx] = Math.min(tree[leftIdx],tree[rightIdx]);
        //위로 가려면 idx/2;
        update(idx/2);
    }
}
