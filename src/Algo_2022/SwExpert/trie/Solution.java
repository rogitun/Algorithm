package Algo_2022.SwExpert.trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Solution {
    static HashMap<String,Boolean> map;
    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/Algo_2022.SwExpert/sample.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());


        for(int t=1;t<=T;t++){
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();
            map = new HashMap<>();
            ArrayList<String> partial = new ArrayList<>();

            makePartial(input,partial);
            Collections.sort(partial);

            String res;
            if(n > partial.size()){
                res = "none";
            }
            else
                res = partial.get(n-1);
            System.out.println("#" + t + " " + res);
        }
    }

    private static void makePartial(String input, ArrayList<String> partial) {
        for(int i=0;i<input.length();i++){
            for(int j=i+1;j<=input.length();j++){
                String sub = input.substring(i, j);
                if(map.getOrDefault(sub,false)==false){
                    map.put(sub,true);
                    partial.add(sub);
                }
            }
        }
    }


}
