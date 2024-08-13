function sleep(duration){
    const startTime = new Date().getTime();

    while(new Date().getTime() - startTime < duration) {
        //pause
    }
}

function test() {
    console.log("start");
    sleep(3000);
    console.log("end")
}

setInterval(()=> {
    console.log("wait");
}, 500);

test();

/**
 * start
 * end
 * wait
 * wait
 * wait
 * wait
 * wait
 * wait
 * .....
 */
