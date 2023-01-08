package Algo_2022.SwExpert.search;

public class BinarySearch {
    static boolean[] bools;

    public static void main(String[] args) {
        bools = new boolean[]{false, false, false, false, true, true, true, true, true};

        //마지막 false 찾기
        lastFalse();
        System.out.println("next");
        //첫번째 True 찾기
        firstTrue();
    }

    private static void firstTrue() {
        int l = 0;
        int r = bools.length;

        while (l != r) {
            int mid = (l + r - 1) / 2;

            if(bools[mid]) r = mid;
            else l = mid+1;
        }
        System.out.println(l);
    }


    private static void lastFalse() {
        int l = 0;
        int r = bools.length;

        while (l != r) {

            int mid = (l + (r - 1)) / 2;
            if (bools[mid]) r = mid - 1;
            else l = mid + 1;
        }
        System.out.println(l);
    }

    //0 + 9 / 2 =
}
