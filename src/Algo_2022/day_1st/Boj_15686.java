package Algo_2022.day_1st;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj_15686 {
    static int n;
    static int m;

    static ArrayList<Point> home = new ArrayList<>();
    static ArrayList<Point> chicken = new ArrayList<>();

    static int[] array;
    static int result=Integer.MAX_VALUE;

    public static class Point{
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void dfs(int level,int start) {
      if(level==m){
//          for(int x: array)
//              System.out.print(x + " ");
//          System.out.println();
          int sum=0;
          for(Point h : home){
              int delivery = Integer.MAX_VALUE;
              for(int idx : array){
                  delivery = Math.min(delivery,
                          Math.abs(h.x - chicken.get(idx).x)+
                          Math.abs(h.y - chicken.get(idx).y));
              }
              sum+=delivery;
          }
          result = Math.min(result,sum);
      }
      else{
          for(int i = start; i< chicken.size(); i++){
              array[level]=i;
              dfs(level+1,i+1);
          }
      }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt(); m= kb.nextInt();
        array = new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int pt = kb.nextInt();
                if(pt==1) home.add(new Point(i,j));
                if(pt==2) chicken.add(new Point(i,j));
            }
        }
        dfs(0,0);
        System.out.println(result);
    }


}
