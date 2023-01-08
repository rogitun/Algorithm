package Algo_2022.day_5th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_4375 {
    public static void main(String[] args) throws IOException {
        //(X Modular N) % N

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp = null;
        while((tmp = br.readLine())!=null){
            try{
                int n = Integer.parseInt(tmp);
                int count =1;
                int number = 1;
                while(true){
                    if(number%n==0) {
                        System.out.println(count);
                        break;
                    }
                    else{
                        count++;
                        number = (number*10+1)%n;
                    }
                }
            }catch (NumberFormatException e){
                break;
            }


        }

    }
}
