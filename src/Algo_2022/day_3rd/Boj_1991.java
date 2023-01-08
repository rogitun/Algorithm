package Algo_2022.day_3rd;

import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Boj_1991 {
    public static class Node{
        char data;
        Node left,right;

        public Node(char data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int n  = Integer.parseInt(br.readLine());
        TreeSet<Character> treeSet = new TreeSet<>();

        Node[] arr = new Node[n+1];
        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            char one = st.nextToken().charAt(0);
            char two = st.nextToken().charAt(0);
            char three = st.nextToken().charAt(0);




        }



    }

}
