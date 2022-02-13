 public void balance (T data[], int first, int last) {
	if (first <= last) {
		int middle = (first + last ) / 2;
		insert(data[middle]);
		balance(data, first, middle - 1);
		balance(data, middle + 1, last);
	}
 }

public void balance(T data[]{
	balance(data, 0, data.length - 1);
}
