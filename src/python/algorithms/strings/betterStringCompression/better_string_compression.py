def better_compression(compressed):
    freq = {}
    order = []
    i = 0
    n = len(compressed)
    while i < n:
        ch = compressed[i]
        i += 1
        num = 0
        while i < n and compressed[i].isdigit():
            num = num * 10 + int(compressed[i])
            i += 1
        if ch not in freq:
            freq[ch] = num
            order.append(ch)
        else:
            freq[ch] += num
    return ''.join(f"{ch}{freq[ch]}" for ch in order)
