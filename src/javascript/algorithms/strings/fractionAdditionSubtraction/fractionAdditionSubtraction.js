// String parsing and simulation TC: O(n) SC: O(1)
function fractionAddition(expression) {
    let numerator = 0, denominator = 1;
    let i = 0;
    const n = expression.length;

    function gcd(a, b) {
        return b === 0 ? a : gcd(b, a % b);
    }

    while (i < n) {
        // Read sign
        let sign = 1;
        if (expression[i] === '+' || expression[i] === '-') {
            if (expression[i] === '-') sign = -1;
            i++;
        }

        // Read numerator digits
        let num = 0;
        while (i < n && expression[i] >= '0' && expression[i] <= '9') {
            num = num * 10 + Number(expression[i]);
            i++;
        }
        num *= sign;

        // Skip '/'
        i++;

        // Read denominator digits
        let den = 0;
        while (i < n && expression[i] >= '0' && expression[i] <= '9') {
            den = den * 10 + Number(expression[i]);
            i++;
        }

        // Add fractions
        numerator = numerator * den + num * denominator;
        denominator = denominator * den;

        // Reduce fraction
        const g = gcd(Math.abs(numerator), denominator);
        numerator = Math.trunc(numerator / g);
        denominator = Math.trunc(denominator / g);
    }

    return `${numerator}/${denominator}`;
}

function runTests() {
    const tests = [
        { expression: "-1/2+1/2",       expected: "0/1"  },
        { expression: "-1/2+1/2+1/3",  expected: "1/3"  },
        { expression: "1/3-1/2",        expected: "-1/6" },
        { expression: "5/3+1/3",        expected: "2/1"  },
        { expression: "-3/2+3/2",       expected: "0/1"  },
        { expression: "1/4+1/4",        expected: "1/2"  },
    ];

    for (const { expression, expected } of tests) {
        const result = fractionAddition(expression);
        const status = result === expected ? "PASS" : "FAIL";
        console.log(`[${status}] expression="${expression}" result=${result} expected=${expected}`);
    }
}

runTests();
