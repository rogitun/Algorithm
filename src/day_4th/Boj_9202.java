package day_4th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_9202 {

    public static class Node {
        char data;
        Node child[] = new Node[26];
        boolean isHit;
        boolean isEnd;

        boolean hasChild(char c) {
            if (child[c - 'A'] != null)
                return true;
            return false;
        }

        Node getChild(char c) {
            return child[c - 'A'];
        }

        public void clear() {
            isHit = false;
            for(int i=0;i<child.length;i++){
                Node tmp = child[i];
                if(tmp!=null)
                    tmp.clear();
            }

        }
    }

    static char[][] board = new char[4][4];
    static int[][] visited = new int[4][4];
    static int[] xp = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] yp = {0, 0, 1, -1, -1, 1, -1, 1};

    static String result = ""; //결과 단어
    static int count = 0; //단어의 갯수
    static int score = 0; //결과 점수
    static int[] point = {0, 0, 0, 1, 1, 2, 3, 5, 11};
    static StringBuilder sb; //문자열을 계속 추가해갈 스트링빌더
    static Node root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        root = new Node();
        for (int i = 0; i < n; i++) {
            Node start = root;
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                char tmp = input.charAt(j);
                if (!start.hasChild(tmp)) {
                    start.child[tmp - 'A'] = new Node();
                }
                start = start.child[tmp - 'A']; //자식이 있으면 그 다음으로 넘어감, 자식이 없으면 추가하고 넘어감
            }
            start.isEnd = true;
        }
        br.readLine(); //입력마다 한줄 띈다.
        int b = Integer.parseInt(br.readLine());
        for (int i = 0; i < b; i++) { //b번 만큼의 보드판의 초기화가 이루어져야한다.
            board = new char[4][4];
            visited = new int[4][4];
            result = "";
            count = 0;
            score = 0; //보드마다 점수가 다르니 다 다시 초기화해야함.
            sb = new StringBuilder();

            for (int j = 0; j < 4; j++) {
                String input = br.readLine();
                for (int k = 0; k < 4; k++) {
                    board[j][k] = input.charAt(k);
                }
            } //보드 입력 마침
            br.readLine();
            //dfs 시작해야함
            //보드판의 알파벳마다 만들수있는 단어가 다 다르기때문에 모든 좌표에 대해 탐색한다.
            for (int y = 0; y < 4; y++) {
                for (int x = 0; x < 4; x++) {
                    if (root.hasChild(board[y][x])) //알파벳이 trie에 등록 안돼있으면 할 필요가 없음
                        dfs(x, y, 1, root.getChild(board[y][x])); //len = 1은 알파벳 하나로부터 시작을 의미
                }
            }
            System.out.println(score + " " + result + " " + count);
            root.clear();
        }
    }


    private static void dfs(int x, int y, int len, Node node) {
        //체크인
        visited[y][x] = 1;
        sb.append(board[y][x]);
        
        if (node.isEnd && node.isHit == false) { //정답인 위치
            node.isHit = true;

            score += point[len];
            count++;
            String tempWord = sb.toString();
            if(compare(result,tempWord)>0){
                result = tempWord;
            }
            
        }
        
        //방향 탐색(순회)
        for (int i = 0; i < 8; i++) {
            int nx = x + xp[i];
            int ny = y + yp[i];
            if (nx >= 0 && ny >= 0 && nx < 4 && ny < 4 && 
                    visited[ny][nx] == 0 && node.hasChild(board[ny][nx])) {
                dfs(nx, ny, len+1, node.getChild(board[ny][nx])); //dfs 재귀
            }
        }
        visited[y][x] = 0; //체크아웃
        sb.deleteCharAt(len-1);
    }

    private static int compare(String result, String tempWord) {
        if(result.length()==tempWord.length()){
            return result.compareTo(tempWord); //오름차순(알파벳)
        }
        return Integer.compare(tempWord.length(),result.length());
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
