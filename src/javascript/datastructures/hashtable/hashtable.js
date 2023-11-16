class HashTable {
    constructor(size = 7) {
        this.map = new Array(size);
    }
   
    _hash(key) {
        let hash = 0;
        for (let i = 0; i < key.length; i++) {
            hash = (hash + key.charCodeAt(i) * 23) % this.map.length;
        }
        return hash;
    }

    printHashTable() {
        for (let i = 0; i < this.map.length; i++) {
            console.log(`index ${i}:`, this.map[i]);
        }
    }

    set(key,value) {
        let index = this._hash(key);
        if(!this.map[index]) this.map[index] = [];
        
        this.map[index].push([key, value]);
        return this;
    }

    get(key) {
        let index = this._hash(key);
        if(this.map[index]) {
            for(let i = 0; i < this.map[index].length; i++) {
                if(this.map[index][i][0] === key) {
                    return this.map[index][i][1];
                }
            }
        }
        return undefined;
    }
    
    keys() {
        let keys = []
            for(let i = 0; i < this.map.length; i++) {
                if(this.map[i]) {
                    for(let j = 0; j < this.map[i].length; j++) {
                        keys.push(this.map[i][j][0]);
                    }
                }
            }
        return keys;
    }

}



let myHashTable = new HashTable();

myHashTable.set("apples", 30);
myHashTable.set("banana", 10);
myHashTable.set("oranges", 75);
myHashTable.set("cherries", 35);
myHashTable.set("avocodo", 60);

console.log(myHashTable.get("oranges"));
console.log( myHashTable.keys() );
  