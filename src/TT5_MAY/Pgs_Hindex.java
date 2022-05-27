package TT5_MAY;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Pgs_Hindex {
    public static void main(String[] args) {
        solution(new int[]{3,9,12,13,6,1,5});
    }
    public static int solution(int[] citations) {
        int answer = 0;
        Integer[] cit = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(cit,Collections.reverseOrder());

        for(int i=0;i<cit.length;i++){
            if(i+1 >= cit[i]){
                answer = Math.max(answer,cit[i]);
                break;
            }
            else answer += (i+1<=cit[i])?1:0;
        }
        return answer;
    }
}
