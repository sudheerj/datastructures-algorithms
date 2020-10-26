package main

import "fmt"

func quickSort(arr []int, start, end int) {
	if start < end {
		pivot := partition(arr, start, end)
		quickSort(arr, start, pivot - 1)
		quickSort(arr, pivot + 1, end)
	}
}

func partition(arr []int, start, end int) int {
	pivot := arr[start]
	low := start
	high := end

	for start < end {
		for arr[start] <= pivot && start < high {
			start++
		}
		for arr[end] > pivot && end > low {
			end--
		}

		if start < end {
			arr[start], arr[end] = arr[end], arr[start]
		}
	}

	arr[low], arr[end] = arr[end], pivot
	return end
}

func main() {
	sortArr := []int{40, 50, 20, 0, -10, 30, 10}
	quickSort(sortArr, 0, len(sortArr) - 1)
	fmt.Println(sortArr)
}