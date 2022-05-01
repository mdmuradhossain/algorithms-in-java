# Binary Search

Binary Search is a searching algorithm for finding an element's position in a sorted array.

In this approach, the element is always searched in the middle of a portion of an array.

>Binary search can be implemented only on a sorted list of items. If the elements are not sorted already, we need to sort them first.

## Binary Search Working
Binary Search Algorithm can be implemented in two ways which are discussed below.

1. Iterative Method
2. Recursive Method
The recursive method follows the divide and conquer approach.

The general steps for both methods are discussed below.

1. The array in which searching is to be performed is:
![initial array Binary Search](https://cdn.programiz.com/sites/tutorial2program/files/binary-search-initial-array.png)
Let x = 4 be the element to be searched.
2. Set two pointers low and high at the lowest and the highest positions respectively.
![setting pointers Binary Search](https://cdn.programiz.com/sites/tutorial2program/files/binary-search-set-pointers.png)

3. Find the middle element mid of the array ie. `arr[(low + high)/2] = 6`.
![mid element Binary Search](https://cdn.programiz.com/sites/tutorial2program/files/binary-search-mid.png)
4. If `x == mid`, then return mid.Else, compare the element to be searched with `m`.
5. If `x > mid`, compare `x` with the middle element of the elements on the right side of mid. This is done by setting `low` to `low = mid + 1`.
6. Else, compare `x` with the middle element of the elements on the left side of `mid`. This is done by setting `high` to `high = mid - 1`.
![finding mid element Binary Search](https://cdn.programiz.com/sites/tutorial2program/files/binary-search-find-mid.png)
7. Repeat steps 3 to 6 until low meets high.
![mid element Binary Search](https://cdn.programiz.com/sites/tutorial2program/files/binary-search-mid-again.png)
8. `x = 4` is found.
![Found](https://cdn.programiz.com/sites/tutorial2program/files/binary-search-found.png)

### Time Complexities of the Binary Search Algorithm

Suppose T(N) is the time complexity of the binary search for a set of N elements. Then,

`T(N) = T(N/2) + O(1)` (By means of the recurrence relation) - (i)

Now, applying Masters Theorem for computing run time complexity of recurrence relations i.e.

`T(N) = aT(N/b) + f(N) - (ii)`

Comparing equation (ii) with (i), we get,

a = 1, b = 2

Hence, log (a base b) = 1 = c - (iii)

`Now, f(N) = n^c log^k(n) //k = 0 - (iv)`

Using (iii) and (iv) in equation (ii), we get,

`T(N) = O(N^c log^(k+1)N) = O(log(N)) - (v)`

This is the worst-case time complexity for binary search. Now, the best case in which the only comparison is made. Therefore, N = 1. So, we get,

`O(log(1)) = O(1) (as log(1) = 1)`

Therefore, time complexities for Binary Search in different cases are:

**Best Case**  

`O(1)`

**Worst Case**

`O(log n)`