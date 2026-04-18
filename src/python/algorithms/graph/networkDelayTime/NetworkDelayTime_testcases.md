# Network Delay Time - Test Cases

This file contains test cases for the Network Delay Time algorithm in Python.

## Test Cases

```
# Test Case 1
assert network_delay_time([[2,1,1],[2,3,1],[3,4,1]], 4, 2) == 2
# Test Case 2
assert network_delay_time([[1,2,1]], 2, 1) == 1
# Test Case 3
assert network_delay_time([[1,2,1]], 2, 2) == -1
# Test Case 4
assert network_delay_time([[1,2,1],[2,3,2]], 4, 1) == -1
```

To run, place these assertions in your `network_delay_time.py` file or a separate test script.