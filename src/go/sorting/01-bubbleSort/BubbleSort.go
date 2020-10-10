package main

import "fmt"

func bubbleSort(arr []int) {
    length := len(arr)
    for i := 0; i < length-1; i++ {
        swapped := false
        for j := 0; j < length-i-1; j++ {
            if arr[j] > arr[j+1] {
                arr[j], arr[j+1] = arr[j+1], arr[j]
                swapped = true
            }
        }
        if !swapped {
            break
        }
    }
}

func main() {
    sortArr := []int{40, 50, 20, 0, -10, 30, 10}
    bubbleSort(sortArr)
    fmt.Println(sortArr)
}