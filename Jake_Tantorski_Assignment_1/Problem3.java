//Jake Tantorski CMPT435 HW1 2/4/20
public class Problem3 {

	
	
	public static boolean majority(int[] A)
	{
		
		int n = A.length;
		int half = n/2;
		
		for(int i = 0;i<half;i++) {
			
			if(A[i] == A[i+n/2]) {
				return true;
			}
		}
		return false;
				
				
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Test your majority method
		
		int[] testarray1 = {0, 0, 0, 0, 0, 0, 1, 1, 2, 4, 7};
		
		int[] testarray2 = {0, 0, 0, 1, 1, 2, 3, 10, 10};
		
		
		System.out.println("Does there exist a majoirty element in testarray1? "+ majority(testarray1));
		System.out.println("Does there exist a majoirty element in testarray2? "+ majority(testarray2));
		
	}

}
