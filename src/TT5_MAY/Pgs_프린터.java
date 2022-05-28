package TT5_MAY;
import java.util.LinkedList;
import java.util.Queue;
class Pgs_프린터 {

    static class Document {
        int prior;
        int location;

        public Document(int p, int l) {
            prior = p;
            location = l;
        }
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Document> q = new LinkedList<>();
        int[] priorAmount = new int[10]; //1~9;
        for (int i = 0; i < priorities.length; i++) {
            priorAmount[priorities[i]]++;
            q.offer(new Document(priorities[i], i));
        }
        int cnt = 0;
        while (!q.isEmpty()) {
            Document now = q.poll();

            boolean flag = false;
            for (int i = now.prior + 1; i < 10; i++) {
                if (priorAmount[i] > 0) { //우선순위 더 높은 수 존재
                    q.offer(now);
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                cnt++;
                priorAmount[now.prior]--;
                if (now.location == location) {
                    answer = cnt;
                    break;
                }
            }
        }
        return answer;
    }
}
