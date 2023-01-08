package Algo_2022.SwExpert.heap.ps9416;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

class UserSolution {
    static int curTimeStamp = 0;

    static class Post implements Comparable<Post> {
        int pId;
        int like;
        int timeStamp;

        public Post(int pId, int like, int timeStamp) {
            this.pId = pId;
            this.like = like;
            this.timeStamp = timeStamp;
        }

        @Override
        public int compareTo(Post o) {
            if (curTimeStamp - this.timeStamp > 1000) {
                return o.timeStamp - this.timeStamp;
            } else {
                if (this.like == o.like) {
                    return o.timeStamp - this.timeStamp;
                }
                return o.like - this.like;
            }
        }
    }

    static ArrayList<Integer>[] userFollow = new ArrayList[1001]; //idx번 유저가 어떤 애들은 follow하는지
    static ArrayList<Integer>[] userPost = new ArrayList[1001];
    static HashMap<Integer, Post> postMap;


    public void init(int N) {
        for(int i=0;i<1001;i++){
            userFollow[i] = new ArrayList<>();
            userPost[i] = new ArrayList<>();
        }
        postMap = new HashMap<>();
    }

    public void follow(int uID1, int uID2, int timestamp) {
        userFollow[uID1].add(uID2);
    }

    public void makePost(int uID, int pID, int timestamp) {
        Post post = new Post(pID, 0, timestamp);
        postMap.put(pID, post);
        userPost[uID].add(pID);
    }

    public void like(int pID, int timestamp) {
        Post post = postMap.get(pID);
        post.like++;
    }

    public void getFeed(int uID, int timestamp, int pIDList[]) {
        curTimeStamp = timestamp;
        //timeStamp 초과 큐
        //timeStamp 이내 큐
        PriorityQueue<Post> pq = new PriorityQueue<>();
        PriorityQueue<Post> pq2 = new PriorityQueue<>();

        //uId가 구독중인 애들 전체 탐색
        ArrayList<Integer> arrayList = userFollow[uID];
        for (int uid : arrayList) {
            //내가 구독중인 사람의 게시글
            ArrayList<Integer> userPosts = userPost[uid];
            for (int post : userPosts) {
                Post p = postMap.get(post);
                //p가 게시되지 1000 아래면 pq1에 넣는다.
                if (calTime(p.timeStamp)) {
                    pq.offer(p);
                }
                //p가 게시된지 1000 이상이면 pq2에 넣는다.
                else {
                    pq2.offer(p);
                }
            }
        }

        //내 게시글
        ArrayList<Integer> arrayList1 = userPost[uID];
        for (int p : arrayList1) {
            Post post = postMap.get(p);
            //p가 게시되지 1000 아래면 pq1에 넣는다.
            if (calTime(post.timeStamp)) {
                pq.offer(post);
            }
            //p가 게시된지 1000 이상이면 pq2에 넣는다.
            else {
                pq2.offer(post);
            }
        }
        int idx = 0;

        while (!pq.isEmpty() && idx < 10) {
            Post now = pq.poll();
            pIDList[idx++] = now.pId;
        }

        if (!pq2.isEmpty() && idx < 10) {
            while (!pq2.isEmpty() && idx < 10) {
                Post poll = pq2.poll();
                pIDList[idx++] = poll.pId;
            }
        }
    }

    private boolean calTime(int timeStamp) {
        return curTimeStamp - timeStamp <= 1000;
    }
}

