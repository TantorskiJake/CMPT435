import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Coinchange {

	public static int greedycoinchange(int givenvalue, int[] givencoins)
	{
		// Complete code here to make change of givenvalue using coins in the array givencoins
		// Minimize the number of coins used
		// Assume that the given coin denominations in array givencoins[] are already sorted in descending order
		// Output: The number of coins used to make change of givenvalue
		// Feel free to change return type and parameters
		int sum = givenvalue;
		int numOfCoins = 0;
		//go through the array for each coinn
		for (int i = 0; i < givencoins.length; i++)
		{
			//check to see if there are still coins needed
			while ((sum - givencoins[i]) >= 0)
			{
				//take the coin value away from the sum
				sum = sum - givencoins[i];
				//add 1 to number of coins needed
				numOfCoins++;
			}
		}
		return numOfCoins;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		int n = 0; // To make a change of n cents

		Scanner reader = new Scanner(System.in);

		System.out.println("Please enter the value you want to make change: ");

		n = reader.nextInt();

		// Infinite supply of quarters, dimes, nickles, and pennies
		int[] coins = {25, 10, 5, 1}; //Sorted already


		System.out.println("The greedycoinchange algorithm uses "+ greedycoinchange(n, coins)+" coins for "+ n + " cents");
	}

}
