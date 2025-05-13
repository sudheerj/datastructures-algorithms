function bubbleSort(array){
    const len = array.length;
    let i, j;
    let swapped;
    for (i=0; i < len - 1; i++) {
        swapped = false; // Track if any swaps occur in this iteration
        for (j=0; j < len-i-1; j++) {
            if (array[j] > array[j+1]){
                swap(array, j, j+1);
                swapped = true; // Mark when there is a swap
            }
        }
        
        //Early exit if there were no swaps made. That means, the array is already sorted if this condition satisfies
        if(!swapped) {
            break;
        }
    }
    return array;
}

function swap(array, firstIndex, secondIndex){
    const temp = array[firstIndex];
    array[firstIndex] = array[secondIndex];
    array[secondIndex] = temp;
}

console.log(bubbleSort([40, 50, 20, 0, -10, 30, 10]));