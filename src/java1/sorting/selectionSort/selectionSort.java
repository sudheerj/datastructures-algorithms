package java1.sorting.selectionSort;

class SelectionSort
{
    // Logic of selection sort
    private void selectionSort(int arr[]) {
        int len = arr.length;

        // Reduce an unsorted subarray
        for (int i = 0; i < len-1; i++) {
            // Find the minimum element index in an unsorted array
            int minIndex = i;
            for (int j = i+1; j < len; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the minimum element with the first element of an unsorted array
            if (minIndex != i) {
                swap(arr, minIndex, i);
            }
        }
    }

    /* Swap an array */
    private void swap(int arr[], int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }

    // Prints the sorted array
    private void printArray(int arr[])
    {
        System.out.println("Sorted array");
        for (int i=0; i<arr.length; ++i){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[])
    {
        SelectionSort obj = new SelectionSort();
        int arr[] = {40, 50, 20, 0, -10, 30, 10};
        obj.selectionSort(arr);
        obj.printArray(arr);
    }
}

