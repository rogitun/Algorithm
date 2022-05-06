package TT5_MAY;

import java.util.Arrays;
import java.util.HashMap;

public class Pgs_전화번호목록 {
    public static void main(String[] args) {
        //System.out.println(solution(new String[]{"119", "97674223", "1195524421"}));
        //System.out.println(solution(new String[]{"1","456","789"}));
        //System.out.println(solution(new String[]{"12","123","1235","567","88"}));
        System.out.println(solution(new String[]{"1234","12"}));
    }
    public static boolean solution(String[] phone_book) {
        HashMap<String,Integer> map = new HashMap<>();
        //입력을 우선 해시맵에 저장
        //각 문자열에 대하여 그 문자열의 크기만큼 for문
        //문자열의 접두어가 해시맵에 등록되어있는지 체크
        boolean answer = true;
        Arrays.sort(phone_book);
        for (String s : phone_book) {
            map.put(s,1);
            for(int i=1;i<s.length();i++){
                String substring = s.substring(0, i);
                if(map.getOrDefault(substring,0)>0){
                    return false;
                }
            }
        }
        return answer;
    }
}
