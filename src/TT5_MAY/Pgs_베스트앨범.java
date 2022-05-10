package TT5_MAY;

import java.util.*;

public class Pgs_베스트앨범 {

    static class music implements Comparable<music> {
        int idx;
        int plays;

        public music(int idx, int plays) {
            this.idx = idx;
            this.plays = plays;
        }

        @Override
        public int compareTo(music o) {
            if(this.plays == o.plays){
                return this.idx - o.idx;
            }
            else
                return o.plays-plays;
        }
    }


    public static ArrayList<Integer> solution(String[] genres, int[] plays) {
        HashMap<String,Integer> genre_total = new HashMap<>();
        HashMap<String,Integer> genre_idx = new HashMap<>();
        PriorityQueue<music>[] songs = new PriorityQueue[10000];
        for(int i=0;i<10000;i++){
            songs[i] = new PriorityQueue<>();
        }

        for(int i=0;i< genres.length;i++){
            genre_total.put(genres[i],genre_total.getOrDefault(genres[i],0)+plays[i]);
            genre_idx.put(genres[i],genre_idx.getOrDefault(genres[i],i));
            songs[genre_idx.get(genres[i])].offer(new music(i,plays[i]));
        }

        List<Map.Entry<String,Integer>> entryList = new LinkedList<>(genre_total.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        ArrayList<Integer> answer = new ArrayList<>();
        for (Map.Entry<String, Integer> temp : entryList) {
            Integer integer = genre_idx.get(temp.getKey());
            int limit = (songs[integer].size()>1)?2:songs[integer].size();
            for(int i=0;i<limit;i++){
                music now = songs[integer].poll();
                answer.add(now.idx);
            }
        }

        return answer;
    }
}
