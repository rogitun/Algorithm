package day_1st;

import java.util.*;

public class Boj_1713_Re {
    static int n,k;
    static int[] inputs;
    static Person[] people;

    public static class Person implements Comparable<Person>{
        int num; //번호
        int count; //득표수
        int timeStamp;
        boolean isIn;

        public Person(int num, int count, int timeStamp,boolean isIn) {
            this.num = num;
            this.count = count;
            this.timeStamp = timeStamp;
            this.isIn = isIn;
        }

        @Override
        public String toString() { //디버깅 용도
            return "{" +
                    "num=" + num +
                    ", count=" + count +
                    ", timeStamp=" + timeStamp +
                    '}';
        }

        @Override
        public int compareTo(Person o) {
            int comp1 = Integer.compare(count,o.count);
            if(comp1 == 0){//같다면?
                return Integer.compare(timeStamp,o.timeStamp);
            }else{
                return comp1;
            }
        }
    }

//    3
//     9
//       2 1 4 3 5 6 2 7 2
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        n = kb.nextInt();
        k = kb.nextInt();

        inputs = new int[k];

        people = new Person[101];
        List<Person> list = new ArrayList<>();

        for(int i=0;i<k;i++){
            int num = kb.nextInt();
            if(people[num]==null){
                people[num] = new Person(num,0,0,false);
            }
            //사진판에 있는 경우 - > count 증가
            if(people[num].isIn == true){
                people[num].count++;
            }else{    //사진판에 없는 경우 - > (자리가 없으면) 하나 골라서 제거 후 새 후보 추가
                if(list.size()==n){
                    Collections.sort(list);
                    Person remove = list.remove(0);
                    remove.isIn = false;
                }
                people[num].count = 1;
                people[num].isIn = true;
                people[num].timeStamp = i;
                list.add(people[num]);
            }
        }

        Collections.sort(list, Comparator.comparingInt(o -> o.num));

    }
}
