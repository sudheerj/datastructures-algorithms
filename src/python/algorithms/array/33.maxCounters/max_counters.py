"""
Max Counters

You are given N counters, all initialized to 0.
Operations can be:
- increase(X) - counter X is increased by 1
- max counter - all counters are set to the maximum value of any counter

Time Complexity: O(m + n) where m is operations length, n is counters
Space Complexity: O(n)
"""


def max_counters(n, operations):
    """
    Lazy update approach for efficient max counter operation.
    TC: O(m + n), SC: O(n)
    """
    counters = [0] * n
    max_val = 0
    last_update = 0
    
    for counter_number in operations:
        if 1 <= counter_number <= n:
            # Apply lazy update if needed
            if counters[counter_number - 1] < last_update:
                counters[counter_number - 1] = last_update
            
            # Increment counter by one
            counters[counter_number - 1] += 1
            
            # Update maximum value so far
            if counters[counter_number - 1] > max_val:
                max_val = counters[counter_number - 1]
        
        elif counter_number == n + 1:
            # Defer the update
            last_update = max_val
    
    # Final update: make all counters up to date
    for i in range(len(counters)):
        if counters[i] < last_update:
            counters[i] = last_update
    
    return counters


# Test cases
if __name__ == "__main__":
    # Example 1: Mixed operations
    n1 = 4
    operations1 = [1, 4, 4, 5, 2, 4, 4]
    print(f"Max counters({n1}, {operations1}): {max_counters(n1, operations1)}")  # [2, 3, 2, 4]
    
    # Example 2: No max operation
    n2 = 3
    operations2 = [1, 2, 1, 3]
    print(f"Max counters({n2}, {operations2}): {max_counters(n2, operations2)}")  # [2, 1, 1]
    
    # Example 3: All max operations
    n3 = 3
    operations3 = [4, 4, 4]
    print(f"Max counters({n3}, {operations3}): {max_counters(n3, operations3)}")  # [0, 0, 0]
