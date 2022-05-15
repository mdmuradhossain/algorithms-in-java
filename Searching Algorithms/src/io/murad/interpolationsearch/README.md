# Interpolation Search Algorithm
>You stored 2GB of data in your computer and you successfully executed a search in a blink of an eye. Great! You may have used binary search or linear search. What is it trillion bytes of data stored over several servers? Interpolation search is here to help you.

Interpolation Search Algorithm is a search algorithm that has been inspired by the way humans search through a telephone book for a particular name, the key value by which the book's entries are ordered. It is an improvement above binary search. In binary search, we always move to the middle element whereas interpolation search moves to a different element in order to reduce the search space further.

**Assumption:** The must condition is that the list is sorted.
The element list is assumed to be equally distributed but even if this condition is not satisfied, the algorithm works but with less efficiency.

## Algorithm
The mathematics to find the position of the element to be compared is calculated by:

`pos = lo + [ (x-list[low])*(high-low) / (list[high]-list[low]) ]`

`list[] ==> List (initial search space)`

`x     ==> Element to be searched`

`low    ==> Starting index in arr[]`

`high    ==> Ending index in arr[]`

The steps involved in this algorithm are:

Step 1: In a loop, calculate the value of pos using the above formula.
Step 2: If it is a match, return the index of the item, and exit.
Step 3: If the item is less than the element at position pos, calculate the target position of the left sub-array. Otherwise calculate the same in the right sub-array.
Step 4: Repeat until a match is found or the search space reduces to zero.

## Time Complexity

**Worst case time complexity:** `O(N)`
**Average case time complexity:** `O(log log N)`
**Best case time complexity:** `O(1)`
**Space complexity:** `O(1)`

On assuming a uniform distribution of the data on the linear scale used for interpolation, the performance can be shown to be `O(log log n)`.
Dynamic Interpolation Search is possible in `o(log log n)` time using a novel data structure.
