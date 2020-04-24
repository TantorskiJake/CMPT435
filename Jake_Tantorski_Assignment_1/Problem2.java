//Jake Tantorski CMPT435 HW1 2/4/20
public class Problem2 {

	
	
	public static int missingnumber(int[] A)
	{
		
		int sum = 0;
		int total = (A.length+2) * (A.length+1) / 2;
		
		for(int i = 0; i < A.length;i++) {
			sum += A[i];
				
		}
		int missing = total-sum;
		return (missing);
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Test your majority method
		
		int[] testarray1 = {2, 4, 1, 6, 3, 7, 8};
		
		int[] testarray2 = {6, 3, 4, 5, 1};
		
		
		System.out.println("The missing number in testarray1 "+ missingnumber(testarray1));
		System.out.println("The missing number in testarray2 "+ missingnumber(testarray2));
		
	}

}
