
    import GlobalMap from "./singleton3.mjs";
    import GlobalMap1 from "./singleton1.mjs";
    import GlobalMap2 from "./singleton2.mjs";

    const map1 = GlobalMap.getInstance();
    map1.set('age', 28);
    const map2 = GlobalMap1.getInstance();
    map2.set('age', 30);
    const map3 = GlobalMap2.getInstance();
    map3.set('age', 40);
    console.log(map1);
    console.log(map2);
    console.log(map3);
    console.log(GlobalMap.getInstance().get('age'));

