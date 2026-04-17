# Count and Say

## Problem
The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
- `countAndSay(1)` = `"1"`
- `countAndSay(n)` is the run-length encoding of `countAndSay(n - 1)`

## Sequence
```
n=1: "1"
n=2: "11"       (one 1)
n=3: "21"       (two 1s)
n=4: "1211"     (one 2, one 1)
n=5: "111221"   (one 1, one 2, two 1s)
n=6: "312211"   (three 1s, two 2s, one 1)
```

## Approach
1. Start with `result = "1"`
2. For each iteration from `1` to `n-1`:
   - Scan `result`, count consecutive identical characters
   - Build next string as `count + digit` for each group
3. Return the final `result`

## Complexity
- **Time:** O(n * m) — where m is the length of the string at each step
- **Space:** O(m) — for the StringBuilder
