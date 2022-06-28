package TT6_JUN;

import java.util.HashMap;

public class Pgs_WordChange {

    public static void main(String[] args) {
       // solution("dot","cog",new String[]{ "lot", "log", "dog", "cog"});
        solution("hit","cog",new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
      //  solution("hit","cog",new String[]{ "hot", "dot", "dog", "lot", "log"});
    }

    static int answer;
    static boolean[] visit;

    public static int solution(String begin, String target, String[] words) {
        answer = 51;
        visit = new boolean[words.length];
        dfs(begin,target,words,0);
        if(answer==51) return 0;
        return answer;
    }

    static void dfs(String word,String target,String[] words,int stack){
        if(word.equals(target)){
            answer = Math.min(answer,stack);
        }
        else{
            for(int i=0;i< words.length;i++){
                if(!visit[i] && check(word,words[i])){
                    visit[i]=true;
                    dfs(words[i],target,words,stack+1);
                    visit[i]=false;
                }
            }
        }
    }

    private static boolean check(String word, String target) {
        int cnt=0;
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)==target.charAt(i))
                cnt++;
        }
        return (word.length()-1==cnt)?true:false;
    }
}
