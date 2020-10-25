package main

import (
    "fmt"
)

func mergeSort(arr []int) []int {
    length := len(arr)
    if length <=1 {
        return arr
    }

   middleIndex := length / 2
   // Sort first and second halves
   leftArr := mergeSort(arr[:middleIndex])
   rightArr := mergeSort(arr[middleIndex:])

   return merge(leftArr, rightArr)
}

func merge(leftArr, rightArr []int) []int {

    result := make([]int, len(leftArr)+len(rightArr))
    i := 0
    j := 0
    k :=0

    for i < len(leftArr) && j < len(rightArr) {
        if leftArr[i] <= rightArr[j] {
            result[k] = leftArr[i]
            i++
        } else {
            result[k] = rightArr[j]
            j++
        }
        k++

    }

    for i < len(leftArr) {
        result[k] = leftArr[i]
        i++
        k++
    }
    for j < len(rightArr) {
        result[k] = rightArr[j]
        j++
        k++
    }

    return result
}

func main() {
    sortArr := []int{40, 50, 20, 0, -10, 30, 10}
    fmt.Println(mergeSort(sortArr))
}
