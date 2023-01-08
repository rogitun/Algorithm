package Algo_2022.TT4_APR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj_2002_queue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N  = Integer.parseInt(br.readLine());
        Queue<String> queue = new LinkedList<>();
        for(int i=0;i<N;i++) queue.offer(br.readLine());

        int result=0;
        for(int i=0;i<N;i++){
            String input = br.readLine();
            if(input.equals(queue.peek())){
                queue.poll();
                result++;
            }
            else queue.remove(input);
        }
        System.out.println(N-result);
    }
}
