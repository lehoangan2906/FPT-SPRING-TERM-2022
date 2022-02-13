
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

	public static int palindrome(int arr[], int begin, int end){

		// base case if size of the array equals to 1 or 2 so it is palindrome: return 1
		if (begin >= end){
			return 1;
		}
		
		if (arr[begin] == arr[end]){
			return palindrome(arr, begin + 1, end - 1);
		}

		else{
			return 0;
		}
	}

	public static int binarysearch(int[] arr, int left, int right, int x){
		// base case
		if(right >= left){
			int mid = left + (right - left) / 2;

			// if the element is in the middle of the array
			if (arr[mid] == x){
				return mid;
			}
			
			// if element smaller than mid, search in the left branch
			if (arr[mid] > x){
				return binarysearch(arr, left, mid - 1, x);
			}

			// else search in the right branch
			
			return binarysearch(arr, mid + 1, right, x);
			
		}
		
		return -1;
	}


	// Euclidean algorithm
	/*
		+ GCD(A,0) = A
		+ GCD(0,B) = B
		+ If A = B⋅Q + R and B≠0 then GCD(A,B) = GCD(B,R) where Q is an integer, R is an 
		  integer between 0 and B-1
*/
	public static int GCD(int m, int n){
		if (m == 0)
			return n;
		if (n == 0)
			return m;

		// base case
		if (m == n)
			return m;

		// m is greater
		if (m > n)
			return GCD(m - n, n);
		
		// m is smaller
		return GCD(m, n - m);
	}

	public static int gcd(int m, int n){
		if (n == 0)
			return m;

		return gcd(n, m%n);
	}

	public static int power(int x, int n){
		if (n == 0)
			return 1;
		
		return (x * power(x, n - 1));
	}

	public static int fact(int n){
		if (n <= 1)
			return 1;
		
		return (n * fact(n - 1));
	}

	public static int f(int n){
		if (n <= 2)
			return 1;

		return f(n - 2) + f(n - 1);
	}

	public static double addReciprocals(int n){

		double sum = 0.0;

		// base case
		if (n == 0)
			return sum;

		return 1.0/n + addReciprocals(n - 1);

	}

	public static int stirling(int a, int b){
		if(a == 0 && b == 0)
			return 1;
		
		if (a > 0 && b == 0)
			return 0;

		if (b > a)
			return 0;

		return stirling(a - 1, b-1) + (a - 1)*stirling(a - 1, b);
	}


	public static void main(String[] args) {

		// 1. Write a recursive function that computes the sum of all numbers from 
		// 1 to n, where n is given as parameter.
		int n = 100;
		System.out.println("Sum of all positive integer from 1 to " + n + " is: " + recurSum(n));
		System.out.println("\n==========================================\n");


		// 2. Write a recursive function that finds and returns the minimum element in 
		// an array, where the array and its size are given as parameters.
		int [] arr = {1, 4, 3, -5, -4, 8, 6};
		System.out.println("Min value of the array: " + findMin(arr, arr.length));
		System.out.println("\n==========================================\n");


		// 3. Write a recursive function that computes and returns the sum of all elements 
		// in an array, where the array and its size are given as parameters.
		int [] arr1 = {1, 9, 6};
		System.out.println(sumArr(arr1, arr1.length, 0));
		System.out.println("\n==========================================\n");


		// 4. Write a recursive function that determines whether an array is a palindrome,
		//  where the array and its size are given as parameters.
		int [] arr2 = {3, 6, 0, 6, 3};
		int n2 = arr2.length;
		System.out.print("The initial array is: [");

		for (int i = 0; i < n2; i++){
			System.out.print(arr2[i]);
		}

		System.out.println("]");

		if (palindrome(arr2, 0, n2 - 1) == 1){
			System.out.println("the array is palindrome");
		}
		else{
			System.out.println("the array is not palindrome");
		}
		System.out.println("\n==========================================\n");
		

		// 5. Write a recursive function that searches for a target in a sorted array using
		// binary search, where the array, its size and the target are given as parameters.
		int[] arr3 = {2, 3, 4, 5, 8, 10, 40, 60, 80, 90};
		int n3 = arr3.length;
		int x = 90;
		int result = binarysearch(arr3, 0, n3 - 1, x);
		if (result != -1){
			System.out.println("Element is in the array at index " + result);
		}else{
			System.out.println("Element is not in the array");
		}
		System.out.println("\n==========================================\n");


		// 6. Implement the Greatest Common Divisor algorithm as recursive method GCD. 
		// Use recursion. Do NOT use a loop.

		System.out.println("Greatest common divisor");
		System.out.println("gcd= " + gcd(98, 56));

		System.out.println("\n==========================================\n");

		
		// 7. Implement the power function recursively
		System.out.println("Power");
		System.out.println("4 to the power of 2 = " + power(4, 2));
		System.out.println("\n==========================================\n");

		
		// 8. Implement the factorial function recursively as fact
		System.out.println("Factorial");
		System.out.println("fact(5) = " + fact(5));
		System.out.println("\n==========================================\n");

		
		// 9. Implement Fibonacci recursively as f
		System.out.println("Fibonacci");
		System.out.println("f(10) = " + f(10));
		System.out.println("\n==========================================\n");
		

		// 10. Write recursive method addReciprocals that takes an integer as a parameter and 
		// returns the sum of the first n reciprocals.
		System.out.println("Reciprocal");
		System.out.println("Recipocal sum of first 10 numbers = " + addReciprocals(10));
		System.out.println("\n==========================================\n");

		
		// 11. Write a recursive routine to calculate stirling numbers of the first kind.
		System.out.println("Stirling numbers");
		System.out.println("Stirling(9, 2) = " + stirling(9, 2));
		System.out.println("\n==========================================\n");
		

		BinaryTree binarytree = new BinaryTree();
		binarytree.root = new Node(1);
		binarytree.root.left = new Node(2);
		binarytree.root.right = new Node(3);
		binarytree.root.left.left = new Node(4);
		binarytree.root.left.right = new Node(5);


		// 12. Given a labeled binary tree (represented by a pointer to a TreeNode) calculate its height.
		System.out.println("Height of tree = " + binarytree.maxDepth(binarytree.root));
		System.out.println("\n==========================================\n");


		// 13. Given a labeled binary tree (represented by a pointer to a TreeNode) calculate its size.
		System.out.println("Size of tree = " + binarytree.size(binarytree.root));
	}
}

