public class SubsetSumDP {

	public static boolean subsetSum(int[] A, int x) {

		boolean[][] Sum = new boolean[A.length + 1][x+1];

		for(int i = 0; i < A.length+1; i++)
		{
			Sum[i][0] = true;
		}

		for(int j = 1; j < x+1; j++)
		{
			Sum[0][j] = false;
		}

		for(int i = 1; i < A.length+1; i++)
		{
			for(int j = 1; j < x+1; j++)
			{
				if(A[i-1] > j)
				{
					Sum[i][j] = Sum[i-1][j];
				}
				else
				{
					Sum[i][j] = Sum[i-1][j]||Sum[i-1][j-A[i-1]];
				}
			}
		}
		// Complete the function from here
		// Feel free to change the return type and parameters
		// Implement the dynamic programming Subset Sum Algorithm
		// Return true if there exists a subset in A with sum = x
		// Hint: Follow the pseudocode of subsetSum in the slides


		//Test for Table
		for(int i = 0; i < A.length+1; i++){
			for(int j = 0; j < x+1; j++){
					if(Sum[i][j] == true){
						System.out.print("T  ");
					}
					else if(Sum[i][j] == false){
						System.out.print("F  ");
					}

			}
			System.out.println();
		}


		return Sum[A.length][x];
	}

	public static void main(String[] args) {

		int[] A = {1,5,2,8};
		int x = 4;
		System.out.println("There exists a subset in A[] with sum = " + x + " : " + subsetSum(A, x) );
		//System.out.println("There exists a subset in A[] with sum = " + y + " : " + subsetSum(B, y) );
		// Expected output: true
	}

}
