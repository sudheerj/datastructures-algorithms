
public class BubbleSort {
    /* Swap an array */
    private void swap(int arr[], int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }

    // Logic of bubble sort
    private void bubbleSort(int arr[]) {
        int len = arr.length;
        for (int i = len - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    // Prints the sorted array
    private void printArray(int arr[]) {
        System.out.println("Sorted array");
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        BubbleSort obj = new BubbleSort();
        int arr[] = { 40, 50, 20, 0, -10, 30, 10 };
        obj.bubbleSort(arr);
        obj.printArray(arr);
    }
}