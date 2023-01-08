package Algo_2022.TT2_FEB;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_1275 {
    static int N;
    static int Q;
    static int S;
    static long[] tree;
    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        S = 1;

        while(S<N) {
            S *= 2;
        }
        tree = new long[S*2]; //세그먼트 트리 구성, 완전이진트리

        //첫 배열 입력
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
            update(1,S,1,i,Integer.parseInt(st.nextToken())); //시작값 대입
        }

        //update 로 처음 값 넣어주고 다음 입력에 대해서는 find로 찾고 update 진행한다.

        for(int i=0;i<Q;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); //x~y까지의 합
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken()); //a번째 수를 b로 바꿔라.
            long b = Integer.parseInt(st.nextToken());
            result = 0;
            if(x>y) find(1,S,y,x,1);
            else find(1,S,x,y,1);

            long changeNumber = tree[S+a-1];
            //System.out.println( "chgnum "+changeNumber);
            update(1,S,1,a,b-changeNumber);
            System.out.println(result);
            //bw.write(result + "\n");
            //bw.flush();
            //System.out.println("=======================");
        }

    }

    private static void find(int start,int end,int left, int right,int node) {
        if(node >= S*2 || (start > right || end < left)) return;
        if(start>= left && end <=right)
            result += tree[node];
        else {
            int mid = (start+end)/2;
            find(start,mid,left,right,node*2);
            find(mid+1,end,left,right,node*2+1);
        }
    }

    //start , end 는 leaf 노드의 인덱스 번호를 의미한다.
    //node는 현재 노드의 번호를 의미한다.
    //Q는 가고자 하는 위치를 의미한다.
    private static void update(int start, int end, int node, int Q, long number) {
        if(node >= S*2) return;
        if(start <= Q && end >= Q) {
            int mid = (start+end)/2;
            tree[node]+=number;
            update(start,mid,node*2,Q,number);
            update(mid+1,end,node*2+1,Q,number);
        }
    }
}
