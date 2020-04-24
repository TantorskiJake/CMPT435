
public class Problem2{

	public static Min2ndMin dcfindmin2ndmin(int[] A, int i, int j){

		Min2ndMin pair = new Min2ndMin();
			//Array Size 1
			if (j - i == 0) {
				pair.min = i;
				pair.min2nd = j;
			}
			//Array Size 2
			else if (j - i == 1) {
				if (A[i] > A[j]) {
					pair.min = j;
					pair.min2nd = i;
				}
				else {
					pair.min = i;
					pair.min2nd = j;
				}
		}
		else {
			int mid = (i + j) / 2;
			int startLeft = i;
			int endLeft = mid;
			int startRight = mid + 1;
			int endRight = j;

			//Set New Variables
			Min2ndMin pairLeft = new Min2ndMin();
			Min2ndMin pairRight = new Min2ndMin();

			pairLeft = dcfindmin2ndmin(A, startLeft, endLeft);
			pairRight = dcfindmin2ndmin(A, startRight, endRight);
//Determine Min and Min2nd
			if (A[pairLeft.min] > A[pairRight.min]) {
				pair.min = pairRight.min;
				pair.min2nd = min(A, pairLeft.min, pairRight.min2nd);
			}
			else {
				pair.min = pairLeft.min;
				pair.min2nd = min(A, pairRight.min, pairLeft.min2nd);
			}
		}
		return pair;
	}

	//Check Whihc is small, return index
	public static int min(int[] A, int aIndex, int bIndex) {
		if (A[aIndex] > A[bIndex]){
		return bIndex;
		}
		else{
		return aIndex;
		}
	}
	public static void main(String[] args) {

	// TODO Auto-generated method
	int[] givenarray = {100,2,3,4,5,6,7,67,32};
	// Test your method
	Min2ndMin pair = new Min2ndMin();
	pair = dcfindmin2ndmin(givenarray, 0, givenarray.length-1);
	int min2nd = pair.min2nd;
	int min = pair.min;
	System.out.println("The min and 2ndmin of the given array are "+ givenarray[min] + " and "+ givenarray[min2nd] +",respectively.");

// Your method should return 2 and 3
	}
}
