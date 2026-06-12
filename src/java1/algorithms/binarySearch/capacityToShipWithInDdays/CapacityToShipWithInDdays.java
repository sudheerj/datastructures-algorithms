package java1.algorithms.binarySearch.capacityToShipWithInDdays;

public class CapacityToShipWithInDdays {
    //Using binary search on search space({max, sum}) TC: O(n * log(sum)) SC: O(1)
    private int shipWithinDays(int[] weights, int days) {
        int low =0, high = 0;

        //Use max and sum as search space 
        for(int weight: weights) {
            low = Math.max(low, weight);
            high += weight; 
        }

        //binary search
        while(low < high) {
            int mid = low + (high-low)/2;

            if(daysNeeded(weights, mid) <= days) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private int daysNeeded(int[] weights, int capacity) {
        int days = 1, load = 0;

        for(int weight: weights) {
            if(load + weight > capacity) {
                days++;
                load = 0;
            }

            load += weight;
        }

        return days;
    }
}
