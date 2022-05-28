package TT5_MAY;

import java.util.ArrayList;

public class Pgs_기능개발 {

    static class Project{
        int pgs;
        int spd;

        public Project(int p,int s){
            this.pgs = p;
            this.spd = s;
        }
    }

    public static void main(String[] args) {
        solution(new int[]{93,30,55},new int[]{1,30,5});
    }
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[speeds.length];

//         Queue<Project> q = new LinkedList<>();

//         for(int i=0;i<speeds.length;i++){
//             q.offer(new Project(progresses[i],speeds[i]));
//         }
        int idx =0;
        int resultIdx=0;
        while(idx < speeds.length){
            int cnt=0;
            while(progresses[idx]<100){
                for(int i=idx;i<progresses.length;i++){
                    progresses[i] += speeds[i];
                }
            }
            while(idx < speeds.length && progresses[idx]>=100){
                // q.poll();
                cnt++;
                idx++;
            }
            answer[resultIdx++]=cnt;
        }
        ArrayList<Integer> al = new ArrayList<>();

        return answer;
    }
}
