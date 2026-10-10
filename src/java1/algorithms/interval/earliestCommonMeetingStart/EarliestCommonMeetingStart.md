# Earliest Common Meeting Start

## Problem statement

Given a list of busy intervals and a meeting duration in minutes, find the earliest time of day when a meeting can fit without overlapping any busy interval. Each busy row has the form `[person, event, startTime, endTime]`; the time strings use `HH:mm`. Busy intervals are treated as half-open ranges `[startTime, endTime)`, so a meeting can start exactly when a busy interval ends. The search day is from `00:00` to `24:00`.

Return the start time as `HH:mm`, or `-1` if no slot is long enough.

## Examples

### Example 1: earliest gap

Input:

```text
busy = [["Alice", "work", "00:00", "09:00"],
        ["Bob", "work", "10:00", "11:00"]]
duration = 60
```

Output: `09:00`

### Example 2: overlapping intervals

Input:

```text
busy = [["Alice", "work", "00:00", "09:30"],
        ["Bob", "work", "09:00", "10:00"]]
duration = 30
```

Output: `10:00`

### Example 3: no available slot

Input: `busy = [["Alice", "work", "00:00", "23:30"]]`, `duration = 60`

Output: `-1`

## Algorithm: sort and merge busy intervals

1. Convert each start and end time to minutes after midnight.
2. Sort the intervals by start time.
3. Start the candidate time at `00:00`. For each interval, check whether the gap from the candidate to the interval start can fit the meeting.
4. If it fits, return the candidate. Otherwise advance the candidate to the later of its current value and the interval end, thereby combining overlapping intervals.
5. After all intervals, check whether the remaining time through midnight is sufficient. If not, return `-1`.

**Time complexity:** `O(n log n)` for sorting `n` intervals.

**Space complexity:** `O(n)` for the converted intervals.

## Java implementation

[EarliestCommonMeetingStart.java](./EarliestCommonMeetingStart.java)