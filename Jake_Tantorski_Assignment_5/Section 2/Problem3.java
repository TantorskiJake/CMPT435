public class Problem3 {




	public static void commonelements(double[] s1, double[] s2)
	{
		int i = 0;
		int j = 0;
		//Make sure that i and j goes thru all the elments
		while (i < s1.length && j < s2.length)
			 {
				 		//Same
						if (s1[i] == s2[j])
						{
								System.out.print(s1[i]+" ");
								i++;
								j++;
						}
						//s2 is bigger than s1
						else if (s1[i] < s2[j])
								i++;
						//s1 is bigger than s2
						else
								j++;
			 }
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Test your commonelements() method here
		double[] testarray1 = {0, 0, 0, 1, 2, 3, 97, 98};
		double[] testarray2 = {0, 1, 2, 3, 4, 4, 10, 98, 100, 100};


		System.out.println("Elements that occur in both arrays: ");
		commonelements(testarray1,testarray2);
		//should output 0, 1, 2, 3, 98

	}

}
