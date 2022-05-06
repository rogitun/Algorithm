package TT5_MAY;

class Pgs_카카오컬러링북 {
    static boolean[][] visit;
    public static int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        big = 0;
        visit = new boolean[m][n];
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && visit[i][j]==false) {
                    visit[i][j] = true;
                    int dfs = dfs(i, j, n, m, 1, picture, picture[i][j]);
                    result++;
                    big = Math.max(dfs, big);
                } else{
                    continue;
                }
            }
        }

        answer[0] = result;
        answer[1] = big;
        return answer;
    }

    //4방향 탐색
    static int big = 0;
    static int[] xp = {1, -1, 0, 0};
    static int[] yp = {0, 0, 1, -1};

    private static int dfs(int y, int x, int n, int m, int level, int[][] pic, int num) {
        for (int i = 0; i < 4; i++) {
            int nx = xp[i] + x;
            int ny = yp[i] + y;
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visit[ny][nx] && pic[ny][nx] == num) {
                visit[ny][nx] = true;
                level = dfs(ny, nx, n, m, level + 1, pic, num);
            }
        }
        return level;
    }
}