# Optimal Account Balancing

Given a list of transactions between people, return the minimum number of transactions required to settle all debts.

## Problem
Each transaction is represented as `[from, to, amount]`. Find the minimum number of transactions to settle all accounts (net balances become zero).

## Approach
- Build net balances for each person.
- Use backtracking to try all possible settlements, minimizing the number of transactions.
- Time: O(n!), Space: O(n)

## Java Implementation
See [OptimalAccountBalancing.java](OptimalAccountBalancing.java)

## Python Implementation
See [optimal_account_balancing.py](../../../../python/algorithms/backtracking/optimal_account_balancing.py)

## JavaScript Implementation
See [optimalAccountBalancing.js](../../../../javascript/algorithms/backtracking/optimalAccountBalancing.js)

## Example Test Cases
| transactions                                 | Output |
|----------------------------------------------|--------|
| [[0,1,10],[2,0,5]]                           | 2      |
| [[0,1,10],[1,0,10]]                          | 0      |
| [[0,1,10],[1,2,5],[2,0,5]]                   | 1      |
| [[0,1,10],[1,2,5],[2,3,5],[3,0,5]]           | 2      |
| [[0,1,5],[0,2,10],[1,2,5]]                   | 2      |
| [[0,1,1],[1,2,1],[2,0,1]]                    | 1      |

## Test Output
All operations should match the expected output above.
