
public class Problem4 {

	public static int squareroot(int x)
	{
		int lower = 1;
		int upper = x;
		int ans = 0;

		while (lower <= upper){
		int mid = (lower + upper) / 2;
		int midSquare = mid * mid;

		
		if (midSquare == x)
			return mid;

		
		if (midSquare < x){
			lower = mid + 1;
			ans = mid;
		}
		else 
			upper = mid-1;
	}
	return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// test your count() method here
		
		int x1 = 8;
		int x2 = 5;
		int x3 = 17;
		System.out.println("The square root of " + x1 + " is " + squareroot(x1));
		System.out.println("The square root of " + x2 + " is " + squareroot(x2));
		System.out.println("The square root of " + x3 + " is " + squareroot(x3));
		
		
	}

}
