function intersection(...arrays){
    let firstArrSet = new Set(arrays[0]);

    for (let i = 1; i < arrays.length; i++) {
        firstArrSet.forEach((element) => {
            if(!arrays[i].includes(element)){
                firstArrSet.delete(element);
            }
        }
        )        
    }

    return Array.from(firstArrSet);
}

console.log(intersection([1,2,3,4],[2,3,4,5],[3,4,5,6]));
console.log(intersection([1,2],[3,4,5]));