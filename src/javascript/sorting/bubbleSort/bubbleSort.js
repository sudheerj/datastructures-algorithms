function swap(array, firstIndex, secondIndex){
    const temp = array[firstIndex];
    array[firstIndex] = array[secondIndex];
    array[secondIndex] = temp;
}

function bubbleSort(array){
    const len = array.length;
    let i, j;
    for (i=0; i < len - 1; i++) {
        for (j=0; j < len-i-1; j++) {
            if (array[j] > array[j+1]){
                swap(array, j, j+1);
            }
        }
    }
    return array;
}

console.log(bubbleSort([40, 50, 20, 0, -10, 30, 10]));