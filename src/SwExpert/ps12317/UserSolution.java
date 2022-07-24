package SwExpert.ps12317;

public class UserSolution {
    int[][] tree;
    boolean[] visit;

    public void dfs_init(int N, int[][] path) {
        tree = path;
    }
    public int dfs(int N) {
        visit = new boolean[tree.length];
        int res = real_dfs(N, N);
        return res;
    }

    private int real_dfs(int n,int prior) {
        int res = -1;
        for(int i=0;i<tree.length;i++){
            if(tree[i][0] != prior || visit[i]) continue;
            if(tree[i][1] > n) return (tree[i][1]>res)?tree[i][1]:res;
            else {
                visit[i] = true;
                res = real_dfs(n,tree[i][1]);
                if(res > n) return res;
            }
        }
        return res;
    }
}