def max_envelopes(envelopes):
    envelopes.sort(key=lambda x: (x[0], -x[1]))
    import bisect
    lis = []
    for _, h in envelopes:
        idx = bisect.bisect_left(lis, h)
        if idx == len(lis):
            lis.append(h)
        else:
            lis[idx] = h
    return len(lis)

if __name__ == "__main__":
    test_envelopes = [
        [[5,4],[6,4],[6,7],[2,3]],
        [[1,1],[1,1],[1,1]],
        [[4,5],[4,6],[6,7],[2,3],[1,1]],
        [[2,100],[3,200],[4,300],[5,500],[5,400],[5,250],[6,370],[6,360],[7,380]],
        [[1,3],[3,5],[6,7],[6,8],[8,4],[9,5]]
    ]
    expected = [3, 1, 4, 5, 3]
    for i, envs in enumerate(test_envelopes):
        result = max_envelopes([list(e) for e in envs])
        status = "PASS" if result == expected[i] else "FAIL"
        print(f"Test {i+1} | Output: {result} | Expected: {expected[i]} | {status}")
