package SwExpert.hash.Sw9465;

import java.util.*;

public class UserSolution {
    static HashMap<String, Integer> wortToInt;
    static LinkedList<Integer>[] overall;

    static int idx;
    static int limit;
    static LinkedList<Integer>[] users;

    public void init(int N, int k) {
        idx = 1;
        users = new LinkedList[1001];
        limit = k;
        wortToInt = new HashMap<>();
        overall = new LinkedList[10001];

        for (int i = 0; i < 10001; i++) {
            overall[i] = new LinkedList<>();
            if (i < N) users[i] = new LinkedList<>();
        }
    }

    public void sendMail(char[] subject, int uid, int cnt, int[] rids) {

        String title = "";
        for (char c : subject) {
            if (c == '\0') break;
            title += c;
        }
        String rcv = "";
        for (int i = 0; i < cnt; i++) {
            rcv += rids[i] + " ";
        }

        boolean flag = false;
        int hashNum = idx;
        if (wortToInt.getOrDefault(title, 0) == 0) {
            wortToInt.put(title, idx++);
        } else {
            hashNum = wortToInt.get(title);
            flag = true;
        }

        for (int i = 0; i < cnt; i++) {
            int idx = rids[i];
            if (users[idx].size() >= limit) users[idx].removeFirst();
            users[idx].add(hashNum);
        }

        String[] s = title.split(" ");
        if (!flag || s.length==1) {
            //hashNum은 현재 title의 hashCode이다.
            for (String string : s) {
                int component = idx;
                if (wortToInt.getOrDefault(string, 0) == 0) {
                    wortToInt.put(string, idx++);
                } else {
                    component = wortToInt.get(string);
                }
                overall[hashNum].add(component);
            }
        }
    }

    public int getCount(int uId) {
        return users[uId].size();
    }

    public int deleteMail(int uId, char[] subject) {
        int cnt = 0;
        String title = "";
        for (char c : subject) {
            if (c == '\0') break;
            title += c;
        }

        if (wortToInt.getOrDefault(title, 0) == 0) {
            return 0;
        }

        Integer sub = wortToInt.get(title);
        LinkedList<Integer> user = users[uId];

        ArrayList<Integer> tmp = new ArrayList<>();
        for (Integer hash : user) {
            if (hash.equals(sub)) {
                tmp.add(hash);
                cnt++;
            }
        }

        for (Integer integer : tmp) {
            user.remove(integer);
        }

        return cnt;
    }

    public int searchMail(int uId, char[] text) {
        String txt = "";
        for (char c : text) {
            if (c == '\0') break;
            txt += c;
        }


        if (wortToInt.getOrDefault(txt, 0) == 0) {
            return 0;
        }

        Integer txtHash = wortToInt.get(txt);


        int result = 0;

        LinkedList<Integer> user = users[uId];
        for (Integer title : user) {
            LinkedList<Integer> overalls = overall[title];
            for (Integer comp : overalls) {
                if (comp.equals(txtHash)) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }
}
