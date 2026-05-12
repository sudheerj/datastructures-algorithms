"""
Word Ladder (LeetCode 127)

Return the number of words in the shortest transformation sequence
from beginWord to endWord, or 0 if no such sequence exists.

Approach: BFS level-by-level
TC: O(n * m * 26)  SC: O(n)
"""

from collections import deque


def word_ladder(begin_word: str, end_word: str, word_list: list[str]) -> int:
    word_set = set(word_list)

    if end_word not in word_set:
        return 0

    queue = deque([begin_word])
    steps = 1

    while queue:
        for _ in range(len(queue)):
            word = queue.popleft()

            if word == end_word:
                return steps

            for i in range(len(word)):
                for c in 'abcdefghijklmnopqrstuvwxyz':
                    next_word = word[:i] + c + word[i+1:]
                    if next_word in word_set:
                        queue.append(next_word)
                        word_set.remove(next_word)

        steps += 1

    return 0


if __name__ == "__main__":
    test_cases = [
        ("hit", "cog", ["hot","dot","dog","lot","log","cog"], 5, "hit→hot→dot→dog→cog"),
        ("hit", "cog", ["hot","dot","dog","lot","log"],       0, "no path (cog not in list)"),
        ("hot", "hot", ["hot"],                               1, "begin == end"),
        ("ab",  "cb",  ["cb"],                                2, "one step away"),
        ("hit", "xyz", ["hot","dot","dog"],                   0, "endWord not in list"),
    ]

    for begin, end, words, expected, label in test_cases:
        result = word_ladder(begin, end, words)
        status = "PASS" if result == expected else "FAIL"
        print(f"  [{status}] {label}: {result} (expected {expected})")
