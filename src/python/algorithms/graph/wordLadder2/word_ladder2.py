from collections import defaultdict, deque

# BFS (shortest paths) + DFS backtracking => TC: O(N*M*26) SC: O(N*M)
def find_ladders(begin_word, end_word, word_list):
    result = []
    word_set = set(word_list)

    if end_word not in word_set:
        return result

    parents = defaultdict(list)
    visited = {begin_word}
    queue = deque([begin_word])
    found = False

    while queue and not found:
        level_visited = set()

        for _ in range(len(queue)):
            word = queue.popleft()
            arr = list(word)

            for j in range(len(arr)):
                original = arr[j]
                for c in 'abcdefghijklmnopqrstuvwxyz':
                    arr[j] = c
                    next_word = ''.join(arr)

                    if next_word not in word_set:
                        continue

                    if next_word not in visited:
                        queue.append(next_word)
                        level_visited.add(next_word)

                    parents[next_word].append(word)

                    if next_word == end_word:
                        found = True

                arr[j] = original

        visited |= level_visited

    def dfs(word, path):
        if word == begin_word:
            result.append(list(reversed(path)))
            return
        for parent in parents.get(word, []):
            path.append(parent)
            dfs(parent, path)
            path.pop()

    dfs(end_word, [end_word])
    return result


test_cases = [
    ('hit', 'cog', ['hot','dot','dog','lot','log','cog'],
     [['hit','hot','dot','dog','cog'],['hit','hot','lot','log','cog']]),
    ('hit', 'hot', ['hot'],
     [['hit','hot']]),
    ('hit', 'cog', ['hot','dot','dog','lot','log'],
     []),
    ('abc', 'xyz', ['def','ghi','xyz'],
     []),
    ('a', 'c', ['a','b','c'],
     [['a','c']]),
]

for i, (begin, end, words, expected) in enumerate(test_cases, 1):
    result = find_ladders(begin, end, words)
    print(f"Test {i}: Result={result}, Expected={expected}")
