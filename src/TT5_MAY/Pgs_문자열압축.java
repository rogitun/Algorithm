package TT5_MAY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Pgs_문자열압축 {

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(br.readLine()));
        //solution("ababcdcdababcdcd");

    }
    public static int solution(String s) {
        int answer = s.length();
        //i의 크기만큼 잘라보기
        for(int i=1;i<=s.length()/2;i++){
            String pre = s.substring(0, i);
            String result = ""; //자른 결과
            int level=1;
            //다음 알파벳
            for(int j=i;j<=s.length();j+=i){
                int ep = (i+j)>s.length()?s.length():i+j;
                //System.out.println("j " + " " + j);
                String slice = s.substring(j, ep);
                //System.out.println("slice : " + slice);
                if(pre.equals(slice)){ //압축 가능
                    level++;
                }
                else{
                    if(level>1){
                        result += "(" + (level+pre) + ")";
                    }else{
                        result += pre;
                    }
                    //result += (level>1)?level+pre:pre;
                    level=1;
                    pre = slice;
                }
            }
            result+=pre;
            answer = Math.min(answer,result.length());
        }
        return answer;
    }
}
