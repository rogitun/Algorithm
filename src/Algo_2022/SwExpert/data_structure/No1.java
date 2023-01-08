package Algo_2022.SwExpert.data_structure;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class No1 {

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new java.io.FileInputStream("./src/Algo_2022.SwExpert/sample.txt"));
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        for(int i=1;i<=n;i++){
            int count = 0; //10이면 통과
            boolean[] numberCheck = new boolean[10]; //0~9
            int x = kb.nextInt();
            int idx = 1;
            while(count < 10){
                String now = Integer.toString(x * idx);

                for(int j=0;j<now.length();j++){
                    int c = Character.getNumericValue(now.charAt(j));
                    if(!numberCheck[c]){
                        numberCheck[c] = true;
                        count++;
                    }
                }
                idx++;
            }
            System.out.println("#" + i + " " + x*(idx-1));
        }
    }
}
