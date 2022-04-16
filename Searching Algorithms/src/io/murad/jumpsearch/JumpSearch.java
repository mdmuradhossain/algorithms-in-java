package io.murad.jumpsearch;

import java.util.Scanner;

public class JumpSearch {
	public static int jumpSearch(int arr[], int n, int item) {
		int i = 0;
		int m = (int) Math.sqrt(n); // initializing block size= √(n)

		while (arr[m] <= item && m < n) {
			// the control will continue to jump the blocks
			i = m; // shift the block
			m += (int) Math.sqrt(n);
			if (m > n - 1) // if m exceeds the array size
				return -1;
		}

		for (int x = i; x < m; x++) { // linear search in current block
			if (arr[x] == item)
				return x; // position of element being searched
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n, item, loc;
		System.out.println("\n Enter number of items: ");
		n = input.nextInt();

		int arr[] = new int[n]; // creating an array of size n
		System.out.println("\n Enter items: ");

		for (int i = 0; i < n; i++) {
			arr[i] = input.nextInt();
		}

		System.out.println("\n Enter search key to be found in the array: ");
		item = input.nextInt();
		loc = jumpSearch(arr, n, item);
		if (loc >= 0)
			System.out.println("\n Item found at location: " + loc);
		else
			System.out.println("\n Item is not found in the list.");

		input.close();
	}

}
