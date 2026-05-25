# String parsing + per-token transformation  TC: O(N + n^2) SC: O(N)
VOWELS = set("aeiouAEIOU")

def goat_latin(s):
    words = s.split(" ")
    result = []
    for i, word in enumerate(words):
        if word[0] not in VOWELS:
            word = word[1:] + word[0]
        word += "ma" + "a" * (i + 1)
        result.append(word)
    return " ".join(result)


if __name__ == "__main__":
    test_cases = [
        ("I speak Goat Latin",        "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"),
        ("The quick brown fox jumped", "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa"),
        ("Each word starts anew",      "Eachmaa ordwmaaa tartssmaaaa anewmaaaaa"),
        ("I am",                       "Imaa ammaaa"),
        ("mad",                        "admmaa"),
    ]

    for s, expected in test_cases:
        result = goat_latin(s)
        status = "PASS" if result == expected else "FAIL"
        print(f"[{status}] result={result} expected={expected}")
