const equilibriumIndex = require('./equilibriumIndex');

test('equilibrium index found', () => {
    expect(equilibriumIndex([1, 3, 5, 2, 2])).toBe(2);
});

test('no equilibrium index', () => {
    expect(equilibriumIndex([1, 2, 3])).toBe(-1);
});

test('single element', () => {
    expect(equilibriumIndex([10])).toBe(0);
});

test('empty array', () => {
    expect(equilibriumIndex([])).toBe(-1);
});
