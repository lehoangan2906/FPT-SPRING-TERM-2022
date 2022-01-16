
public class Matrix {
	private int matrix[][];
	int row, column;

	public Matrix(){

	}

	public Matrix(int r, int c, int[][] matrix) {
		this.row = r;
		this.column = c;
		this.matrix = matrix;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}



	public void get_input(char c, int row, int column){
		this.row = row;
		this.column = column;
		this.matrix = new int[row][column];

		for (int i = 0; i < row; i++){
			for (int j = 0; j < column; j++){
				this.matrix[i][j] = Utilities.inputInt("Enter matrix " + c + "[" + (i + 1) + "][" + (j + 1) + "]: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
			}
		}
	}

	public void DisplayMatrix(){
		for (int i = 0; i < this.row; i++){
			for (int j = 0; j < this.column; j++){
				System.out.print("["+this.matrix[i][j]+"]");
			}
			System.out.println("\n");
		}
	}

	public static Matrix addMatrix(Matrix A, Matrix B){
		int r = A.getRow(), c = A.getColumn();

			// cannot use array's operations on Matrix so we need to 
			// operate on these Matrix's array representations
		int[][] mA = A.getMatrix(), mB = B.getMatrix(), temp = new int[r][c];

		for (int i = 0; i < r; i++){
			for (int j = 0; j < c; j++){
				temp[i][j] = mA[i][j] + mB[i][j];
			}
		}

			// convert the temp array back to Matrix type
		Matrix C = new Matrix(r, c, temp);
		return C;
	}
    

	public static Matrix subtractMatrix(Matrix A, Matrix B){
		int r = A.getRow(), c = A.getColumn();

			// cannot use array's operations on Matrix so we need to 
			// operate on these Matrix's array representations
		int[][] mA = A.getMatrix(), mB = B.getMatrix(), temp = new int[r][c];

		for (int i = 0; i < r; i++){
			for (int j = 0; j < c; j++){
				temp[i][j] = mA[i][j] - mB[i][j];
			}
		}

			// convert the temp array back to Matrix type
		Matrix C = new Matrix(r, c, temp);
		return C;
	}

	public static Matrix dotProduct(Matrix A, Matrix B){
		int r1 = A.getRow(), c1 = A.getColumn(), c2 = B.getColumn(), r2 = B.getRow();
		int[][] product = new int[r1][c2], 
		firstMatrix = A.getMatrix(), secondMatrix = B.getMatrix();

		for(int i = 0; i < r1; i++) {
			for (int j = 0; j < c2; j++) {
				for (int k = 0; k < c1; k++) {
					product[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
				}
			}
		}
		Matrix C = new Matrix(r1, c2, product);
		return C;
	}
	
}
