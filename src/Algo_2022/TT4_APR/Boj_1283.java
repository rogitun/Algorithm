package Algo_2022.TT4_APR;

import java.io.*;
import java.util.*;

public class Boj_1283 {
    static HashMap<Character,Integer> hashMap = new HashMap<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            String input = br.readLine();
            shortCut(input);
        }
        bw.flush();
        bw.close();
    }
    private static void shortCut(String input) throws IOException {
        String[] s = input.split(" ");
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (String s1 : s) {
            char c = s1.charAt(0);
            char lowerC = Character.toLowerCase(c);
            if(flag && hashMap.getOrDefault(lowerC,0)==0 && lowerC!=' '){ //저장된 단축키 없음
                hashMap.put(lowerC,1);
                sb.append("[" + c + "]" + s1.substring(s1.indexOf(c)+1) + " ");
                flag = false;
            }
            else{
                sb.append(s1 + " ");
            }
        }
        if(!flag){
            bw.write(sb + "\n");
        }
        else {
            String output ="";
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                char lowerC = Character.toLowerCase(c);
                if (flag && hashMap.getOrDefault(lowerC, 0) == 0 && lowerC != ' ') { //저장된 단축키 없음
                    hashMap.put(lowerC, 1);
                    output+="[" + c + "]";
                    flag=false;
                }
                else
                    output+=c;
            }
            bw.write(output + "\n");
        }
    }
}
