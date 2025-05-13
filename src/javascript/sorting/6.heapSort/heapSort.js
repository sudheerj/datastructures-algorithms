function heapSort(arr) {
    let size = arr.length;

    for (let i = Math.floor(size/2 - 1); i >= 0; i--) {
        heapify(arr, size, i);        
    }

    for (let i = size - 1; i >= 0; i--) {
        [arr[i], arr[0]] = [arr[0], arr[i]];
        heapify(arr, i, 0);
    }
}

function heapify(arr, size, parentIndex) {
    let largest = parentIndex;
    let leftChild = 2 * parentIndex + 1;
    let rightChild = 2 * parentIndex + 2;

    if(leftChild < size && arr[leftChild] > arr[largest]) {
        largest = leftChild;
    }

    if(rightChild < size && arr[rightChild] > arr[largest]) {
        largest = rightChild;
    }

    if(parentIndex !== largest) {
        [arr[parentIndex], arr[largest]] = [arr[largest], arr[parentIndex]];
        heapify(arr, size, largest);
    }
}

let arr = [40, 50, 20, 0, -10, 30, 10];
heapSort(arr);
console.log(arr);