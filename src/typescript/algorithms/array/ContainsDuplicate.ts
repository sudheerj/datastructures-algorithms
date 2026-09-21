// containsDuplicate.ts

// ============================================================
// 1. Using Set for early exit
// Time: O(n) average
// Space: O(n)
// ============================================================
function containsDuplicate(nums: number[]): boolean {
    const seen = new Set<number>();

    for (const num of nums) {
        if (seen.has(num)) {
            return true;
        }

        seen.add(num);
    }

    return false;
}


// ============================================================
// 2. Using Object for early exit
// Time: O(n) average
// Space: O(n)
// ============================================================
function containsDuplicateUsingObject(nums: number[]): boolean {
    const seen: Record<number, boolean> = Object.create(null);

    for (const num of nums) {
        if (seen[num]) {
            return true;
        }

        seen[num] = true;
    }

    return false;
}


// ============================================================
// 3. Using Set size comparison
// Time: O(n) average
// Space: O(n)
// ============================================================
function containsDuplicateUsingSize(nums: number[]): boolean {
    return new Set(nums).size !== nums.length;
}


// ============================================================
// 4. Using sort and iteration
// Time: O(n log n)
// Space: O(1)*
// Note: Modifies the input array
// ============================================================
function containsDuplicateUsingSort(nums: number[]): boolean {
    nums.sort((a, b) => a - b);

    for (let i = 1; i < nums.length; i++) {
        if (nums[i] === nums[i - 1]) {
            return true;
        }
    }

    return false;
}


// ============================================================
// 5. Using some() + indexOf()
// Time: O(n²)
// Space: O(1)
// ============================================================
function containsDuplicateUsingSomeIndexOf(nums: number[]): boolean {
    return nums.some((num, index) => {
        return nums.indexOf(num) !== index;
    });
}


// ============================================================
// 6. Brute-force approach
// Time: O(n²)
// Space: O(1)
// ============================================================
function containsDuplicateUsingBruteforce(nums: number[]): boolean {
    for (let i = 0; i < nums.length - 1; i++) {
        for (let j = i + 1; j < nums.length; j++) {
            if (nums[i] === nums[j]) {
                return true;
            }
        }
    }

    return false;
}


// ============================================================
// TEST CASES
// ============================================================

console.log("=================================");
console.log("       HAS DUPLICATES");
console.log("=================================");

const numsWithDuplicates: number[] = [8, 6, 4, 2, 6];

console.log("Input:", numsWithDuplicates);

console.log(
    "1. Set Early Exit:",
    containsDuplicate(numsWithDuplicates)
);

console.log(
    "2. Object:",
    containsDuplicateUsingObject(numsWithDuplicates)
);

console.log(
    "3. Set Size:",
    containsDuplicateUsingSize(numsWithDuplicates)
);

console.log(
    "4. Sort:",
    containsDuplicateUsingSort([...numsWithDuplicates])
);

console.log(
    "5. Some + IndexOf:",
    containsDuplicateUsingSomeIndexOf(numsWithDuplicates)
);

console.log(
    "6. Brute Force:",
    containsDuplicateUsingBruteforce(numsWithDuplicates)
);


console.log("\n=================================");
console.log("       NO DUPLICATES");
console.log("=================================");

const numsWithoutDuplicates: number[] = [1, 3, 5, 7, 9];

console.log("Input:", numsWithoutDuplicates);

console.log(
    "1. Set Early Exit:",
    containsDuplicate(numsWithoutDuplicates)
);

console.log(
    "2. Object:",
    containsDuplicateUsingObject(numsWithoutDuplicates)
);

console.log(
    "3. Set Size:",
    containsDuplicateUsingSize(numsWithoutDuplicates)
);

console.log(
    "4. Sort:",
    containsDuplicateUsingSort([...numsWithoutDuplicates])
);

console.log(
    "5. Some + IndexOf:",
    containsDuplicateUsingSomeIndexOf(numsWithoutDuplicates)
);

console.log(
    "6. Brute Force:",
    containsDuplicateUsingBruteforce(numsWithoutDuplicates)
);

export {}