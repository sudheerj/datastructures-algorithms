package java1.sorting.heapSort;

import java.util.Arrays;

public class HeapSort {

    private static void heapSort(int[] arr) {
        int size = arr.length;
        for(int i = (int)Math.floor(size/2 - 1); i>=0; i--) {
            heapify(arr, arr.length, i);
        }

        for (int i = size -1; i > 0 ; i--) {
            swap(arr, i, 0);
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int size, int parentIndex) {
        int largest = parentIndex;
        int leftIndex = 2 * parentIndex + 1;
        int rightIndex = 2 * parentIndex + 2;

        if(leftIndex < size && arr[leftIndex] > arr[largest]) {
            largest = leftIndex;
        }

        if(rightIndex < size && arr[rightIndex] > arr[largest]) {
            largest = rightIndex;
        }

        if(parentIndex != largest) {
            swap(arr, parentIndex, largest);
            heapify(arr, size, largest);
        }
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 40, 50, 20, 0, -10, 30, 10 };
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
