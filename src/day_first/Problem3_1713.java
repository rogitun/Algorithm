package day_first;

import java.util.*;

public class Problem3_1713 {
    static int n;
    static int t;

    public static class student implements Comparable<student> {
        int idx;
        int num;
        int cnt;

        public student(int idx, int num, int cnt) {
            this.idx = idx;
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(student o) {
            if (this.cnt == o.cnt) {
                return this.idx - o.idx;
            }
            return this.cnt - o.cnt;
        }

    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        t = kb.nextInt();

        ArrayList<student> arrayList = new ArrayList<>();

        boolean flag = false;
        for (int i = 0; i < t; i++) {
            int num = kb.nextInt();
            if (arrayList.size() < n) {
                flag = false;
                for (int j = 0; j < arrayList.size(); j++) {
                    if (arrayList.get(j).num == num) {
                        arrayList.get(j).cnt++;
                        flag = true;
                        break;
                    }
                }
                if (!flag) arrayList.add(new student(i, num, 1));
            }
            else {
                Collections.sort(arrayList);
                flag = false;
                for (int j = 0; j < arrayList.size(); j++) {
                    if (arrayList.get(j).num == num) {
                        arrayList.get(j).cnt++;
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    arrayList.remove(0);
                    arrayList.add(new student(i, num, 1));
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            result.add(arrayList.get(i).num);
        }

        Collections.sort(result);
        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}
