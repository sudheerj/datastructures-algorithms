**Description:**
Given a time in 12-hour AM/PM format, convert it to 24-hour (military) time.

## Examples

**Example 1:**  
Input: `"07:05:45PM"`  
Output: `"19:05:45"`

**Example 2:**  
Input: `"12:00:00AM"`  
Output: `"00:00:00"`

**Example 3:**  
Input: `"12:00:00PM"`  
Output: `"12:00:00"`

**Example 4:**  
Input: `"01:15:30AM"`  
Output: `"01:15:30"`

## Algorithm

1. Extract the period (`AM` or `PM`) from the last two characters of the string.
2. Split the remaining string by `:` to get hours, minutes, and seconds.
3. Convert the hour to an integer.
4. If the period is `AM` and the hour is `12`, set the hour to `0`.
5. If the period is `PM` and the hour is not `12`, add `12` to the hour.
6. Return the formatted 24-hour time string with zero-padded hours.

## Complexity

- **Time Complexity:** O(1), as the input format is fixed-length.
- **Space Complexity:** O(1), as only a few variables are used.