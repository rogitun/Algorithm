package Algo_2022.TT5_MAY;

import java.util.HashMap;

public class Pgs_완주하지못한선수 {

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> comp = new HashMap<>();
        for (String s : completion) {
            comp.put(s,comp.getOrDefault(s,0)+1);
        }
        for (String s : participant) {
            Integer orDefault = comp.getOrDefault(s, 0);
            if(orDefault>0){
                comp.replace(s, comp.get(s)-1);
            }
            if(orDefault==0)
                answer=s;
        }
        return answer;
    }
}
