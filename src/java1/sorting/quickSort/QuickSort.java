package java1.sorting.quickSort;

import java.util.Arrays;

public class QuickSort {

    private static void quickSort(int[] arr)  {
        quickSortHelper(arr, 0, arr.length-1);
    }

    private static void quickSortHelper(int[] arr, int left, int right) {
        if(left < right) {
            int pivot = pivot(arr, left, right);
            quickSortHelper(arr, left, pivot-1);
            quickSortHelper(arr, pivot+1, right);
        }
    }

    private static int pivot(int[] arr, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex;
        for (int i = pivotIndex+1; i <= endIndex; i++) {
            if(arr[i] < arr[pivotIndex]){
                swapIndex++;
                swap(arr, swapIndex, i);
            }
        }
        swap(arr, swapIndex, pivotIndex);

        return swapIndex;
    }

    private static void swap(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {40, 50, 20, 0, -10, 30, 10};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
