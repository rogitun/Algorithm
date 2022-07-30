package SwExpert.hash.Sw9467;

import java.util.*;

public class UserSolution {


    //String 전체를 돌면서 3 길이의 문자열을 만든다.
    //그 문자열을 가지고 해쉬값을 생성한다
    //그 해쉬값이 어디에 등장하는지 idx를 저장한다.
    static int idx;
    HashMap<String, Integer> hashMap;
    ArrayList<Integer>[] al;
    char[] origin;

    void init(int n, char[] init_string) {
        hashMap = new HashMap<>();
        idx = 1;
        al = new ArrayList[20000];
        for (int i = 0; i < 20000; i++) {
            al[i] = new ArrayList<>();
        }
        origin = new char[n];
        for (int i = 0; i < n; i++) {
            origin[i] = init_string[i];
        }

        for (int i = 0; i < n - 2; i++) {
            addNewIndex(i);
        }
    }

    int change(char[] string_A, char[] string_B) {
        String A = "";
        String B = "";
        for (int i = 0; i < string_A.length - 1; i++) {
            A += string_A[i];
            B += string_B[i];
        }
        //A의 문자열을 B로 변환시킴
        int res = findString(A, B);
        return res;
    }

    private int findString(String a, String b) {
        int hashIdx = hashMap.getOrDefault(a,-1);
        //해당 idx를 가장 가진 배열에서 가장 첫번째
        if (hashIdx==-1) {
            return 0;
        }
        //순서
        //1. 이전 문자열 인덱스 삭제
        //2. 현재 문자열로 변경
        //3. 현재 문자열 인덱스 등록 및 정렬
        int myIdx = 0;
        int arrIdx = 0;
        int cnt =0;
        Collections.sort(al[hashIdx]);
        while(true) {
            if(arrIdx >= al[hashIdx].size()) break;
            int findIdx = al[hashIdx].get(arrIdx); //가장 먼저 바꿔야하는 문자열 위치
            if(myIdx > findIdx) {
                arrIdx++;
                continue;
            }
            int start = (findIdx - 2 < 0) ? 0 : findIdx - 2; //변경 범위 첫번째
            int end = findIdx + 4;
            if (end > origin.length-1) end = origin.length - 1; //변경 범위 마지막

            //1. 이전 문자열 인덱스 삭제
            for (int i = start; i <= end - 2; i++) {
                String tmp = makeString(i);
                int delIdx = hashMap.get(tmp);
                al[delIdx].remove(Integer.valueOf(i));
            }
            //2. 현재 문자열로 변경
            for (int i = findIdx; i <= findIdx + 2; i++) {
                origin[i] = b.charAt(i - findIdx);
            }
            //3. 현재 문자열 인덱스 등록 및 정렬
            for (int i = start; i <= end - 2; i++) {
                addNewIndex(i);
            }
            myIdx = findIdx+3;
            cnt++;
        }
        return cnt;
    }

    private String makeString(int i) {
        String tmp = "";
        tmp += origin[i];
        tmp += origin[i + 1];
        tmp += origin[i + 2];
        return tmp;
    }

    private void addNewIndex(int i) {
        String tmp = makeString(i);
        if (hashMap.getOrDefault(tmp, 0) == 0) {
            hashMap.put(tmp, idx);
            al[idx].add(i);
            idx++;
        } else {
            int idx = hashMap.get(tmp);
            al[idx].add(i);
        }
    }

    void result(char[] ret) {
        for(int i=0;i<origin.length;i++){
            ret[i] = origin[i];
        }
    }
}
