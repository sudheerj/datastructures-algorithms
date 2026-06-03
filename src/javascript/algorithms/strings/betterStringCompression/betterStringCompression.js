function betterCompression(compressed) {
    const freq = {};
    const order = [];
    let i = 0;
    while (i < compressed.length) {
        const ch = compressed[i++];
        let num = 0;
        while (i < compressed.length && /[0-9]/.test(compressed[i])) {
            num = num * 10 + Number(compressed[i]);
            i++;
        }
        if (!(ch in freq)) {
            freq[ch] = num;
            order.push(ch);
        } else {
            freq[ch] += num;
        }
    }
    return order.map(ch => ch + freq[ch]).join('');
}

module.exports = { betterCompression };
