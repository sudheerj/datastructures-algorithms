package main

import "fmt"

func insertionSort(arr []int) {
    length := len(arr)
    for i := 1; i < length; i++ {
        temp := arr[i]
        j := i - 1
        for j >=0 && arr[j] > temp {
           arr[j+1] = arr[j]
           j = j - 1
        }
        arr[j+1] = temp
    }
}

func main() {
    sortArr := []int{40, 50, 20, 0, -10, 30, 10}
    insertionSort(sortArr)
    fmt.Println(sortArr)
}