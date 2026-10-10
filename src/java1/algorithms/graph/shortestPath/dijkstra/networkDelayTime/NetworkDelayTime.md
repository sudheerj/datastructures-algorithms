# Network Delay Time

This directory contains the Network Delay Time algorithm and test cases in Java, Python, and JavaScript.

## Problem Statement
Given a network of `n` nodes, times[i] = (u, v, w) represents a directed edge from node u to v with travel time w. Find the minimum time it takes for all nodes to receive a signal sent from node k. If not all nodes can be reached, return -1.

## Test Cases

| Test Case | times                | n | k | Expected Output | Description                |
|-----------|----------------------|---|---|----------------|----------------------------|
| 1         | [[2,1,1],[2,3,1],[3,4,1]] | 4 | 2 | 2              | All nodes reachable        |
| 2         | [[1,2,1]]            | 2 | 1 | 1              | Simple two-node network    |
| 3         | [[1,2,1]]            | 2 | 2 | -1             | Start node can't reach all |
| 4         | [[1,2,1],[2,3,2]]    | 4 | 1 | -1             | Disconnected graph         |

## How to Run
- Java: Run the main method in `NetworkDelayTime.java`.
- Python: Run `network_delay_time.py`.
- JavaScript: Run `networkDelayTime.js`.
