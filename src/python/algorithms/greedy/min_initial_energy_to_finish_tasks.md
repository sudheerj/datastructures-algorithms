# Minimum Initial Energy to Finish Tasks

Given a list of tasks, each with actual energy cost and minimum required energy, find the minimum initial energy required to finish all tasks in any order.

## Approach
- **Greedy**: Sort tasks by (required - cost) descending, then simulate.
- Time: O(n log n) (for sorting)
- Space: O(1) (ignoring sort stack)

## Example Test Cases
| tasks                                      | Output |
|---------------------------------------------|--------|
| [[1,2],[2,4],[4,8]]                        | 8      |
| [[1,3],[2,4],[10,11],[10,12],[8,9]]        | 32     |
| [[1,7],[2,8],[3,9],[4,10]]                 | 19     |
| [[5,9],[2,8],[3,7],[1,5]]                  | 17     |
| [[1,2],[2,2],[3,3]]                        | 6      |

## Files
- Java: [MinInitialEngergyToFinishTasks.java](../../java1/algorithms/greedy/minInitialEngergyToFinishTasks/MinInitialEngergyToFinishTasks.java)
- Python: [min_initial_energy_to_finish_tasks.py](../../../../python/algorithms/greedy/min_initial_energy_to_finish_tasks.py)
- JavaScript: [minInitialEnergyToFinishTasks.js](../../../../javascript/algorithms/greedy/minInitialEnergyToFinishTasks.js)
