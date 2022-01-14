package Queue_Array;

public class Queue_Array {
	Object[] a;
	int max;
	int first, last;

	public Queue_Array(int max1){
		max = max1;
		a = new Object[max];
		first = last = -1;
	}

	public boolean isEmpty(){
		return (first == -1);
	}

	public boolean isFull(){
		return ((first == 0 && last == max) || first == last + 1);
	}

	private boolean grow(){
		int i, j;
		int max1 = max + max/2;
		Object [] a1 = new Object[max1];
		if(a1 == null){
			return false;
		}
		if (last >= first){
			for (i = first; i <= last; i++){
				a1[i - first] = a[i];
			}
		}else{
				for (i = first; i < max; i++){
					a1[i - first] = a[i];
					i = max - first;
				}
				for (j = 0; j <= last; j++){
					a1[i + j] = a[j];
				}
			}
		a = a1;
		first = 0;
		last = max - 1;
		max = max1;
		return (true);
	}
}
