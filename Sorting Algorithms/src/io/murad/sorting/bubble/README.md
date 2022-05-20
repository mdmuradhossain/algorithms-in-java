# Bubble Sort

Bubble sort is a sorting algorithm that compares two adjacent elements and swaps them until they are not in the intended order.

Just like the movement of air bubbles in the water that rise up to the surface, each element of the array move to the end in each iteration. Therefore, it is called a bubble sort.

## Working of Bubble Sort
Suppose we are trying to sort the elements in ascending order.

### 1. First Iteration (Compare and Swap)

- Starting from the first index, compare the first and the second elements.

- If the first element is greater than the second element, they are swapped.

- Now, compare the second and the third elements. Swap them if they are not in order.

- The above process goes on until the last element.

Compare two adjacent elements and swap them if the first element is greater than the next element.

![Compare two adjacent elements](https://cdn.programiz.com/cdn/farfuture/kn1zM7ZGIj60jcTe3mv8gAtbrvFHqxgqfQ7F9MdjPuA/mtime:1582112622/sites/tutorial2program/files/Bubble-sort-0.png)

### 2. Remaining Iteration

The same process goes on for the remaining iterations.

After each iteration, the largest element among the unsorted elements is placed at the end.

Continue the swapping and put the largest element among the unsorted list at the end

![Put the largest element at the end](https://cdn.programiz.com/cdn/farfuture/LzbPYkOXS-DjqwLqtIrixMZCD1XLdU-JWWedrL1YIpw/mtime:1582112622/sites/tutorial2program/files/Bubble-sort-1.png)

In each iteration, the comparison takes place up to the last unsorted element.

Swapping occurs only if the first element is greater than the next element

![Compare the adjacent elements](https://cdn.programiz.com/cdn/farfuture/-C5A9EpPrCAwR2TFQlZhG0uy5aSKmq-ewMaWyXp8_a8/mtime:1582112622/sites/tutorial2program/files/Bubble-sort-2.png)

The array is sorted when all the unsorted elements are placed at their correct positions.

![The array is sorted if all the elements are kept in the right order.](https://cdn.programiz.com/cdn/farfuture/NnXQeMGuMJnIH0qzC1C5n7r4FOynP9vu3cWEdCK5Qjk/mtime:1582112622/sites/tutorial2program/files/Bubble-sort-3.png)

### Bubble Sort Algorithm
`bubbleSort(array)`

  `for i <- 1 to indexOfLastUnsortedElement-1`
  
    `if leftElement > rightElement`
    
      `swap leftElement and rightElement`
      
`end bubbleSort`


## Complexity Analysis of Bubble Sort

In Bubble Sort, n-1 comparisons will be done in the 1st pass, n-2 in 2nd pass, n-3 in 3rd pass and so on. So the total number of comparisons will be,


`(n-1) + (n-2) + (n-3) + ..... + 3 + 2 + 1`

`Sum = n(n-1)/2`

`i.e O(n2)`

Hence the time complexity of Bubble Sort is `O(n2)`.

The main advantage of Bubble Sort is the simplicity of the algorithm.

The space complexity for Bubble Sort is O(1), because only a single additional memory space is required i.e. for temp variable.

Also, the best case time complexity will be `O(n)`, it is when the list is already sorted.

Following are the Time and Space complexity for the Bubble Sort algorithm.

- Worst Case Time Complexity `[ Big-O ]: O(n2)`
- Best Case Time Complexity `[Big-omega]: O(n)`
- Average Time Complexity `[Big-theta]: O(n2)`
- Space Complexity: `O(1)`