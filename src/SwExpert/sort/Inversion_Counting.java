package SwExpert.sort;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Inversion_Counting {
    static int[] res;
    static long answer;

    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/SwExpert/sample.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            res = new int[N];
            answer = 0;
            String[] input = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            mergeSort(arr, 0, arr.length -1);
            System.out.println("#" + (t + 1) + " " + answer);
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
                answer += (mid-i)+1;
                res[k++] = arr[j++];
            }
        }

        while(i <= mid) res[k++] = arr[i++];
        while(j <= end) res[k++] = arr[j++];

        for (int l = start; l <= end; l++) {
            arr[l] = res[l];
        }
    }
}
