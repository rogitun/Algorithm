package Algo_2022.TT5_MAY;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Pgs_오픈채팅방 {
    public static void main(String[] args) {
        String[] solution = solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"});
        for (String s : solution) {
            System.out.println(s);
        }
    }

    static class log{
        String uuid;
        String status;

        public log(String uuid, String status) {
            this.uuid = uuid;
            this.status = status;
        }
    }

    public static String[] solution(String[] record) {
        String[] answer = {};
        List<String> inputs = new ArrayList<>();
        for (String s : record) {
            inputs.add(s);
        }

        HashMap<String, String> userMap = new HashMap<>();
        List<log> al = new ArrayList<>();
        int size = 0;
        for (String input : inputs) {
            String[] user = input.split(" ");
            //enter , leave, change
            if(user[0].equals("Enter")){
                userMap.put(user[1],user[2]);
                al.add(new log(user[1],"en"));
                size++;
            }
            else if(user[0].equals("Leave")){
                al.add(new log(user[1],"le"));
                size++;
            }
            else{
                userMap.put(user[1],user[2]);
            }
        }
        answer = new String[size];
        int i =0;
        for (log log : al) {

            String name = '"' + userMap.get(log.uuid);
            switch (log.status){
                case "en" :
                    answer[i++] = name + "님이 들어왔습니다.";
                    break;
                case "le" :
                    answer[i++] = name + "님이 나갔습니다.";
                default:
                    break;
            }
        }

        return answer;
    }
}
