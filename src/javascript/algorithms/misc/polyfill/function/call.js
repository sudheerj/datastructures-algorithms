Function.prototype.myCall = function(thisArg, ...args) {
    thisArg = thisArg || globalThis;

    const uniqueId = Symbol('fn');
    thisArg[uniqueId] = this;

    const result = thisArg[uniqueId](...args);
    delete thisArg[uniqueId];

    return result;
}

Function.prototype.myCall1 = function(thisArg, ...args) {
    const uniqueId = Symbol('fn');
    const wrappedObj = Object(thisArg);
    Object.defineProperty(wrappedObj, uniqueId, {
        enumerable: false,
        value: this
    });

    return wrappedObj[uniqueId](...args);
}

Function.prototype.myCall2 = function(thisArg, ...args) {
    return this.apply(thisArg, [...args]);
}

Function.prototype.myCall3 = function(thisArg, ...args) {
    return this.bind(thisArg, ...args)();
}

const person1 = {
    firstName: 'Sudheer',
    lastName: 'Jonna'
}

function details(age = 30) {
    return this.firstName + ' '+this.lastName + ' is ' + age + ' years old';
}

console.log(details.myCall(person1, 35));
console.log(details.myCall1(person1, 35));
console.log(details.myCall2(person1, 35));
console.log(details.myCall3(person1, 35));