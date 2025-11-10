function oddNumbersOnly(arr) {
    return arr.filter(n => n % 2);
}

// Named Export statt Default Export
export { oddNumbersOnly };