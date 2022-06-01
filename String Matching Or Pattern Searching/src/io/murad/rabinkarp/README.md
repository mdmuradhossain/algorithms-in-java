# Rabin-Karp Algorithm

Rabin-Karp algorithm is an algorithm used for searching/matching patterns in the text using a hash function. Unlike Naive string matching algorithm, it does not travel through every character in the initial phase rather it filters the characters that do not match and then performs the comparison.

A hash function is a tool to map a larger input value to a smaller output value. This output value is called the hash value.

How Rabin-Karp Algorithm Works?
A sequence of characters is taken and checked for the possibility of the presence of the required string. If the possibility is found then, character matching is performed.

Let us understand the algorithm with the following steps:

Let the text be:
text for rabin karp algorithm
Text

And the string to be searched in the above text be:
pattern for rabin karp algorithm
Pattern
Let us assign a numerical value(v)/weight for the characters we will be using in the problem. Here, we have taken first ten alphabets only (i.e. A to J).
text-weights
Text Weights
n be the length of the pattern and m be the length of the text. Here, m = 10 and n = 3.
Let d be the number of characters in the input set. Here, we have taken input set {A, B, C, ..., J}. So, d = 10. You can assume any suitable value for d.
Let us calculate the hash value of the pattern.
hash value of text
Hash value of text
hash value for pattern(p) = Σ(v * dm-1) mod 13 
                      = ((3 * 102) + (4 * 101) + (4 * 100)) mod 13 
                      = 344 mod 13 
                      = 6
In the calculation above, choose a prime number (here, 13) in such a way that we can perform all the calculations with single-precision arithmetic.

The reason for calculating the modulus is given below.

Calculate the hash value for the text-window of size m.
For the first window ABC,
hash value for text(t) = Σ(v * dn-1) mod 13 
                  = ((1 * 102) + (2 * 101) + (3 * 100)) mod 13 
                  = 123 mod 13  
                  = 6
Compare the hash value of the pattern with the hash value of the text. If they match then, character-matching is performed.
In the above examples, the hash value of the first window (i.e. t) matches with p so, go for character matching between ABC and CDD. Since they do not match so, go for the next window.
We calculate the hash value of the next window by subtracting the first term and adding the next term as shown below.
t = ((1 * 102) + ((2 * 101) + (3 * 100)) * 10 + (3 * 100)) mod 13 
  = 233 mod 13  
  = 12
In order to optimize this process, we make use of the previous hash value in the following way.

t = ((d * (t - v[character to be removed] * h) + v[character to be added] ) mod 13  
  = ((10 * (6 - 1 * 9) + 3 )mod 13  
  = 12
Where, h = dm-1 = 103-1 = 100.
For BCC, t = 12 (≠6). Therefore, go for the next window.
After a few searches, we will get the match for the window CDA in the text.
hash value of different windows
Hash value of different windows
Algorithm
n = t.length
m = p.length
h = dm-1 mod q
p = 0
t0 = 0
for i = 1 to m
    p = (dp + p[i]) mod q
    t0 = (dt0 + t[i]) mod q
for s = 0 to n - m
    if p = ts
        if p[1.....m] = t[s + 1..... s + m]
            print "pattern found at position" s
    If s < n-m
        ts + 1 = (d (ts - t[s + 1]h) + t[s + m + 1]) mod q
        
Limitations of Rabin-Karp Algorithm
Spurious Hit
When the hash value of the pattern matches with the hash value of a window of the text but the window is not the actual pattern then it is called a spurious hit.

Spurious hit increases the time complexity of the algorithm. In order to minimize spurious hit, we use modulus. It greatly reduces the spurious hit.

Rabin-Karp Algorithm Complexity
The average case and best case complexity of Rabin-Karp algorithm is O(m + n) and the worst case complexity is O(mn).

The worst-case complexity occurs when spurious hits occur a number for all the windows.

Rabin-Karp Algorithm Applications
For pattern matching
For searching string in a bigger text