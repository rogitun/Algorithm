package Algo_2022.SwExpert.trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

//Sw1256
public class Sw1256 {
    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/Algo_2022.SwExpert/sample.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++){
            int n = Integer.parseInt(br.readLine());

            String input = br.readLine();

            String[] partial = new String[input.length()];
            makePart(input,partial);

            Arrays.sort(partial);
            System.out.println("#" + t + " " + partial[n-1]);
        }

    }

    private static void makePart(String input, String[] partial) {
        for(int i=0;i<input.length();i++){
            partial[i] = input.substring(i,input.length());
        }
    }
}
