package day_3rd;

import java.util.ArrayList;
import java.util.List;

//최소힙
public class Boj_1927 {
    static List<Integer> list= new ArrayList<>();

    public void insert(int val){
        //마지막에 삽입.
        list.add(val);
        //부모와 비교
        //조건이 만족이거나 root까지 반복
        int cur = list.size()-1; //현재 인덱스
        int parent = cur/2; //부모 인덱스
        while(true){
            if(parent==0 || list.get(parent) <= list.get(cur)){
                break;
            }
            int tmp = list.get(parent);
            list.set(parent,list.get(cur));
            list.set(cur,tmp);
            cur = parent;
            parent = cur/2;

        }
    }

    public static int delete(){
        if(list.size()==1){
            return 0;
        }
        int top = list.get(1);
        // 1. 루트에 leaf 데이터 넣는다.
        list.set(1,list.get(list.size()-1));
        list.remove(list.size()-1);

        // 2. 자식괴 비교 후 조건이 맞지 않으면 swap;
        // 3. 조건이 만족되거나 leaf 까지
        int curPos = 1;
        while(true){
            int leftPos = curPos*2; int rightPos = curPos*2+1;
            if(leftPos >= list.size()) break; //자식이 없는 경우
            
            //왼쪽 먼저
            int minVal = list.get(leftPos);
            int minPos = leftPos;
            
            //오른쪽 자식 확인
            if(rightPos < list.size() && minVal > list.get(rightPos)) { //오른쪽 자식 존재
                minVal = list.get(rightPos);
                minPos = rightPos;
            }

            //스왑해야하는 조건
            if(list.get(curPos) > minVal){
                int tmp = list.get(curPos);
                list.set(curPos,minVal);
                list.set(minPos,tmp);
                curPos = minPos;
            }
            else{//스왑할 필요가 없으면
                break; 
            }
        }
        return top;
    }
    public static void main(String[] args) {

    }
}
