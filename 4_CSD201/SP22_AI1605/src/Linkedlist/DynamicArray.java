
package Linkedlist;

class Array{
	private int arr[];
	private int count;

	public Array(int length){
		arr = new int[length];
	}

	public void add(int element){

		if (arr.length == count){
			// creating a new array with the size double the size
			// of the array declare before
			int arr2[] = new int[2 * count];

			for (int i = 0; i < count; i++){
				arr2[i] = arr[i];
			}
			arr = arr2;
		}
		arr[count++] = element;
	}

	public void print(){
		for (int i = 0; i < count; i++){
			System.out.print(arr[i] + " ");
		}
	}
}

public class DynamicArray {
	public static void main(String[] args) {
		Array numbers = new Array(3);

		numbers.add(9);
		numbers.add(8);
		numbers.add(7);
		numbers.add(10);

		numbers.print();
	}
}