# Ternary Search Algorithm
Ternary search is a divide-and-conquer search algorithm. It is mandatory for the array (in which you will search for an element) to be sorted before we begin the search. In this search, after each iteration it neglects ⅓ part of the array and repeats the same operations on the remaining ⅔.

### Algorithm

The steps involved in this algorithm are:
(The list must be in sorted order)

Step 1: Divide the search space (initially, the list) in three parts (with two mid-points: mid1 and mid2)

Step 2: The target element is compared with the edge elements that is elements at location mid1, mid2 and the end of the search space. If element matches, go to step 3 else predict in which section the target element lies. The search space is reduced to 1/3rd. If the element is not in the list, go to step 4 or to step 1.

Step 3: Element found. Return index and exit.

Step 4: Element not found. Exit.

## Time Complexity

**Worst case time complexity:** `O(log N)`

**Average case time complexity:** `O(log N)`

**Best case time complexity:** `O(1)`

**Space complexity:** `O(1)`
