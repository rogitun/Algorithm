package SwExpert.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Sw1230 {
    static Queue<String> q;
    static List<String> list;
    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/SwExpert/sample.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=1;i<=10;i++) {
            int N = Integer.parseInt(br.readLine());
            list = new LinkedList<>(Arrays.asList(br.readLine().split(" ")));

            int M = Integer.parseInt(br.readLine());
            String[] cmds = br.readLine().split(" ");
            q = new LinkedList<>();
            for (String cmd : cmds) {
                q.offer(cmd);
            }

            while (!q.isEmpty()) {
                String cmd = q.poll();
                func(cmd);
            }

            System.out.print("#"+i + " ");
            for (int j = 0; j < 10; j++) {
                System.out.print(list.get(j) + " ");
            }
            System.out.println();
        }
    }

    private static void func(String cmd) {
        if(cmd.equals("I")){
            int x = Integer.parseInt(q.poll());
            int y = Integer.parseInt(q.poll());
            for(int i=0;i<y;i++){
                String num = q.poll();
                list.add(x+i,num);
            }
        }
        else if(cmd.equals("D")){
            int x = Integer.parseInt(q.poll());
            int y = Integer.parseInt(q.poll());
            for(int i=0;i<y;i++) list.remove(x+1);
        }
        else{
            int y = Integer.parseInt(q.poll());
            for(int i=0;i<y;i++) list.add(q.poll());
        }
    }
}
