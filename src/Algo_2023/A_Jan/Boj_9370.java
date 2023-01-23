package Algo_2023.A_Jan;

import java.io.*;
import java.util.*;

public class Boj_9370 {

    static class Move implements Comparable<Move> {
        int vet;
        int score;

        public Move(int vet, int score) {
            this.vet = vet;
            this.score = score;
        }

        @Override
        public int compareTo(Move o) {
            return Integer.compare(this.score, o.score);
        }
    }

    static ArrayList<Move>[] moves;
    static int[] dist;
    static int n;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        System.setIn(new java.io.FileInputStream("./src/Algo_2023/A_Jan/sample.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int testcase = 0; testcase < T; testcase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken()); //교차로의 개수.
            int t = Integer.parseInt(st.nextToken());

            moves = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) moves[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());
                moves[start].add(new Move(end, score));
                moves[end].add(new Move(start, score));
            }

            ArrayList<Integer> result = new ArrayList<>();
            for (int i = 0; i < t; i++) { //도착지 후보.
                int tidx = Integer.parseInt(br.readLine());
                int sTot = dijkstra(s, tidx);

                int sght = dijkstra(s, g) + dijkstra(g, h) + dijkstra(h, tidx);
                if (sght <= sTot) {
                    //출력에 추가.
                    result.add(tidx);
                } else {
                    int shgt = dijkstra(s, h) + dijkstra(h, g) + dijkstra(g, tidx);
                    if (shgt <= sTot) {
                        //출력에 추가
                        result.add(tidx);
                    }
                }
            }
            if(!result.isEmpty()) {
                Collections.sort(result);
                result.stream().forEach(e -> {
                    try {
                        bw.write(e + " ");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
    }

    private static int dijkstra(int start, int end) {
        dist = new int[n + 1];
        Arrays.fill(dist, 50000001);
        visit = new boolean[n + 1];
        dist[start] = 0;

        PriorityQueue<Move> pq = new PriorityQueue<>();
        pq.offer(new Move(start, 0));

        while (!pq.isEmpty()) {
            Move now = pq.poll();
            if (visit[now.vet]) continue;
            else visit[now.vet] = true;
            for (Move next : moves[now.vet]) {
                if (dist[next.vet] > next.score + now.score) {
                    dist[next.vet] = next.score + now.score;
                    pq.offer(new Move(next.vet, next.score + now.score));
                }
            }
        }
        return dist[end];
    }
}
