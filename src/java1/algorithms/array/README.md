# Array Algorithms

| Algorithm                        | Pattern                | Hint/Approach                                      |
|----------------------------------|------------------------|----------------------------------------------------|
| buySellStock                     | Greedy/DP              | Track min price, max profit                        |
| canPlaceFlowers                  | Greedy                 | Check adjacent plots for placement                  |
| containerWithMostWater           | Two Pointers           | Move pointers to maximize area                     |
| containsDuplicate                | Hashing                | Use a set to check duplicates                      |
| destinationCity                  | Hash Map               | Find city with no outgoing path                    |
| disappearedNumbers               | In-place Marking       | Mark visited indices, collect missing              |
| equillibriumIndex                | Prefix Sum             | Compare left/right sums at each index              |
| findFirstAndLastElement          | Binary Search          | Find left/right bounds of target                   |
| firstMissingPositive             | In-place Hashing       | Place numbers at correct indices                   |
| fourSum                          | Two Pointers/Sorting   | Sort, fix two, use two pointers for rest           |
| identicalPairs                   | Hashing/Counting       | Count occurrences, use nC2 formula                 |
| intersectionOfArrays             | Hash Set               | Use sets for intersection                          |
| majorityElement                  | Boyer-Moore            | Track candidate and count                          |
| maxLengthBetweenEqualChars       | Hash Map               | Store first/last index of each char                |
| maxProductSubarray               | DP/Greedy              | Track max/min products                             |
| maxSumCircularSubarray           | Kadane's/Greedy        | Max of normal and circular subarray                |
| maxSumSubarray                   | Kadane's Algorithm     | Track max sum ending at each index                 |
| minimumRotatedSortedarray        | Binary Search          | Find min in rotated array                          |
| minimumSizeSubarraySum           | Sliding Window         | Expand/shrink window to meet sum                   |
| moveZeros                        | Two Pointers           | Move non-zeros forward, fill rest with zeros       |
| pascalsTriangle                  | Math/DP                | Build rows using previous row                      |
| productExceptSelf                | Prefix/Suffix Product  | Multiply left/right products                       |
| redistributionIntoBoxes          | Math/Simulation        | Simulate moves or check feasibility                |
| removeDuplicatesSortedArray      | Two Pointers           | Overwrite duplicates in-place                      |
| removeElement                    | Two Pointers           | Overwrite target elements in-place                 |
| rotateArray                      | Reverse/Rotate         | Reverse parts and whole array                      |
| searchRotatedSortedArray         | Binary Search          | Modified binary search for rotation                |
| setMismatch                      | Hashing/Math           | Find duplicate and missing                         |
| sortColors                       | Dutch National Flag    | Three-way partition                                |
| specialArray                     | Sorting/Counting       | Check for special property                         |
| sumRange                         | Prefix Sum             | Precompute sums for fast queries                   |
| thirdLargestElement              | Sorting/Heap           | Track top 3 elements                               |
| threeSum                         | Two Pointers/Sorting   | Sort, fix one, use two pointers                    |
| threeSumDuplicates               | Two Pointers/Sorting   | Handle duplicates in three sum                     |
| timeToBuyTickets                 | Simulation/Queue       | Simulate ticket buying process                     |
| trappingRainWater                | Two Pointers/Stack     | Track left/right max, accumulate water             |
| twoMissingNumbers                | Math                   | Use sum and sum of squares                         |
| twoSum2                          | Two Pointers/Hash Map  | Find pairs with target sum                         |

- Each folder contains the Java implementation and may include Python/JS versions.
- Patterns and hints help identify the core approach for each problem.
