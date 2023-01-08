package Algo_2022.TT8_AUG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1254 {
    public static void main(String[] args) throws IOException {
        //문자열을 잘라가면서 팰린드럼이 있는지 찾는다.
        //있다면 그 문자열의 앞 인덱스만큼 잘라 뒤집어 붙이면 팰린드롬이다.
        //없다면 그 전체를 뒤집어 붙여야한다.
        //qwerty =>
        //werty , erty, rty, ty, qwertytrewq
        System.setIn(new java.io.FileInputStream("./src/Algo_2022.TT8_AUG/sample.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            String sub = input.substring(i);
            StringBuilder reverse = new StringBuilder(sub).reverse();
            System.out.println(sub + " " + reverse);
            if (sub.equals(reverse.toString())) {
                // System.out.println("equal");
                //i-1번 만큼 문자열이 더 필요함
                if (i != 0) System.out.println(input.length() + i);
                else System.out.println(input.length());
                break;
            }
        }
    }
}
