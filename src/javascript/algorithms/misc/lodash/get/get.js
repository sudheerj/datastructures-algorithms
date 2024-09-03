function get(obj, path, defaultVal) {
    let index = 0;
    let pathArr = Array.isArray(path) ? path : path.split('.');
    const length = pathArr.length;

    while(obj != null && index < length) {
        obj = obj[String(pathArr[index])];
        index++;
    }

    return index === length ? obj : defaultVal;
}

let object1 = { 'a': { 'b': { 'c': 3 } } };
let object2 = { 'a': [{ 'b': { 'c': 3 } }] };
console.log(get(object1, 'a.b.c'));
console.log(get(object2, ['a', '0', 'b', 'c']));
console.log(get(object2, 'a.b.c', 'default'));