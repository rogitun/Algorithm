package day_9th;

import java.io.*;
import java.util.StringTokenizer;

public class 외판원 {
    static int N;
    static int[][] DP;
    static int[][] W;
    static int VisitAll;
    static final int Inf = Integer.MAX_VALUE;
    static int Answer;

    public static void main(String[] args) throws NumberFormatException,  IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        VisitAll = (1 << N) - 1; // 모든 도시를 방문한 경우, 도시가 4개라면 1111(2) = 15가 기록된다, 즉  10000(2) 에서 1을 뺀 결과와 동일하다.
        W = new int[N + 1][N + 1];
        DP = new int[N + 1][VisitAll + 1];

        // 입력
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기값 셋팅
        Answer = Inf;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= VisitAll; j++) {
                DP[i][j] = Inf;
            }
        }

        DP[1][1] = 0; // 1번정점을 1번 정점만 방문한 상태로 갈수 있는 최소비용
        getDP(1, 1);

        bw.write(Answer + "\n");
        bw.flush();
        bw.close();
    }
    private static void getDP(int now, int visited) {
        // 모든 도시를 방문한 경우
        // 이제 최초 출발점으로 돌아가는 코드만 있으면 된다.
        if(visited == VisitAll) {
            if(W [now][1] == 0) {
                return; // now 에서 출발점으로 갈수 없는 경우
            }
            Answer = Math.min(Answer, DP[now][visited] + W[now][1]);
        }

        // 아직 방문할 도시가 남은 경우, 1~N 까지 모든 정점을 탐색해본다.
        for(int i = 1 ; i <= N ; i++) {
            int next = (1<<(i-1));
            int nextVisited =  visited | next;  // 다음 방문할 도시의 비트연산자
            if(nextVisited == visited) { // 다음 방문할 도시를 이미 방문한 경우는 Continue
                continue;
            }
            if(W[now][i] == 0) { // 다음 도시를 갈수있는 길이 없어도 Continue
                continue;
            }
            // 다음 도시를 계산한다.
            if(DP[i][nextVisited] > DP[now][visited] + W[now][i]) {
                DP[i][nextVisited] = DP[now][visited] + W[now][i];
                getDP(i, nextVisited);
            }
        }
    }
}
