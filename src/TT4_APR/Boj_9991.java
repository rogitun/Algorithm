package TT4_APR;

import java.io.*;
import java.util.*;

public class Boj_9991 {
    static ArrayList<String> al;
    static HashMap<String,Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int w,n;
        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        al = new ArrayList<>();

        for(int i=0;i<w;i++){
            String input = br.readLine();
            char apb = input.charAt(0);
            al.add(input);
            map.put(input,i+1);
        }
        Collections.sort(al); //단어사전 정렬
//        for (String s : al) {
//            System.out.println(s);
//        }
        for(int i=0;i<n;i++){
            String[] s = br.readLine().split(" ");
            int num = Integer.parseInt(s[0]);
            String let = s[1];
            binary(num,let);
//            System.out.println(map.get(al.get(binary+num-1)));
        }
    }
    //TODO 이분탐색으로 let 으로 시작하는 단어들 중에서 da의 시작점을 찾는다.
    private static void binary(int num,String let) {
        int s=0;
        int e=al.size()-1;
        while(s<e){
            int mid = (s+e)/2;
            //더 앞에오면 -1, 같으면 0, 뒤에 있으면 1
            int subRange = al.get(mid).length()<let.length()?al.get(mid).length():let.length();
            if(al.get(mid).substring(0,subRange).compareTo(let)>=0){
                e = mid-1;
            }
            else{
                //앞에 온다.
                s = mid+1;
            }
        }
        //s는 전체 사전에서 시작 위치
        int fixIdx = al.get(s).startsWith(let)?s-1:s;
        //결과는 get(s + num);

        if(fixIdx+num >= al.size() || !al.get(fixIdx+num).startsWith(let)){
            System.out.println(-1);
            return;
        }
        System.out.println(map.get(al.get(fixIdx+num)));
    }
    //TODO 그 시작점을 기준으로 +Num 만큼 해서 그 단어를 가져온다
    //TODO HashMap으로 그 단어의 단어사전 속 idx를 찾는다.
}
