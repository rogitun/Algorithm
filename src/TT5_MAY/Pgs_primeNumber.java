package TT5_MAY;

public class Pgs_primeNumber {
    public static void main(String[] args) {
        solution("17");
    }
    public static int solution(String numbers) {
        //1. 에라토스테네스체
        //7 이하이기 때문에 9999999 보다 작음
        //2. 각 문자열을 쪼개서 array로 만든다.
        //3. 쪼개진 array를 브루트포스로 조합하여 소수인지 검사한다.
        //4. 체킹
        net = new boolean[10000000];
        net[0]=true; net[1] = true;
        for(int i=2;i<10000000/2;i++){
            for(int j=i*2;j<10000000;j+=i){
                net[j]=true;
            }
        }
        visit = new boolean[8];
        duplicate = new boolean[10000000];
        result = 0;
        dfs(0,0,numbers.length(),numbers.toCharArray(),new StringBuilder());
        return result;
    }
    static boolean[] net;
    static int result;
    static boolean[] visit;
    static boolean[] duplicate;
    public static void dfs(int s, int num, int limit, char[] arr,StringBuilder now){
        String tmp = now.toString();
        if(!tmp.equals("") && net[Integer.parseInt(tmp)]==false && duplicate[Integer.parseInt(tmp)]==false){
            result++;
            System.out.println(tmp);
            duplicate[Integer.parseInt(tmp)]=true;
        }
        if(now.length() == limit) return;
        else{
            for(int i=0;i<limit;i++){
                if(visit[i]==false) {
                    visit[i] = true;
                    now.append(arr[i]);
                    dfs(i, num + 1, limit, arr, now);
                    visit[i] = false;
                    now.deleteCharAt(now.length() - 1);
                }
            }
        }
    }
}
