function insertionSort(array: number[]): number[] {
    for (let i = 1; i < array.length; i++) {
        let temp = array[i];
        let j: number;
        for (j = i - 1; j >= 0 && array[j] > temp; j--) {
            array[j + 1] = array[j];
        }
        array[j + 1] = temp;
    }
    return array;
}

let myArray: number[] = [5, 1, 6, 2, 4, 3];
insertionSort(myArray);
console.log(myArray);
