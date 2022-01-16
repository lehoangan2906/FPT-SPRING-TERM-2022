
package Recursion;

public class Main {
	
	public static int recurSum(int n){
		if (n == 1){
			return n;
		}
		return n + recurSum(n - 1);
	}

	public static int findMin(int arr[], int n){
		/* 
			If there is single element, return it.
			Else return minimum of following.
				a) Last Element
				b) Value returned by recursive call for n-1 elements.
		*/
		
		// if size = 0 -> the array has been traversed
		if (n == 1){
			return arr[0];
		}
		
		return Math.min(arr[n - 1], findMin(arr, n - 1));
	}

	public static int sumArr(int[] arr, int n, int sum){
		if (n == 0){
			return sum;
		}
		return sumArr(arr, n - 1, sum + arr[n - 1]);
	}

	public static void main(String[] args) {

		// 1. Write a recursive function that computes the sum of all numbers from 
		// 1 to n, where n is given as parameter.
		int n = 100;
		System.out.println("Sum of all positive integer from 1 to " + n + " is: " + recurSum(n));


		// 2. Write a recursive function that finds and returns the minimum element in 
		// an array, where the array and its size are given as parameters.
		int [] arr = {1, 4, 3, -5, -4, 8, 6};
		System.out.println("Min value of the array: " + findMin(arr, arr.length));
			

		// 3. Write a recursive function that computes and returns the sum of all elements 
		// in an array, where the array and its size are given as parameters.
		int [] arr1 = {1, 9, 6};
		System.out.println(sumArr(arr1, arr1.length, 0));

		// 4. Write a recursive function that determines whether an array is a palindrome,
		//  where the array and its size are given as parameters.
		
		
	}
}

