# Singly Linked List

A singly linked list is a linear data structure where each element (node) contains a value and a reference (link) to the next node in the sequence.

## Operations

| Operation | Time Complexity | Description |
|-----------|-----------------|-------------|
| push      | O(1)           | Add node at end |
| pop       | O(n)           | Remove node from end |
| unshift   | O(1)           | Add node at beginning |
| shift     | O(1)           | Remove node from beginning |
| get       | O(n)           | Get node at index |
| set       | O(n)           | Update node at index |
| insert    | O(n)           | Insert node at index |
| remove    | O(n)           | Remove node at index |
| reverse   | O(n)           | Reverse the list |

## Usage

```python
from singly_linked_list import LinkedList

ll = LinkedList()
ll.push(1)
ll.push(2)
ll.push(3)
ll.print_list()  # 1 -> 2 -> 3
```
