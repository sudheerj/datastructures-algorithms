async function sleep(duration) {
    return new Promise((resolve) => setTimeout(resolve, duration));
}

async function test() {
    console.log("start");
    await sleep(3000);
    console.log("end")
}

setInterval(()=> {
    console.log("wait");
}, 500);

test();

/**
 * start
 * wait
 * wait
 * wait
 * wait
 * wait
 * end
 * wait
 * .....
 */