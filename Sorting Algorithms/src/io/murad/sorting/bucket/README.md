# Bucket Sort Algorithm

Bucket Sort is a sorting algorithm that divides the unsorted array elements into several groups called buckets. Each bucket is then sorted by using any of the suitable sorting algorithms or recursively applying the same bucket algorithm.

Finally, the sorted buckets are combined to form a final sorted array.

### Scatter Gather Approach

The process of bucket sort can be understood as a scatter-gather approach. Here, elements are first scattered into buckets then the elements in each bucket are sorted. Finally, the elements are gathered in order.

![Working of Bucket Sort](https://cdn.programiz.com/cdn/farfuture/gNSELV0jV05rlFjkjScrcZWCFeRsJqJUczwEOcne9D0/mtime:1582112622/sites/tutorial2program/files/Bucket_2.png)

## Working of Bucket Sort

1. Suppose, the input array is:
![Input array](https://cdn.programiz.com/cdn/farfuture/nZnEPMDyED_o3k9I9B_kA62pnHztKRSQy2CjCqLRI0I/mtime:1582112622/sites/tutorial2program/files/Bucket-sort-0.1_0.png)
Create an array of size 10. Each slot of this array is used as a bucket for storing elements.
![Array in which each position is a bucket](https://cdn.programiz.com/cdn/farfuture/Vfhp1cQfAtSDdhNoGxyahhZ1usg1tFN-048etgx7w7k/mtime:1582112622/sites/tutorial2program/files/Bucket-sort-0_0.png)

2. Insert elements into the buckets from the array. The elements are inserted according to the range of the bucket.
In our example code, we have buckets each of ranges from 0 to 1, 1 to 2, 2 to 3,...... (n-1) to n.
Suppose, an input element is .23 is taken. It is multiplied by size = 10 (ie. .23*10=2.3). Then, it is converted into an integer (ie. 2.3≈2). Finally, .23 is inserted into bucket-2.
![Insert elements into the buckets from the array](https://cdn.programiz.com/cdn/farfuture/hREOdaen0Rf3tOH3peobau0_r1NK0tB8B3OsChICkc0/mtime:1582112622/sites/tutorial2program/files/Bucket-sort-0.2_0.png)
Similarly, .25 is also inserted into the same bucket. Everytime, the floor value of the floating point number is taken.
**If we take integer numbers as input, we have to divide it by the interval (10 here) to get the floor value.**
Similarly, other elements are inserted into their respective buckets.
![Insert all the elements into the buckets from the array](https://cdn.programiz.com/cdn/farfuture/zNeS_ImQpS0e-lHiTIZC5tLlOuX4M58TwCaZV8tveOE/mtime:1582112622/sites/tutorial2program/files/Bucket-sort-0.3_0.png)

3. The elements of each bucket are sorted using any of the stable sorting algorithms. Here, we have used quicksort (inbuilt function).
![Sort the elements in each bucket](https://cdn.programiz.com/cdn/farfuture/mOL3yaTcJAp3WbD0kTJq7rWgnLl6nMrR762voPIsyN8/mtime:1582112622/sites/tutorial2program/files/Bucket-sort-0.4_0.png)

4. The elements from each bucket are gathered.

It is done by iterating through the bucket and inserting an individual element into the original array in each cycle. The element from the bucket is erased once it is copied into the original array.
![Gather elements from each bucket](https://cdn.programiz.com/cdn/farfuture/VobtThxrLKyQDQa8o5gUKmCAHBAJzBIjZ3wEuEyL8Fc/mtime:1582112622/sites/tutorial2program/files/Bucket-sort-0.5_0.png)

### Bucket Sort Algorithm
`bucketSort()`

  `create N buckets each of which can hold a range of values`
  
  `for all the buckets`
  
    `initialize each bucket with 0 values`
    
  `for all the buckets`
  
    `put elements into buckets matching the range`
    
 ` for all the buckets `
 
    `sort elements in each bucket`
    
  `gather elements from each bucket`
  
`end bucketSort`

## Bucket Sort Complexity

- **Best:** `O(n+k)`
- **Worst:**	`O(n2)`
- **Average**:	`O(n)`
- **Space Complexity:** `O(n+k)`
- **Stability:**	Yes


- **Worst Case Complexity:** `O(n2)`
When there are elements of close range in the array, they are likely to be placed in the same bucket. This may result in some buckets having more number of elements than others.
It makes the complexity depend on the sorting algorithm used to sort the elements of the bucket.
The complexity becomes even worse when the elements are in reverse order. If insertion sort is used to sort elements of the bucket, then the time complexity becomes O(n2).

- **Best Case Complexity:** `O(n+k)`
It occurs when the elements are uniformly distributed in the buckets with a nearly equal number of elements in each bucket.
The complexity becomes even better if the elements inside the buckets are already sorted.
If insertion sort is used to sort elements of a bucket then the overall complexity in the best case will be linear ie. O(n+k). O(n) is the complexity for making the buckets and O(k) is the complexity for sorting the elements of the bucket using algorithms having linear time complexity at the best case.

- **Average Case Complexity:** `O(n)`
It occurs when the elements are distributed randomly in the array. Even if the elements are not distributed uniformly, bucket sort runs in linear time. It holds true until the sum of the squares of the bucket sizes is linear in the total number of elements.

### Bucket Sort Applications
Bucket sort is used when:

- input is uniformly distributed over a range.
- there are floating point values