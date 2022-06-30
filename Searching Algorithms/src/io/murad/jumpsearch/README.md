# Jump Search Algorithm

Jump Search Algorithm is a relatively new algorithm for searching an element in a sorted array.

The fundamental idea behind this searching technique is to search fewer number of elements compared to linear search algorithm (which scans every element in the array to check if it matches with the element being searched or not). This can be done by skipping some fixed number of array elements or jumping ahead by fixed number of steps in every iteration.

Lets consider a sorted array A[] of size n, with indexing ranging between 0 and n-1, and element x that needs to be searched in the array A[]. For implementing this algorithm, a block of size m is also required, that can be skipped or jumped in every iteration. Thus, the algorithm works as follows:

- Iteration 1: if (`x==A[0]`), then success, else, if (`x > A[0]`), then jump to the next block.
- Iteration 2: if (`x==A[m]`), then success, else, if (`x > A[m]`), then jump to the next block.
- Iteration 3: if (`x==A[2m]`), then success, else, if (`x > A[2m]`), then jump to the next block.
At any point in time, if (`x < A[km]`), then a linear search is performed from index `A[(k-1)m]` to `A[km]`

![Figure 1: Jump Search technique](https://static.studytonight.com/data-structures/images/Jump%20Search%20technique.PNG)

## Optimal Size of `m` (Block size to be skipped)

The worst-case scenario requires:

- n/m jumps, and
- (m-1) comparisons (in case of linear search if `x < A[km]`)

Hence, the total number of comparisons will be `(n/m+(m-1)`). This expression has to be minimum, so that we get the smallest value of m (block size).

On differentiating this expression with respect to `m` and equating it with `0`, we get:

`n/-m2+1 = 0`

`n/m2 = 1`

`m = n(root)`

Hence, the optimal jump size is n(root), where n is the size of the array to be searched or the total number of elements to be searched.

## Algorithm of Jump Search

Below we have the algorithm for implementing Jump search:

Input will be:

- Sorted array A of size n
- Element to be searched, say item

Output will be:

- A valid location of item in the array A

Steps for Jump Search Algorithms:

- Step 1: Set i=0 and m = √n.

- Step 2: Compare A[i] with item. If A[i] != item and A[i] < item, then jump to the next block. Also, do the following:

i. Set i = m
ii. Increment m by √n

- Step 3: Repeat the step 2 till m < n-1

- Step 4: If `A[i] > item`, then move to the beginning of the current block and perform a linear search.

i. Set x = i
ii. Compare A[x] with item. If A[x]== item, then print x as the valid location else set x++
iii. Repeat Step 4.1 and 4.2 till x < m

- Step 5: Exit

### Pictorial Representation of Jump Search with an Example
Let us trace the above algorithm using an example:

Consider the following inputs:

A[] = {0, 1, 1, 2, 3, 5, 8, 13, 21, 55, 77, 89, 101, 201, 256, 780}
item = 77
Step 1: m = √n = 4 (Block Size)

Step 2: Compare A[0] with item. Since A[0] != item and A[0]<item, skip to the next block

Comparing a[0] operatorFigure 2: Comparing A[0] and item

Step 3: Compare A[3] with item. Since A[3] != itemand A[3]<item, skip to the next block

comparing a[3] operatorFigure 3: Comparing A[3] and item

Step 4: Compare A[6] with item. Since A[6] != itemand A[6]<item, skip to the next block

comparing a[6] operatorFigure 4: Comparing A[6] and item

Step 5: Compare A[9] with item. Since A[9] != itemand A[9]<item, skip to the next block

Comparing a[9] operatorFigure 5: Comparing A[9] and item

Step 6: Compare A[12] with item. Since A[12] != item and A[12] >item, skip to A[9] (beginning of the current block) and perform a linear search.

comapring a[12] operatorFigure 6: Comparing A[12] and item

comparing-  a[12] -2Figure 7: Comparing A[9] and item (Linear Search)

Compare A[9] with item. Since A[9] != item, scan the next element
Compare A[10] with item. Since A[10] == item, index 10 is printed as the valid location and the algorithm will terminate
comapring-a[10]Figure 8: Comparing A[10] and item (Linear Search)