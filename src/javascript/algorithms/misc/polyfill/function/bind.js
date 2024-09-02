Function.prototype.myBind = function(thisArg, ...args){
    const originalFunc = this;

    if(typeof originalFunc !== 'function') {
        return new Error('Bind must be called on a function');
    }

    return function(...innerArgs) {

        const finalArgs = args.concat(innerArgs);

        if(this instanceof originalFunc) {
            return new originalFunc(finalArgs);
        }

        return originalFunc.apply(thisArg, finalArgs);
    }
}

Function.prototype.myBind1 = function(thisArg, ...args){
    const uniqueId = Symbol();
    const wrappedObj = Object(thisArg);

    Object.defineProperty(wrappedObj, uniqueId, {
        enumerable: false,
        value: this
    });

    return function(...innerArgs){
        return wrappedObj[uniqueId](...args, ...innerArgs)
    }
}

Function.prototype.myBind2 = function(thisArg, ...args){
    const originalFunc = this;

    if(typeof originalFunc !== 'function') {
        return new Error("Bind must be called on a function");
    }

    return function(...innerArgs){
        return Reflect.apply(originalFunc, thisArg, [...args, ...innerArgs])
    }
}

// ------------------------------------------------------

function fullName(greeting) {
    console.log(`${greeting}, I'm ${this.firstName} ${this.lastName}`);
}

const person1 = {
    firstName: 'Sudheer',
    lastName: 'Jonna'
};

const person2 = {
    firstName: "John",
    lastName: "Smith"
};

const boundFullName1 = fullName.myBind(person1, "Hello");
const boundFullName2 = fullName.myBind1(person2, "Hey");
const boundFullName3 = fullName.myBind1(person2, "Hi");

boundFullName1();
boundFullName2();
boundFullName3();