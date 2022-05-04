# Linear Search

Linear search is a sequential searching algorithm where we start from one end and check every element of the list until the desired element is found. It is the simplest searching algorithm.

## How Linear Search Works?
The following steps are followed to search for an element `k = 1` in the list below.

Initial array
Array to be searched for
1. Start from the first element, compare `k` with each element `x`.
![Compare with each element](https://cdn.programiz.com/sites/tutorial2program/files/linear-search-comparisons.png)
2. If `x == k`, return the index.
![Element found](https://cdn.programiz.com/sites/tutorial2program/files/linear-search-found.png)
3. Else, return `not found`.

## Linear Search Complexities

**Time Complexity:** `O(n)`

**Space Complexity:** `O(1)`