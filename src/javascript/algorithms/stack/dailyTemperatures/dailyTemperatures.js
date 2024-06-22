function dailyTemperatures(temperatures) {
    let days = Array(temperatures.length).fill(0);
    let stack = [];

    for(let currDay =0; currDay < temperatures.length; currDay++) {
        while(stack.length > 0 && temperatures[stack[stack.length-1]] < temperatures[currDay]){
            let prevDay = stack.pop();
            days[prevDay] = currDay - prevDay;
        }
        stack.push(currDay);
    }
    return days;
}

let temperatures1 = [73,74,75,71,69,72,76,73];
console.log(dailyTemperatures(temperatures1));

let temperatures2 = [30,40,50,60,70];
console.log(dailyTemperatures(temperatures2));