function canPlaceFlowers(flowerbed, n){
    let count = 0;

    for (let i = 0; i < flowerbed.length; i++) {
        if(flowerbed[i] === 0 && (i === 0 || flowerbed[i-1] === 0) && (i === flowerbed.length-1 || flowerbed[i+1] === 0)) {
            flowerbed[i] = 1;
            count++;

            if(count >= n) {
                return true;
            }
            i++;
        }
        
    }

    return count >= n;
}

const flowerbed1 = [1,0,0,1], n1= 1;
const flowerbed2 = [1,0,0,0,1], n2= 1;
const flowerbed3 = [1,0,0,0,1], n3= 2;
console.log(canPlaceFlowers(flowerbed1, n1));
console.log(canPlaceFlowers(flowerbed2, n2));
console.log(canPlaceFlowers(flowerbed3, n3));