package TT5_MAY;

public class Pgs_카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int sW = (brown/2)-1; //시작 예측 가로
        int sM = 1;  //시작 예측 세로(상하위 제외)
        while(true){
            int tempYellow = (sW-2)*sM;
            if(tempYellow==yellow){
                answer[0] = sW;
                answer[1] = sM+2;
                break;
            }
            else{
                sW--;
                sM++;
            }
        }
        return answer;
    }
}
