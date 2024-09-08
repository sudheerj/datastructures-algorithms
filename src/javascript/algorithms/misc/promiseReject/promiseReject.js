function promiseReject(reason){
    return new Promise((_, reject) => reject(reason));
}

//----------------------------

try{
  promiseReject('failed')
} catch(err) {
  console.log(err);
}