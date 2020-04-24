//Jake Tantorski 
public class Problem1 {

	public static double count(double[] A, double x, double n)
	{
		//Index of First Occurrence
		double first = firstIndex(A,0,(int)(n-1),x,n);
		
		//Check to see if x exists
		if(first == -1){
			return first;
		}
		//Index of Last Occurrence
		double last = lastIndex(A,(int)first,(int)n-1,x,n);
		
		//Return Number of Occurrences
		double total = last-first+1;
		return total;
	}
	
	
//Finds first index that x occurrences within the array 
	public static double firstIndex(double[] A, int low, int high, double x, double n)
	{
	if(high >= low)
      {
        int mid = ((int)low + (int)high)/2;
        if((mid == 0 || x > A[mid-1]) && A[mid] == x)
          return mid;
        else if(x > A[mid])
          return firstIndex(A, (mid + 1), high, x, n);
        else
          return firstIndex(A, low, (mid -1), x, n);
      }
      return -1;
    }
//Finds last index that x occurrences within the array
	public static double lastIndex(double[] A, int low, int high, double x, double n)
    {
	if(high >= low)
      {
        int mid = (low + high)/2;
        if((mid == n-1 || x < A[mid+1]) && A[mid] == x)
          return mid;
        else if(x < A[mid])
          return lastIndex(A, low, (mid -1), x, n);
        else
          return lastIndex(A, (mid + 1), high, x, n);
      }
      return -1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// test your count() method here

		double[] testarray = {1.3, 2.1, 2.1, 2.1, 2.1, 6.7, 7.5, 7.5, 8.6, 9.0};
		double t1 = 2.1;
		double t2 = 7.5;
		double t3 = 1.3;
		double t4 = 8.7;
		double n = testarray.length;

		System.out.println(t1+" appears "+ count(testarray, t1,n) + " times");
		System.out.println(t2+" appears "+ count(testarray, t2,n) + " times");
		System.out.println(t3+" appears "+ count(testarray, t3,n) + " times");
		System.out.println(t4+" appears "+ count(testarray, t4,n) + " times");


	}

}
