function bubbleSort(array: number[]): number[] {
    const len: number = array.length;
    let i: number, j: number;
    let swapped: boolean;

    for (i = 0; i < len - 1; i++) {
        swapped = false; // Track if any swaps occur in this iteration
        for (j = 0; j < len - i - 1; j++) {
            if (array[j] > array[j + 1]) {
                swapTS(array, j, j + 1);
                swapped = true; // Mark when there is a swap
            }
        }

        // Early exit if no swaps occurred
        if (!swapped) {
            break;
        }
    }

    return array;
}

function swapTS(array: number[], firstIndex: number, secondIndex: number): void {
    const temp: number = array[firstIndex];
    array[firstIndex] = array[secondIndex];
    array[secondIndex] = temp;
}

console.log(bubbleSort([40, 50, 20, 0, -10, 30, 10]));
