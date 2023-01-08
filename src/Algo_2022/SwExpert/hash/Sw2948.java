package Algo_2022.SwExpert.hash;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Sw2948 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/Algo_2022.SwExpert/sample2.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++){
            HashMap<String,Integer> map = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            int firstNumber = Integer.parseInt(st.nextToken());
            int secondNumber = Integer.parseInt(st.nextToken());
            int result =0;
            st = new StringTokenizer(br.readLine());

            for(int i=0;i<firstNumber;i++){
                String input = st.nextToken();
                map.put(input,1);
            }

            st = new StringTokenizer(br.readLine());

            for(int i=0;i<secondNumber;i++){
                String input = st.nextToken();
                int isValid = map.getOrDefault(input, 0);
                if(isValid!=0) result++;
            }
            System.out.println("#" + (t+1) + " " + result);
        }
    }
}
