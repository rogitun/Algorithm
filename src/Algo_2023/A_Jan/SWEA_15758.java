package Algo_2023.A_Jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_15758 {
    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/Algo_2023/A_Jan/sample.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int T = 1; T <= tc; T++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            String t = st.nextToken();

            int commonMax = s.length() * t.length();

            StringBuilder sBuilder = new StringBuilder(s);
            StringBuilder tBuilder = new StringBuilder(t);

            while (sBuilder.length() < commonMax) {
                sBuilder.append(s);
            }
            while (tBuilder.length() < commonMax) {
                tBuilder.append(t);
            }
            String result = "yes";
            if (!sBuilder.toString().equals(tBuilder.toString())) {
                result = "no";
            }

            System.out.println(sBuilder + " " + tBuilder);


            System.out.println("#" + (T) + " " + result);
        }
    }

    public void test() {
        int tc = 0;

//        for (int T = 0; T < tc; T++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            String s = st.nextToken();
//            String t = st.nextToken();
//
//            if (s.length() < t.length()) {
//                String temp = s;
//                s = t;
//                t = temp;
//            }
//
//            String result = "yes";
//            int tLen = 0;
//            for (int i = 0; i < s.length(); i++) {
//                tLen = i % t.length();
//                if (s.charAt(i) != t.charAt(tLen)) {
//                    result = "no";
//                    break;
//                }
//            }
//            if (tLen != t.length() - 1) {
//                tLen = (s.length()) % t.length();
//                if (s.charAt(0) != t.charAt(tLen)) {
//                    result = "no";
//                }
//            }
//        }
    }
}
