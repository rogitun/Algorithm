package Algo_2022.TT6_JUN;

import java.lang.reflect.Array;
import java.util.*;

public class Pgs_TravelRoute {

    public static void main(String[] args) {
        solution(new String[][]{
                {"ICN", "A"}, {"ICN", "B"}, {"B", "ICN"}
        });
//        System.out.println();
//        solution(new String[][]{
//                {"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}
//        });
//        System.out.println();
//        solution(new String[][]{
//                {"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}
//        });
    }

    static boolean []visit;
    static ArrayList<String> result = new ArrayList<>();
    public static String[] solution(String[][] tickets) {
        String[] answer;
        visit = new boolean[tickets.length];

        dfs("ICN", "ICN", tickets, 0);

        Collections.sort(result);
        String s = result.get(0);
        answer = s.split(" ");
        return answer;
    }

    private static void dfs(String start, String dest, String[][] tickets, int stack) {
        if (stack == tickets.length) {
            result.add(dest);
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (!visit[i] && start.equals(tickets[i][0])) {
                visit[i] = true;
                dfs(tickets[i][1], dest + " " + tickets[i][1], tickets, stack + 1);
                visit[i] = false;
            }
        }
    }
}
