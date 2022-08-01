package TT8_AUG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_3273 {
    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/TT8_AUG/sample.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[T];
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int s = 0;
        int e = T-1;
        int result=0;
        while (s < e) {
            if(arr[s]+arr[e] == x){
                result++;
                e--;
            }
            else if(arr[s]+arr[e] < x){
                s++;
            }
            else
                e--;
        }
        System.out.println(result);
    }
}
