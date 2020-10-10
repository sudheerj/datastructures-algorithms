package main

import "fmt"

func selectionSort(arr []int) {
    length := len(arr)
    for i := 0; i < length-1; i++ {
        minIndex := i
        for j := i + 1; j < length; j++ {
            if arr[j] < arr[minIndex] {
                arr[j], arr[minIndex] = arr[minIndex], arr[j]
            }
        }
    }
}

func main() {
    sortArr := []int{40, 50, 20, 0, -10, 30, 10}
    selectionSort(sortArr)
    fmt.Println(sortArr)
}