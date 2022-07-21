package SwExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Sw13501 {
    public static void main(String[] args) throws IOException {
       // System.setIn(new java.io.FileInputStream("./src/SwExpert/sample.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); //수열의 길이
            int M = Integer.parseInt(st.nextToken()); //추가 횟수
            int L = Integer.parseInt(st.nextToken()); //출력 인덱스 번호

            ArrayList<Integer> al = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                al.add(Integer.parseInt(st.nextToken()));
            }

            for(int k=0;k<M;k++){
                st = new StringTokenizer(br.readLine());
                char c = st.nextToken().charAt(0);
                int idx = Integer.parseInt(st.nextToken());
                if(c == 'I'){
                    int num = Integer.parseInt(st.nextToken());
                    al.add(idx,num);
                }
                else if(c == 'D'){
                    al.remove(idx);
                }
                else{
                    //chagne
                    int num = Integer.parseInt(st.nextToken());
                    al.add(idx,num);
                    al.remove(idx+1);
                }
            }
            if(al.size() > L){
                System.out.println("#" +(i+1)+ " " + al.get(L));
            }
            else System.out.println("#" +(i+1)+ " " + -1);
        }
    }
}
