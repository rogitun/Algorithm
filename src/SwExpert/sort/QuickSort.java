package SwExpert.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7, 10, 11, 16, 18};

        quickSort(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(" ===================== ");
        //binarySearch2(arr, 0, arr.length - 1, 8);

        int idx = Arrays.binarySearch(arr, 5);
        System.out.println("idx = " + idx);
    }

    private static void binarySearch(int[] arr, int left, int right, int find) {

        while (left < right) {
            int mid = (left + right);
//            if (arr[mid] == find) {
//                System.out.println("find is at = " + mid);
//                break;
//            }
            if (find < arr[mid]) { //왼쪽에있다.
                right = mid - 1;
            } else { //오른쪽에있다.
                left = mid + 1;
            }
        }
        System.out.println("left = " + right);
    }

//    private static void binarySearch2(int[] arr, int left, int right, int find) {
//        int mid = (left+right)/2;
//        if(arr[mid] == find) {
//            System.out.println(arr[mid] + " is at : " + mid);
//            return;
//        }
//
//        if(arr[mid] > find){//왼쪽에 있다.
//            binarySearch2(arr,left,mid-1,find);
//        }
//        else{
//            binarySearch2(arr,mid+1,right,find);
//        }
//    }


    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int p = left;
            int i = left + 1;
            int j = right;

            while (i <= j) {
                while (i <= right && arr[p] >= arr[i]) i++;
                while (j >= left && arr[p] < arr[j]) j--;

                if (i < j) {
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
            int tmp = arr[p];
            arr[p] = arr[j];
            arr[j] = tmp;

            quickSort(arr, left, j - 1);
            quickSort(arr, j + 1, right);
        }
    }
}
