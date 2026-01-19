"""
Birthday Cake Candles

Count the number of tallest candles that can be blown out.

Time Complexity: O(n)
Space Complexity: O(1)
"""


def birthday_cake_candles(arr):
    """
    Count occurrences of maximum height candle.
    TC: O(n), SC: O(1)
    """
    max_height = max(arr)
    return sum(1 for candle in arr if candle == max_height)


def birthday_cake_candles_single_pass(arr):
    """
    Single pass approach.
    TC: O(n), SC: O(1)
    """
    max_height = float('-inf')
    count = 0
    
    for candle in arr:
        if candle > max_height:
            max_height = candle
            count = 1
        elif candle == max_height:
            count += 1
    
    return count


# Test cases
if __name__ == "__main__":
    test_cases = [
        [3, 2, 1, 3],  # Output: 2
        [4, 4, 1, 3],  # Output: 2
        [1, 2, 3, 4],  # Output: 1
        [5, 5, 5, 5],  # Output: 4
    ]
    
    for arr in test_cases:
        result1 = birthday_cake_candles(arr)
        result2 = birthday_cake_candles_single_pass(arr)
        print(f"Candles: {arr}")
        print(f"  Two pass: {result1}, Single pass: {result2}")
