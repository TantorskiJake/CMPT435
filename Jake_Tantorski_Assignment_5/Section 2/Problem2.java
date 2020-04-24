public class Problem2 {

	public static boolean checksum(double[] s1, double[] s2, double x)
	{
		int s = 0;
		int e = s1.length-1;
		boolean result = false;

		 // Loop thru array
		 for(int i = 0; i < s1.length; i++) {
						//If its true
						if (s1[s] + s2[e] == x) {
							result = true;
						//If sum is greater than X
						} else if (s1[s] + s2[e] > x){
							e = e -1;
						// If sum is less than x
						}else if(s1[s] + s2[e] < x) {
							s = s + 1;
						}
		 }
		 return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Test your checksum() method here
		double[] testarray1 = {1, 10, 45};
		double[] testarray2 = {-8, 4, 6};
		double target1 = 16;
		double target2 = 70;

		System.out.println("Does there exist a number from testarray1, and a number from testarray2, and their sum is "+ target1 + "?");
		System.out.println(checksum(testarray1,testarray2, target1));
		// should print true

		System.out.println("Does there exist a number from testarray1, and a number from testarray2, and their sum is "+ target2 + "?");
		System.out.println(checksum(testarray1,testarray2, target2));
		// should print false

	}

}
