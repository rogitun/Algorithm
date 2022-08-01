package SwExpert.sort;

public class MergeSort {
    static int[] res;
    static int answer = 0;

    public static void main(String[] args) {
        int[] arr = new int[]{4, 1, 3, 2, 5,0,0,0,0};
        res = new int[arr.length];
        answer = 0;
        mergeSort(arr, 0, arr.length - 1);

        for (int re : res) {
            System.out.print(re + " ");
        }


    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }

    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int i = start; //비교값 1
        int j = mid + 1; //비교값 2
        int k = start; //새로운 배열에 저장할 값의 인덱스 위치

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) { //Not Inversion
                res[k++] = arr[i++];
            } else { //inversion
                answer++;
                res[k++] = arr[j++];
            }
        }

        while (i <= mid) res[k++] = arr[i++];
        while (j <= end) res[k++] = arr[j++];

        for (int l = start; l <= end; l++) {
            arr[l] = res[l];
        }
    }
}
