function genomicRangeQuery(s, p, q) {
    const n = s.length;
    const m = p.length;
    const result = [];

    const aPrefixSum = Array(n+1).fill(0);
    const cPrefixSum = Array(n+1).fill(0);
    const gPrefixSum = Array(n+1).fill(0);

    for (let i = 0; i < n; i++) {
        aPrefixSum[i+1] = aPrefixSum[i];
        cPrefixSum[i+1] = cPrefixSum[i];
        gPrefixSum[i+1] = gPrefixSum[i];

        if(s[i] === 'A') aPrefixSum[i+1]++;
        else if(s[i] === 'C') cPrefixSum[i+1]++;
        else if(s[i] === 'G') gPrefixSum[i+1]++;
    }

    for(let i=0; i < m; i++) {
        const start = p[i];
        const end = q[i] + 1;

        if(aPrefixSum[end] - aPrefixSum[start] > 0) result.push(1);
        else if(cPrefixSum[end] - cPrefixSum[start] > 0) result.push(2);
        else if(gPrefixSum[end] - gPrefixSum[start] > 0) result.push(3);
        else result.push(4);
    }

    return result;
}

const S = "CAGCCTA";
const P = [2, 5, 0];
const Q = [4, 5, 6];

console.log(genomicRangeQuery(S, P, Q));// Output: [2, 4, 1]

const s1 = "TTTTT";
const p1 = [0, 1, 2];
const q1 = [0, 2, 4];

console.log(genomicRangeQuery(s1, p1, q1)); // ➞ [4, 4, 4]
