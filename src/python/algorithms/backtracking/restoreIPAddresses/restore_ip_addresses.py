def restore_ip_addresses(s):
    res = []
    def backtrack(i, dots, curr_ip):
        if dots == 4 and i == len(s):
            res.append(curr_ip[:-1])
            return
        if dots > 4:
            return
        for j in range(i, min(i+3, len(s))):
            if i != j and s[i] == '0':
                continue
            if int(s[i:j+1]) < 256:
                backtrack(j+1, dots+1, curr_ip + s[i:j+1] + '.')
    backtrack(0, 0, '')
    return res

if __name__ == "__main__":
    test_cases = [
        "25525511135", # ["255.255.11.135", "255.255.111.35"]
        "0000",        # ["0.0.0.0"]
        "101023",      # ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
        "1111",        # ["1.1.1.1"]
        "010010"       # ["0.10.0.10","0.100.1.0"]
    ]
    for i, s in enumerate(test_cases, 1):
        print(f"Test case {i}: Input: '{s}'")
        print("Output:", restore_ip_addresses(s))
