package java1.sorting.insertionSort;

class InsertionSort {

        private int[] insertionSort(int array[]) {

            for (int i = 1; i < array.length; i++) {
                int temp = array[i];
                int j = i - 1;

                // Compare temp with each element on the left of it until an element is smaller than it
                for (; j > -1 && array[j] > temp; j--) {
                    array[j + 1] = array[j];
                }

                // Place temp at after the element just smaller than it.
                array[j + 1] = temp;
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
