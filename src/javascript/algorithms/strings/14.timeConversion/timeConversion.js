function timeConversion(str) {
    const period = str.slice(-2);
    let [hh, mm, ss] = str.slice(0, -2).split(':');

    hh = parseInt(hh);
    if (period === 'AM') {
        if (hh === 12) hh = 0;
    } else {
        if (hh !== 12) hh += 12;
    }

    hh = hh.toString().padStart(2, '0');
    return `${hh}:${mm}:${ss}`;
}

// Test cases
console.log(timeConversion("07:05:45PM")); // Output: "19:05:45"
console.log(timeConversion("12:00:00AM")); // Output: "00:00:00"
console.log(timeConversion("12:00:00PM")); // Output: "12:00:00"
console.log(timeConversion("01:15:30AM")); // Output: "01:15:30"