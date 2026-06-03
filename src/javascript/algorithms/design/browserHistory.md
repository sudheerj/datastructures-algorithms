# BrowserHistory

Design a browser history system that supports visiting new URLs, and moving back and forward in history.

## Approaches
- **Doubly Linked List**: Each node is a page, supports O(1) visit, O(k) back/forward.
- **Two Stacks**: One for back, one for forward, supports O(1) visit, O(k) back/forward.

## Example Test Sequence
| Operation                | Output         |
|--------------------------|---------------|
| BrowserHistory("leetcode.com") |               |
| visitPage("google.com")        |               |
| visitPage("facebook.com")      |               |
| visitPage("youtube.com")       |               |
| back(1)                        | facebook.com  |
| back(1)                        | google.com    |
| forward(1)                     | facebook.com  |
| visitPage("linkedin.com")      |               |
| forward(2)                     | linkedin.com  |
| back(2)                        | google.com    |
| back(7)                        | leetcode.com  |

## Test Output
All operations should match the expected output above.

## Files
- Java: [BrowserHistory.java](../../java1/algorithms/design/browserHistory/BrowserHistory.java)
- Python: [browserHistory.py](../../../../python/algorithms/design/browserHistory.py)
- JavaScript: [browserHistory.js](../../../../javascript/algorithms/design/browserHistory.js)
