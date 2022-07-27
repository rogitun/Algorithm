package SwExpert.data_structure;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Sw1240 {
    static HashMap<String, Integer> map;

    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //System.setIn(new java.io.FileInputStream("./src/SwExpert/sample.txt"));
        map = new HashMap<>();
        map.put("3211", 0);
        map.put("2221", 1);
        map.put("2122", 2);
        map.put("1411", 3);
        map.put("1132", 4);
        map.put("1231", 5);
        map.put("1114", 6);
        map.put("1312", 7);
        map.put("1213", 8);
        map.put("3112", 9);


        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        for (int i = 0; i < n; i++) {
            int r = kb.nextInt();
            int c = kb.nextInt();
            int result=0;
            String[] input = new String[r];

            for (int j = 0; j < r; j++) {
                input[j] = kb.next();
            }

            for (int j = 0; j < r; j++) {
                boolean isOne = false;
                for (int k = 0; k < c; k++) {
                    if (input[j].charAt(k) == '1') isOne = true;
                }
                if (isOne) {
                    result = findCode(input[j]);
                }
            }
            System.out.println("#" + (i+1) + " " + result);
        }
    }
    //1이 존재하는 배열만 탐색한다.
    //첫 시작점부터 56개까지 substring 해서 검사한다.
    //만들어진 코드를 바탕으로 decode해서 뽑아낸다.


    private static int findCode(String s) {
        //첫 시작점부터 56개까지 일단 뽑아낸다.
        int si = 0;
        int ei = 56;
        int result;
        while (ei < s.length()) {
            char[] codes = s.substring(si, ei).toCharArray();
            int cnt = 1;
            String code = "";
            for (int i = 1; i < codes.length; i++) {
                if (codes[i] == codes[i - 1]) cnt++;
                else {
                    code += cnt;
                    cnt = 1;
                }
                if (cnt > 4) break;
            }
            code += cnt;
            if (code.length() == 32) {
               // System.out.println(code);
                result = decode(code);
                if(result!=0) return result;
            }
            si++;
            ei++;
        }
        return 0;
    }

    private static int decode(String secretKey) {
        int even = 0;
        int odd = 0;
        int sum;
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < secretKey.length(); i += 4) {
            String sub = secretKey.substring(i, i + 4);
            Integer val = map.getOrDefault(sub, -1);
            if (val == -1) return 0;
            else numbers.add(val);
        }

        for(int i=0;i<numbers.size();i++){
            if((i+1)%2==1) odd += numbers.get(i);
            else even += numbers.get(i);
        }

        sum = (odd*3)+even;

        if(sum%10==0){
            int result =0;
            for (Integer number : numbers) {
                result+= number;
            }
            return result;
        }

        return 0;
    }

}
