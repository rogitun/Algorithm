package day_3rd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


public class test {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String input;

        int[] stack = new int[10000];
        int top = -1;
        int tmp;
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            input = st.nextToken();
            if(input.equals("push")){
                tmp = Integer.parseInt(st.nextToken());
                stack[++top]= tmp;
            }
            else if(input.equals("empty")){
                if(top==-1) System.out.println(1);
                else System.out.println(0);
            }
            else if(input.equals("pop")){
                if(top==-1) System.out.println(-1);
                else System.out.println(stack[top--]);
            }
            else if(input.equals("size")){
                if(top>=0) System.out.println(top+1);
                else System.out.println(0);
            }
            else if(input.equals("top")){
                if(top==-1) System.out.println(-1);
                else System.out.println(stack[top]);
            }
        }

        }
    }

