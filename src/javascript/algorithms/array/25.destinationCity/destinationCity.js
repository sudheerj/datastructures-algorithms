function destinationCity(paths){
    let fromCities = new Set();

    for(const [from, to] of paths) {
        fromCities.add(from);
    }

    for(const [from, to] of paths) {
        if(!fromCities.has(to)) {
            return to;
        }
    }
}

const paths1 = [["Hyderabad","KL"],["KL","Singapore"],["Singapore","Sydney"]];
const paths2 = [["New Jersey","Austin"],["New York","New Jersey"],["Austin","Dallas"]];
const paths3 = [["Dallas", "London"]];

console.log(destinationCity(paths1));
console.log(destinationCity(paths2));
console.log(destinationCity(paths3));