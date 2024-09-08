function rangeRight(start = 0, end, step = 1) {
  let resultArr = [];

  if (!end) {
    end = start;
    start = 0;
  }

  if (end < start && step === 1) {
    step = -1;
  }

  let length = (end - start) / (step || 1);

  for (let i = 0; i < length; i++) {
    resultArr.push(start + step * i);
  }

  return resultArr;
}

//-------------------------------------------------------
console.log(rangeRight(4));
console.log(rangeRight(-4));
console.log(rangeRight(1, 5));
console.log(rangeRight(0, 20, 5));
console.log(rangeRight(0, -4, -1));
console.log(rangeRight(1, 4, 0));
console.log(rangeRight(0));
console.log(rangeRight(-1, -4, 2));
