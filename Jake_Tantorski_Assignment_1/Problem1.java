//Jake Tantorski CMPT435 HW1 2/4/20
public class Problem1 {

	public static int reverse(int num)
	{
		int reverseNumber = 0;

		while(num != 0)
      {
          reverseNumber = reverseNumber * 10; //Move up a place
          reverseNumber = reverseNumber + num%10;//Add last digit
          num = num/10;//remove last digit
      }
			return reverseNumber;
	}
	/*Given a 32-bit signed integer x, reverse digits of x.
	Example 1:
	Input: 123
	
	Output: 321
	Example 2:
	Input: -123
	Output: -321
	Example 3:
	Input: 120
	Output: 21
	*/
	// Complete this method
	// Feel free to change return type or parameters



	public static void main(String[] args) {
		// TODO Auto-generated method stub


		int test1 = 123;
		int test2 = -95;
		int test3 = 890;


		System.out.println("Input :" + test1 + " Output: " + reverse(test1));
		System.out.println("Input :" + test2 + " Output: " + reverse(test2));
		System.out.println("Input :" + test3 + " Output: " + reverse(test3));



	}

}
