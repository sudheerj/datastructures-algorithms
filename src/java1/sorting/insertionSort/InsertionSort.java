package java1.sorting.insertionSort;

class InsertionSort {

        private int[] insertionSort(int array[]) {
            int size = array.length;

            for (int i = 1; i < size; i++) {
                int key = array[i];
                int j = i - 1;

                // Compare key with each element on the left of it until an element is smaller than it
                while (j >= 0 && key < array[j]) {
                    array[j + 1] = array[j];
                    --j;
                }

                // Place key at after the element just smaller than it.
                array[j + 1] = key;
            }
            return array;
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

        public static void main(String args[]) {
            InsertionSort obj = new InsertionSort();
            int arr[] = {40, 50, 20, 0, -10, 30, 10};
            obj.insertionSort(arr);
            obj.printArray(arr);
        }
    }
