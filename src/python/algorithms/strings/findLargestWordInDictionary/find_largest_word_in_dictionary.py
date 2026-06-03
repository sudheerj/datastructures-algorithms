# Longest Word in Dictionary through Deleting (LC 524)
# TC: O(n * m)  SC: O(1)  n = dictionary size, m = length of s


def is_subsequence(s: str, word: str) -> bool:
    left, right = 0, 0
    while left < len(s) and right < len(word):
        if s[left] == word[right]:
            right += 1
        left += 1
    return right == len(word)


def find_largest_word_in_dictionary(s: str, dictionary: list[str]) -> str:
    largest_word = ""
    for word in dictionary:
        if is_subsequence(s, word):
            if len(word) > len(largest_word) or (
                len(word) == len(largest_word) and word < largest_word
            ):
                largest_word = word
    return largest_word


if __name__ == "__main__":
    test_cases = [
        ("abpcplea", ["ale", "apple", "monkey", "plea"], "apple"),
        ("abpcplea", ["a", "b", "c"],                    "b"),
        ("abpcplea", ["ale", "plea"],                    "plea"),
        ("aewfafwafjlwajflwajflfa", ["apple", "ewaf"],   "ewaf"),
        ("z",        ["a", "b"],                         ""),
        ("",         ["a"],                              ""),
    ]

    for s, dictionary, expected in test_cases:
        result = find_largest_word_in_dictionary(s, dictionary)
        status = "PASS" if result == expected else "FAIL"
        print(f'[{status}] s="{s}" result="{result}" expected="{expected}"')
