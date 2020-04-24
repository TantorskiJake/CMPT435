
public class Problem1 {



	public int findmaxdiff(int [] A, int start, int end){
        if(start >= end)
				{
            return -1;
        }
        int mid = start +  (end-start)/2;
        int leftDiff = findmaxdiff(A,start,mid);
        int rightDiff = findmaxdiff(A,mid+1,end);

        int minLeft = minF(A, start, mid);
        int maxRight = maxF(A, mid, end);

        int tDiff = maxRight - minLeft;
        return Math.max(tDiff, Math.max(leftDiff,rightDiff));
    }
		//Find the Minimum
    public int minF(int [] A, int i, int j){
				//Min Value
        int min = A[i];
				//Loop thru to find min
        for (int k = i+1; k <=j ; k++) {
            if(A[k]<min)
                min = A[k];
        }
        return min;
    }
		//Find the Maximum
    public int maxF(int [] A, int i, int j){
        int max = A[i];
				//loop thru to find max
        for (int k = i+1; k <=j ; k++) {
            if(A[k]>max)
                max = A[k];
        }
        return max;
    }



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem1 result = new Problem1();
		// Test your findmaxdiff() method here

		int[] testarray1 = {2, 3, 10, 6, 4, 8, 1};
		// maxdiff: 8

		int[] testarray2 = {7, 9, 1, 6, 3, 2};
		// maxdiff: 5

		int start = 0;
		int end1 = testarray1.length-1;
		int end2 = testarray2.length-1;

		System.out.println("The Max Differenece is:" + result.findmaxdiff(testarray1,start,end1));
		System.out.println("The Max Differenece is:" + result.findmaxdiff(testarray2,start,end2));



	}
}
