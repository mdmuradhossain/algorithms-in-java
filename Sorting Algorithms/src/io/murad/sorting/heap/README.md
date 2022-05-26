# Heap Sort Algorithm

Heap Sort is a popular and efficient sorting algorithm in computer programming. Learning how to write the heap sort algorithm requires knowledge of two types of data structures - arrays and trees.

The initial set of numbers that we want to sort is stored in an array e.g. `[10, 3, 76, 34, 23, 32]` and after sorting, we get a sorted array `[3,10,23,32,34,76]`.

Heap sort works by visualizing the elements of the array as a special kind of complete binary tree called a heap.

>Note: As a prerequisite, you must know about a complete binary tree and heap data structure.

## Relationship between Array Indexes and Tree Elements

A complete binary tree has an interesting property that we can use to find the children and parents of any node.

If the index of any element in the array is `i`, the element in the index `2i+1` will become the left child and element in `2i+2` index will become the right child. Also, the parent of any element at index i is given by the lower bound of `(i-1)/2`.

on the left, there is a graph and on the right there is an array representation of the same graph to compare equivalent indices
![Relationship between array and heap indices](https://cdn.programiz.com/cdn/farfuture/yBcZxf7VSecOV66J8-kdwS0lX5mah3oLZzWcbRNqFog/mtime:1586942656/sites/tutorial2program/files/array-vs-heap-indices.png)

Let's test it out,

`Left child of 1 (index 0)

= element in (2*0+1) index 

= element in 1 index 

= 12
`


Right child of 1

= element in (2*0+2) index

= element in 2 index 

= 9


Similarly,

Left child of 12 (index 1)

= element in (2*1+1) index

= element in 3 index

= 5


Right child of 12

= element in (2*1+2) index

= element in 4 index

= 6


Let us also confirm that the rules hold for finding parent of any node

Parent of 9 (position 2) 

= (2-1)/2 

= ½ 

= 0.5

~ 0 index 

= 1


Parent of 12 (position 1) 

= (1-1)/2 

= 0 index 

= 1

Understanding this mapping of array indexes to tree positions is critical to understanding how the Heap Data Structure works and how it is used to implement Heap Sort.

## What is Heap Data Structure?

Heap is a special tree-based data structure. A binary tree is said to follow a heap data structure if

- it is a complete binary tree
- All nodes in the tree follow the property that they are greater than their children i.e. the largest element is at the root and both its children and smaller than the root and so on. Such a heap is called a max-heap. If instead, all nodes are smaller than their children, it is called a min-heap

The following example diagram shows Max-Heap and Min-Heap.

![max heap min heap comparison ,Max Heap and Min Heap](https://cdn.programiz.com/cdn/farfuture/ku9PI_QBgYEk3neZkm92PDkwkvQzbTQX_aSYg_Ns6M0/mtime:1586942755/sites/tutorial2program/files/max-heap-min-heap.png)


## How to "heapify" a tree

Starting from a complete binary tree, we can modify it to become a Max-Heap by running a function called heapify on all the non-leaf elements of the heap.

Since heapify uses recursion, it can be difficult to grasp. So let's first think about how you would heapify a tree with just three elements.

`heapify(array)`
    `Root = array[0]`
    `Largest = largest( array[0] , array [2*0 + 1]. array[2*0+2])`
    `if(Root != Largest)`
          `Swap(Root, Largest)`
          

![Heapify base cases](https://cdn.programiz.com/cdn/farfuture/30vnL_La8pfA_TTxFypa1W6TTGXTyDBv2Bgk8BAmwKA/mtime:1587702414/sites/tutorial2program/files/heapify-base-case_0.png)

The example above shows two scenarios - one in which the root is the largest element and we don't need to do anything. And another in which the root had a larger element as a child and we needed to swap to maintain max-heap property.

If you're worked with recursive algorithms before, you've probably identified that this must be the base case.

Now let's think of another scenario in which there is more than one level.

![How to heapify root element when its subtrees are already max heaps](https://cdn.programiz.com/cdn/farfuture/fbVKp-kc906qn9j2PHyJAT_WAwHV2XTiV6PvnSssv5U/mtime:1586942750/sites/tutorial2program/files/heapify-when-children-are-heaps.png)

The top element isn't a max-heap but all the sub-trees are max-heaps.

To maintain the max-heap property for the entire tree, we will have to keep pushing 2 downwards until it reaches its correct position.


![How to heapify root element when its subtrees are max-heaps](https://cdn.programiz.com/cdn/farfuture/1UijfnF1fTdC0naF0xH-tvlIkxey-DLhc88vMAi3G90/mtime:1586942733/sites/tutorial2program/files/heapfy-root-element-when-subtrees-are-max-heaps.png)

Thus, to maintain the max-heap property in a tree where both sub-trees are max-heaps, we need to run heapify on the root element repeatedly until it is larger than its children or it becomes a leaf node.

We can combine both these conditions in one heapify function as

`void heapify(int arr[], int n, int i) {`
  `// Find largest among root, left child and right child`
  `int largest = i;`
  `int left = 2 * i + 1;`
  `int right = 2 * i + 2;`

  `if (left < n && arr[left] > arr[largest])`
    `largest = left;`

  `if (right < n && arr[right] > arr[largest])`
   ` largest = right;`

   ` // Swap and continue heapifying if root is not largest`
    `if (largest != i) {`
      `swap(&arr[i], &arr[largest]);`
      `heapify(arr, n, largest);`
  `}`
`}`

This function works for both the base case and for a tree of any size. We can thus move the root element to the correct position to maintain the max-heap status for any tree size as long as the sub-trees are max-heaps.

## Build max-heap

To build a max-heap from any tree, we can thus start heapifying each sub-tree from the bottom up and end up with a max-heap after the function is applied to all the elements including the root element.

In the case of a complete tree, the first index of a non-leaf node is given by `n/2 - 1`. All other nodes after that are leaf-nodes and thus don't need to be heapified.

So, we can build a maximum heap as

    `// Build heap (rearrange array)`
    `for (int i = n / 2 - 1; i >= 0; i--)`
      `heapify(arr, n, i);`
      
>steps to build max heap for heap sort

![Create array and calculate i](https://cdn.programiz.com/cdn/farfuture/ep4SjRFZZbEsM10mXLEsWxgk0IUxYwIQTRCStHpxNRE/mtime:1586942720/sites/tutorial2program/files/build-max-heap.png)
![steps to build max heap for heap sort](https://cdn.programiz.com/cdn/farfuture/uGu5NTueaGzATlldVMVkJ0smTclr1loskdD7ASYYp44/mtime:1586942703/sites/tutorial2program/files/build-max-heap-0.png)
![Steps to build max heap for heap sort](https://cdn.programiz.com/cdn/farfuture/zVtMrgAyh8rV-yjXHi6BKyR3EhGDftydtGZbA_Jd-Ms/mtime:1586942708/sites/tutorial2program/files/build-max-heap-1.png)
![steps to build max heap for heap sort](https://cdn.programiz.com/cdn/farfuture/xXHiTf614ZV4eJR_Mp5owybelD_kpHozV35Dsj80kUk/mtime:1592889836/sites/tutorial2program/files/build-max-heap-2_01.png)

As shown in the above diagram, we start by heapifying the lowest smallest trees and gradually move up until we reach the root element.

If you've understood everything till here, congratulations, you are on your way to mastering the Heap sort.

## Working of Heap Sort

1. Since the tree satisfies Max-Heap property, then the largest item is stored at the root node.

2. Swap: Remove the root element and put at the end of the array (nth position) Put the last item of the tree (heap) at the vacant place.

3. Remove: Reduce the size of the heap by 1.

4. Heapify: Heapify the root element again so that we have the highest element at root.

5. The process is repeated until all the items of the list are sorted.

![Swap, Remove, and Heapify](https://cdn.programiz.com/cdn/farfuture/VicaT2DyDXxbtM88OYklajepD4hkdSumEHTg2nBwe7s/mtime:1586942728/sites/tutorial2program/files/heap_sort.png)

The code below shows the operation.

    `// Heap sort`
    `for (int i = n - 1; i >= 0; i--) {`
      `swap(&arr[0], &arr[i]);`
      `// Heapify root element to get highest element at root again`
      `heapify(arr, i, 0);`
   ` }`
