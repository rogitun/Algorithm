package Algo_2022.TT5_MAY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_13168 {
    static int N, M, K;

    static final int INF = 99999999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        N = Integer.parseInt(st.nextToken());
        int card = Integer.parseInt(st.nextToken());

        float[][] route= new float[N+1][N+1];
        float[][] routeCard = new float[N+1][N+1];

        //전체 도시
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            map.put(st.nextToken(), i);
            Arrays.fill(route[i],INF);
            Arrays.fill(routeCard[i],INF);
        }

        //방문 도시
        M = Integer.parseInt(br.readLine());
        String[] cities = br.readLine().split(" ");

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            String type = typeConvert(st.nextToken());
            int sIdx = map.get(st.nextToken());
            int eIdx = map.get(st.nextToken());
            float v = Integer.parseInt(st.nextToken());

            route[sIdx][eIdx] = Math.min(route[sIdx][eIdx],v);
            route[eIdx][sIdx] = route[sIdx][eIdx];

            switch (type){
                case "free":
                    v=0;
                    break;
                case "half":
                    v/=2;
                    break;
                default:break;
            }
            routeCard[sIdx][eIdx]=Math.min(routeCard[sIdx][eIdx], v);
            routeCard[eIdx][sIdx] = routeCard[sIdx][eIdx];
        }

        floyd(route,routeCard);
        int noCard=0;
        float yesCard= 0;
        for(int i=0;i< cities.length-1;i++){
            int s = map.get(cities[i]);
            int e = map.get(cities[i+1]);
            noCard += route[s][e];
            yesCard+= routeCard[s][e];
        }
        System.out.println((noCard <= (yesCard+card))?"No":"Yes");
    }

    private static void floyd(float[][] city,float[][] card) {
        for(int k=1;k<=N;k++){
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    city[i][j] = Math.min(city[i][j],
                            city[i][k]+city[k][j]);
                    card[i][j] = Math.min(card[i][j],
                            card[i][k]+card[k][j]);
                }
            }
        }
    }

    private static String typeConvert(String input) {
        if(input.equals("Mugunghwa") || input.startsWith("ITX")) return "free";
        else if(input.equals("S-Train") || input.equals("V-Train")) return "half";
        return "all";
    }
}
