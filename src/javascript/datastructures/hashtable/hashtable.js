class HashTable {
    constructor(size = 7) {
        this.map = Array(size);
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

myHashTable.set("bolts", 70);
myHashTable.set("nails", 120);
myHashTable.set("paint", 40);
myHashTable.set("tile", 60);
myHashTable.set("lumber", 90);

console.log(myHashTable.get("nails"));
console.log(myHashTable.keys());
myHashTable.printHashTable();
  