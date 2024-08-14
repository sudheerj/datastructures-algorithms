function throttle(func, wait) {
  let shouldThrottle = false;

  return function (...args) {
    if (shouldThrottle) {
      return;
    }

    shouldThrottle = true;
    setTimeout(() => (shouldThrottle = false), wait);
    func.apply(this, args);
  };
}

let counter = 0;
function increment() {
  counter++;
  console.log(counter);
}

const throttledCounter = throttle(increment, 100);
setTimeout(() => throttledCounter(), 50);
setTimeout(() => throttledCounter(), 160);
setTimeout(() => throttledCounter(), 200);
