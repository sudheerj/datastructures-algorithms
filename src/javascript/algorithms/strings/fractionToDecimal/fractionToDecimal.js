// Long division with HashMap  TC: O(d) SC: O(d)
function fractionToDecimal(numerator, denominator) {
    if (numerator === 0) return "0";

    let result = "";

    if ((numerator < 0) ^ (denominator < 0)) {
        result += "-";
    }

    const num = BigInt(Math.abs(numerator));
    const den = BigInt(Math.abs(denominator));

    result += String(num / den);
    let remainder = num % den;

    if (remainder === 0n) return result;

    result += ".";

    const seen = new Map();

    while (remainder > 0n) {
        if (seen.has(remainder)) {
            const index = seen.get(remainder);
            result = result.slice(0, index) + "(" + result.slice(index) + ")";
            break;
        }

        seen.set(remainder, result.length);
        remainder *= 10n;
        result += String(remainder / den);
        remainder %= den;
    }

    return result;
}

function runTests() {
    const tests = [
        { numerator: 1,  denominator: 2,   expected: "0.5" },
        { numerator: 2,  denominator: 1,   expected: "2" },
        { numerator: 4,  denominator: 333, expected: "0.(012)" },
        { numerator: 1,  denominator: 3,   expected: "0.(3)" },
        { numerator: -1, denominator: -2,  expected: "0.5" },
    ];

    tests.forEach(({ numerator, denominator, expected }) => {
        const result = fractionToDecimal(numerator, denominator);
        const status = result === expected ? "PASS" : "FAIL";
        console.log(`[${status}] result=${result} expected=${expected}`);
    });
}

runTests();
