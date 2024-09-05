function minBy(array, iteratee) {
  let maxElement, maxValue;

  array.forEach((value) => {
    let current = iteratee(value);

    if (current != null && (maxValue === undefined || current > maxValue)) {
      maxValue = current;
      maxElement = value;
    }
  });

  return maxElement;
}

console.log(minBy([{ n: 1 }, { n: 2 }], (o) => o.n));
console.log(minBy([1, 2, 3], (n) => -n));
