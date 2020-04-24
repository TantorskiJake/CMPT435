public class Problem6 {

	public static void main(String[] args) {

			int x1 = 2;
			int x2 = 5;
			int x3 = 17;

			System.out.println("The square root of " + x1 + " is " + squareroot(x1));
			System.out.println("The square root of " + x2 + " is " + squareroot(x2));
			System.out.println("The square root of " + x3 + " is " + squareroot(x3));


	}
	public static int squareroot(int x)
	{
		int lower = 1;
		int upper = x;
		int ans = 0;

		while (lower <= upper){
		int mid = (lower + upper) / 2;
		int midSquare = mid * mid;

		
		if (mid*mid == x)
			return mid;

		
		if (mid*mid < x){
			lower = mid + 1;
			ans = mid;
		}
		else 
			upper = mid-1;
	}
	return ans;
	}
}
