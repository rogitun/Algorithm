package Algo_2022.day_4th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_9202_helped {

    public static class Node {
        char data;
        Node child[] = new Node[26];
        boolean isHit;
        boolean isEnd;

        boolean hasChild(char c) {
            return child[c - 'A'] != null;
        }

        Node getChild(char c) {
            return child[c - 'A'];
        }

        void clearHit() {
            isHit = false;
            for (int i = 0; i < child.length; i++) {
                Node c = child[i];
                if (c != null)
                    c.clearHit();
            }
        }
    }


    static Node root = new Node();
    static StringBuilder sb;

    static int[] xp = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] yp = {0, 0, 1, -1, -1, 1, -1, 1};
    static char[][] board = new char[4][4];
    static int[][] visited = new int[4][4];

    static int sum = 0;
    static int[] score = {0, 0, 0, 1, 1, 2, 3, 5, 11}; //단어 길이 점수
    static int count; // 단ㅇ ㅓ갯수
    static String answer;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            insertTrie(br.readLine());
        }
        br.readLine();

        int b = Integer.parseInt(br.readLine());

        StringBuilder resultSb = new StringBuilder();
        for(int i=0;i<b;i++){
            board = new char[4][4];
            visited = new int[4][4];
            answer = "";
            sum=0;
            count =0;
            sb = new StringBuilder();

            for(int j=0;j<4;j++){
                String input = br.readLine();
                for(int k=0;k<4;k++){
                    board[j][k] = input.charAt(k);
                }
            }
            br.readLine();
            for(int y=0;y<4;y++){
                for(int x=0;x<4;x++){
                    if(root.hasChild(board[y][x])){
                        search(y,x,1,root.getChild(board[y][x]));
                    }
                }
            }
            System.out.println(sum + " " + answer+ " " + count);
            root.clearHit();
        }
    }


    //dfs

    public static void search(int y, int x, int length, Node node) {
        // 1.체크인
        visited[y][x] = 1;
        sb.append(board[y][x]);
        // 2.목적지에 도달했는지 -> isEnd, isHit
        if (node.isEnd && node.isHit == false) {
            node.isHit = true;
            //추가 답 처리
            sum += score[length];
            count++;
            String foundWord = sb.toString();
            if (compare(answer, foundWord) > 0) {
                answer = foundWord;
            }

        }
        // 3.연결된 곳을 순회 -> 8방향
        for (int i = 0; i < 8; i++) {
            int ny = y + yp[i];
            int nx = x + xp[i];
            // 4.가능한가? -> map경계, 방문했는지, 노드가 해당 자식을 가졌는지
            if (nx >= 0 && ny >= 0 && nx < 4 && ny < 4) {
                if (visited[ny][nx] == 0 && node.hasChild(board[ny][nx])) {
                    // 5.간다
                    search(ny, nx, length + 1, node.getChild(board[ny][nx]));
                }
            }
        }
        // 6.체크아웃
        visited[y][x] = 0;
        sb.deleteCharAt(length - 1);

    }

    public static int compare(String one, String two) {
        int result = Integer.compare(two.length(), one.length()); //길이 긴 순서(내림차순)
        if (result == 0) {
            return one.compareTo(two); //알파벳 빠른순(오름차순)
        }
        return result;
    }

    public static void insertTrie(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (!cur.hasChild(word.charAt(i))) { //해당 자식을 가지고 있는지
                cur.child[word.charAt(i) - 'A'] = new Node();
            }
            cur = cur.getChild(word.charAt(i));
        }
        cur.isEnd = true;
    }


}
