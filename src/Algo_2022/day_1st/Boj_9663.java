package Algo_2022.day_1st;

import java.util.Scanner;

public class Boj_9663 {
    static int n;
    static int[] board;
    static int result=0;

    public static boolean promising(int level){
        boolean flag = true;
        int prior = 1;

        while(prior<level && flag){
            if(board[level]==board[prior] ||
                    Math.abs(board[level]-board[prior])== Math.abs(level-prior))
                flag=false;
            prior++;
        }
        return flag;
    }

    public static void dfs(int level){
        if(promising(level)){
            if(level==n) result++;
            else{
                for(int i=1;i<=n;i++){
                    board[level+1]=i;
                    dfs(level+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        board=new int[15];
        dfs(0);
        System.out.println(result);
    }
}
