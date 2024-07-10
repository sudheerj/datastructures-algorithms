package java1.sorting.mergeSort;

import java.util.Arrays;

public class MergeSort {
    private static int[] mergeSort(int[] arr) {
        int len = arr.length;
        if(len < 2) {
            return arr;
        }

        int mid = len/2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[len-mid];

        for (int i = 0; i < mid; i++) {
            leftArr[i] = arr[i];
        }

        for (int i = mid; i < len; i++) {
            rightArr[i-mid] = arr[i];
        }

        mergeSort(leftArr);
        mergeSort(rightArr);

        merge(arr, leftArr, rightArr, 0, mid);

        return arr;
    }

    private static void merge(int[] arr, int[] leftArr, int[] rightArr, int left, int right) {
        int i = 0, j = 0, k = 0;

        while(i < leftArr.length && j < rightArr.length) {
            if(leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while(i < leftArr.length) {
            arr[k++] = leftArr[i++];
        }

        while(j < rightArr.length) {
            arr[k++] = rightArr[j++];
        }
    }
    public static void main(String[] args) {
        int[] originalArray = new int[]{2, 1, 4, 3, 6, 5};
        System.out.println(Arrays.toString(mergeSort(originalArray)));
    }
}
