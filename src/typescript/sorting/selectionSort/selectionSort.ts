function selectionSort(arr: number[]): number[] {
    const len = arr.length;

    for (let i = 0; i < len - 1; i++) {
        let minIndex = i;
        for (let j = i + 1; j < len; j++) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }

        if (minIndex !== i) {
            swap(arr, minIndex, i);
        }
    }
    return arr;
}

// Swap helper function
function swap(array: number[], firstIndex: number, secondIndex: number): void {
    const temp = array[firstIndex];
    array[firstIndex] = array[secondIndex];
    array[secondIndex] = temp;
}

// Test the function
console.log(selectionSort([40, 50, 20, 0, -10, 30, 10]));
