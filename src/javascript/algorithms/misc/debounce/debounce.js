function debounce(func, wait) {
    let timeoutId = null;
    return function(...args) {
        clearTimeout(timeoutId);
        timeoutId = setTimeout(() => {
            timeoutId = null;
            func.apply(this, args)
        }, wait);
    }
}

let counter = 0;
function increment() {
    counter++;
    console.log(counter);
}

const debouncedCounter = debounce(increment, 100);
setTimeout(() => debouncedCounter(), 50);
setTimeout(() => debouncedCounter(), 100);
setTimeout(() => debouncedCounter(), 200);
setTimeout(() => debouncedCounter(), 300);

