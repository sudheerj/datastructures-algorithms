# Car Pooling (LeetCode 1094)

You are given an array trips where trips[i] = [numPassengers, from, to] and an integer capacity. Each trip consists of numPassengers passengers, picking up at from and dropping off at to. Return true if it is possible to pick up and drop off all passengers for all the given trips without exceeding the capacity, or false otherwise.

## Example

Input: trips = [[2,1,5],[3,3,7]], capacity = 4
Output: false

Input: trips = [[2,1,5],[3,3,7]], capacity = 5
Output: true

## Approaches

### 1. Difference Array (Range Update + Prefix Sum)
- Mark the number of passengers picked up and dropped off at each location, then use prefix sum to check capacity.

### 2. Sorting + Min Heap (Active Intervals)
- Sort trips by start time, use a min heap to track drop-offs, and check running passenger count.

### 3. Event Processing (Sweep Line)
- Treat all pick-ups and drop-offs as events, sort by location, and check running passenger count.

### 4. Brute Force
- For each trip, increment occupancy for each location in the range, and check capacity.

## Java Implementation
See [CarPooling.java](../../java1/algorithms/interval/carPooling/CarPooling.java)

## Python Implementation
See [carPooling.py](../../../../python/algorithms/interval/carPooling.py)

## JavaScript Implementation
See [carPooling.js](../../../../javascript/algorithms/interval/carPooling.js)

## Test Cases
| trips                                   | cap | Output |
|------------------------------------------|-----|--------|
| [[2,1,5],[3,3,7]]                        | 4   | false  |
| [[2,1,5],[3,3,7]]                        | 5   | true   |
| [[3,2,7],[3,7,9],[8,3,9]]                | 11  | true   |
| [[3,2,7],[3,7,9],[8,3,9]]                | 10  | false  |
| [[2,1,5],[3,5,7]]                        | 3   | true   |
| [[2,1,5],[3,5,7]]                        | 2   | false  |
| [[9,0,1],[3,3,7]]                        | 10  | true   |
