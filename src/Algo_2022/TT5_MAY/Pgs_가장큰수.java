package Algo_2022.TT5_MAY;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Pgs_가장큰수 {
    public String solution(int[] numbers) {
        String answer = "";
        ArrayList<String> al = new ArrayList<>();
        for(int x : numbers){
            al.add(Integer.toString(x));
        }
        al.sort(new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return (o2+o1).compareTo(o1+o2);
            }
        });
        if(al.get(0).charAt(0)=='0') return "0";
        for(String x : al){
            answer += x;
        }
        return answer;
    }
}
