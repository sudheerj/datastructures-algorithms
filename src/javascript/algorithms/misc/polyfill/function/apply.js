Function.prototype.myApply = function(thisArg, args=[]) {
    thisArg = thisArg || globalThis;

    const uniqueId = Symbol('fn');
    thisArg[uniqueId] = this;

    const result = thisArg[uniqueId](...args);
    delete thisArg[uniqueId];

    return result;
}

Function.prototype.myApply1 = function(thisArg, args=[]) {
    const uniqueId = Symbol('fn');
    const wrappedObj = Object(thisArg);
    Object.defineProperty(wrappedObj, uniqueId, {
        enumerable: false,
        value: this
    });

    return wrappedObj[uniqueId](...args);
}

Function.prototype.myApply2 = function(thisArg, args=[]) {
    return this.call(thisArg, ...args);
}

Function.prototype.myApply3 = function(thisArg, args=[]) {
    return this.bind(thisArg, ...args)();
}

const person1 = {
    firstName: 'Sudheer',
    lastName: 'Jonna'
}

function details(age = 30) {
    return this.firstName + ' '+this.lastName + ' is ' + age + ' years old';
}

console.log(details.myApply(person1, [35]));
console.log(details.myApply1(person1, [35]));
console.log(details.myApply2(person1, [35]));
console.log(details.myApply3(person1, [35]));