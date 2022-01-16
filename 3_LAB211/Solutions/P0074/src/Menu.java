
public class Menu {
	public void menu(){
		int choice;
		do{
			System.out.println(" ========Calculator Program=======");
			System.out.println("| 1. Matrix Addition              |");
			System.out.println("| 2. Matrix subtraction           |");
			System.out.println("| 3. Matrix Multiplication        |");
			System.out.println("| 4. Quit                         |");
			System.out.println(" =================================\n");
			choice = Utilities.inputInt("Your choice is: ", 1, 4);
			int rowA, colA, rowB, colB;
			Matrix A = new Matrix(), B = new Matrix();

			switch(choice){
				
				case 1:
					System.out.println("\n-------- Matrix Addition --------");
					System.out.println("\n Enter dimensions of matrix A: ");
					rowA = Utilities.inputInt("Number of rows: ", 1, Integer.MAX_VALUE);
					colA = Utilities.inputInt("Number of columns: ", 1, Integer.MAX_VALUE);
					A.get_input('A', rowA, colA);
					
					System.out.println("\n Enter dimensions of matrix B: ");
					rowB = Utilities.inputInt("Number of rows: ", 1, Integer.MAX_VALUE);
					colB = Utilities.inputInt("Number of columns: ", 1, Integer.MAX_VALUE);
					B.get_input('B', rowB, colB);
					
					System.out.println("\n");
					A.DisplayMatrix();
					System.out.println(" + \n");
					B.DisplayMatrix();
					System.out.println(" = ");
					Matrix.addMatrix(A, B).DisplayMatrix();
					break;
				/*
				case 1:
					System.out.println("\n-------- Matrix Addition --------");
					rowA=Utilities.inputInt("Enter Row Matrix 1:",1,Integer.MAX_VALUE);
                    colA=Utilities.inputInt("Enter Column Matrix 1:",1,Integer.MAX_VALUE);
                    
                    do
                    {      
                        rowB=Utilities.inputInt("Enter Row Matrix 2:",1,Integer.MAX_VALUE);
                        colB=Utilities.inputInt("Enter Column Matrix 2:",1,Integer.MAX_VALUE);  
                        if( rowA!=rowB || colA!=colB )
                            System.out.println("Invalid matrix size for operator! Please re-enter!");
                        else
                        {
                            A.get_input('A',rowA,colA);
                            B.get_input('B',rowB,colB);
                            break;
                        }
                    }
                    while(true);
                    
                    ///Calc
                    
                    System.out.println("=======Result=======");
                    A.DisplayMatrix();
                    System.out.println("+");
                    B.DisplayMatrix();
                    System.out.println("=");
                    Matrix.matrixAddition(A, B).DisplayMatrix();
                    break;
					*/
					
				case 2:
					System.out.println("\n-------- Matrix Subtraction --------");
					System.out.println("\n Enter dimensions of matrix A: ");
					rowA = Utilities.inputInt("Number of rows: ", 1, Integer.MAX_VALUE);
					colA = Utilities.inputInt("Number of columns: ", 1, Integer.MAX_VALUE);
					A.get_input('A', rowA, colA);
					
					System.out.println("\n Enter dimensions of matrix B: ");
					rowB = Utilities.inputInt("Number of rows: ", 1, Integer.MAX_VALUE);
					colB = Utilities.inputInt("Number of columns: ", 1, Integer.MAX_VALUE);
					B.get_input('B', rowB, colB);
					
					System.out.println("\n");
					A.DisplayMatrix();
					System.out.println(" - ");
					B.DisplayMatrix();
					System.out.println(" = ");
					Matrix.subtractMatrix(A, B).DisplayMatrix();
					break;
					
				case 3:
					System.out.println("\n-------- Matrix Multiplication (dot product) --------");
					System.out.println("\n Enter dimensions of matrix A: ");
					rowA = Utilities.inputInt("Number of rows: ", 1, Integer.MAX_VALUE);
					colA = Utilities.inputInt("Number of columns: ", 1, Integer.MAX_VALUE);
					A.get_input('A', rowA, colA);
					
					System.out.println("\n Enter dimensions of matrix B: ");
					rowB = Utilities.inputInt("Number of rows: ", 1, Integer.MAX_VALUE);
					colB = Utilities.inputInt("Number of columns: ", 1, Integer.MAX_VALUE);
					B.get_input('B', rowB, colB);
					
					System.out.println("\n");
					A.DisplayMatrix();
					System.out.println(" . ");
					B.DisplayMatrix();
					System.out.println(" = ");
					Matrix.dotProduct(A, B).DisplayMatrix();
					break;
			}
		}while(choice != 4);
		
		System.out.println("============ Thanks for using our product! ============");
		System.out.println("                   have a good day!                    ");
	}
}
