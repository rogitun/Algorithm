package day_1st;

import java.util.Arrays;
import java.util.Scanner;

//백준 1759
public class Problem1 {

    static char arr[];
    static int visit[];

    static int n;
    static int m;
    public static void dfs(int level,int index){
        if(level == n){
            String result="";
            int vowel = 0;
            int cosnant=0;
            for(int i=0;i<m;i++){
                if(visit[i]==1) {
                    if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i'
                            || arr[i] == 'o' || arr[i] == 'u') {
                        vowel++;
                    } else {
                        cosnant++;
                    }
                    result+=arr[i];
                }
            }
            if(vowel>=1 && cosnant>=2) {
                System.out.println(result);
            }
        }
        else{
            for(int j=index;j<m;j++){
                if(visit[j]==0) {
                    visit[j] = 1;
                    dfs(level + 1, j+ 1);
                    visit[j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        arr = new char[m];
        visit = new int[m];

        for(int i=0;i<m;i++){
            char tmp = kb.next().charAt(0);
            arr[i]=tmp;
        }
        Arrays.sort(arr);

        dfs(0,0);

    }
}
