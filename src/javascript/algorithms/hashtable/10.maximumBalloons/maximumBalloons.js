function maxNumBalloons(text){
    let balloonObj = {'b': 1, 'a': 1, 'l':2, 'o':2, 'n': 1};
    let countTextObj = {};

    for (const ch of text) {
        if(balloonObj[ch]) {
            countTextObj[ch] = (countTextObj[ch] || 0) +1;
        }
    }

    let minBalloons = Number.POSITIVE_INFINITY;

    for (const ch in balloonObj) {
        if(!countTextObj[ch]) {
            return 0;
        }
        minBalloons = Math.min(minBalloons, Math.floor(countTextObj[ch]/balloonObj[ch]));
    }

    return minBalloons;
}

const text1 = "lenobxlao";
console.log(maxNumBalloons(text1));
const text2 = "lollbcolatnaboon";
console.log(maxNumBalloons(text2));