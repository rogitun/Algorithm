package TT7_JUL;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_16916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String find = br.readLine();
        int kmp = kmp(input, find);

        System.out.println((kmp>0)?1:0);
    }

    private static int kmp(String input, String find) {
        int[] table = makeTable(input);
        int j =0;
        int result=0;
        for(int i=0;i<input.length();i++){
            while(j > 0 && input.charAt(i) != find.charAt(j)){
                j = table[j-1];
            }
            if(input.charAt(i) == find.charAt(j)){
                if(j == find.length()-1){
                    j = table[j];
                    result++;
                }
                else{
                    j++;
                }
            }
        }
        return result;
    }

    private static int[] makeTable(String input) {
        int[] al = new int[input.length()];
        int j =0;

        for(int i=1;i<input.length();i++){
            while(j > 0 && input.charAt(i) != input.charAt(j)){
                j = al[j-1];
            }
            if(input.charAt(i)==input.charAt(j)){
                al[i] = ++j;
            }
        }
        return al;
    }
}

