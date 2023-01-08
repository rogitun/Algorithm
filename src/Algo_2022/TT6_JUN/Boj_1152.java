package Algo_2022.TT6_JUN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] s = input.split(" ");
        int cnt=0;
        for (String s1 : s) if(!s1.equals(""))cnt++;
        System.out.println(cnt);
    }
}
