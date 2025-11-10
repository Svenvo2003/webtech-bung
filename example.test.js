import { oddNumbersOnly } from "./example.js";

test('filter odd numbers from array', () => {
    const input = [1, 2, 3, 4, 5, 6];
    const expected = [1, 3, 5];
    expect(oddNumbersOnly(input)).toEqual(expected);
});