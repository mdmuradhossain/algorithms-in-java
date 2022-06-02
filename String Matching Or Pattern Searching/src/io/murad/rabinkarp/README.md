# Rabin-Karp Algorithm

Rabin-Karp algorithm is an algorithm used for searching/matching patterns in the text using a hash function. Unlike Naive string matching algorithm, it does not travel through every character in the initial phase rather it filters the characters that do not match and then performs the comparison.

>A hash function is a tool to map a larger input value to a smaller output value. This output value is called the hash value.

## How Rabin-Karp Algorithm Works?

A sequence of characters is taken and checked for the possibility of the presence of the required string. If the possibility is found then, character matching is performed.

Let us understand the algorithm with the following steps:

1. Let the text be:
![Text](https://cdn.programiz.com/sites/tutorial2program/files/rc-text.png)
And the string to be searched in the above text be:
![Pattern](https://cdn.programiz.com/sites/tutorial2program/files/rc-pattern.png)
2. Let us assign a numerical value(v)/weight for the characters we will be using in the problem. Here, we have taken first ten alphabets only (i.e. A to J).
![Text Weights](https://cdn.programiz.com/sites/tutorial2program/files/rc-text-wieghts.png)
3. `n` be the length of the pattern and m be the length of the text. Here, `m = 10` and `n = 3`. Let d be the number of characters in the input set. Here, we have taken input set {A, B, C, ..., J}. So, `d = 10`. You can assume any suitable value for `d`.
4. Let us calculate the hash value of the pattern.
![Hash value of text](https://cdn.programiz.com/sites/tutorial2program/files/rc-mod-pattern.png)
`hash value for pattern(p) = Σ(v * dm-1) mod 13 `
                     ` = ((3 * 102) + (4 * 101) + (4 * 100)) mod 13 `
                     ` = 344 mod 13 `
                     ` = 6`
In the calculation above, choose a prime number (here, 13) in such a way that we can perform all the calculations with single-precision arithmetic.
The reason for calculating the modulus is given below.
5. Calculate the hash value for the text-window of size m.
`For the first window ABC,`
`hash value for text(t) = Σ(v * dn-1) mod 13 `
                `  = ((1 * 102) + (2 * 101) + (3 * 100)) mod 13 `
                `  = 123 mod 13 ` 
                `  = 6`
6. Compare the hash value of the pattern with the hash value of the text. If they match then, character-matching is performed.
In the above examples, the hash value of the first window (i.e. t) matches with p so, go for character matching between ABC and CDD. Since they do not match so, go for the next window.
7. We calculate the hash value of the next window by subtracting the first term and adding the next term as shown below.
`t = ((1 * 102) + ((2 * 101) + (3 * 100)) * 10 + (3 * 100)) mod 13` 
 ` = 233 mod 13  `
 ` = 12`
In order to optimize this process, we make use of the previous hash value in the following way.
`t = ((d * (t - v[character to be removed] * h) + v[character to be added] ) mod 13  `
  `= ((10 * (6 - 1 * 9) + 3 )mod 13  `
 ` = 12`
`Where, h = dm-1 = 103-1 = 100.`
8. For BCC, t = 12 (≠6). Therefore, go for the next window.
After a few searches, we will get the match for the window CDA in the text.
![Hash value of different windows](https://cdn.programiz.com/sites/tutorial2program/files/rc-mod-txt.png)

        
## Limitations of Rabin-Karp Algorithm

### Spurious Hit
When the hash value of the pattern matches with the hash value of a window of the text but the window is not the actual pattern then it is called a spurious hit.

Spurious hit increases the time complexity of the algorithm. In order to minimize spurious hit, we use modulus. It greatly reduces the spurious hit.

## Rabin-Karp Algorithm Complexity

The average case and best case complexity of Rabin-Karp algorithm is `O(m + n)` and the worst case complexity is `O(mn)`.

The worst-case complexity occurs when spurious hits occur a number for all the windows.

## Rabin-Karp Algorithm Applications

- For pattern matching
- For searching string in a bigger text