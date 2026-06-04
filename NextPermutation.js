function NextPermutation(arr) {
    let n = arr.length;
    let pivot = 0;
    for (let i = n - 2; i > 0; i++) {
        if (arr[i] < arr[i + 1]) {
            pivot = arr[i]
        }
    }
    return pivot;
}

let arr = [2, 5, 3, 4, 1]

const response = NextPermutation(arr)
console.log("RESPONSE", response)

