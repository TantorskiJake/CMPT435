//Jake Tantorski 3-9-20

public class Problem3
{

    public static int partition(int a[], int low, int high)
    {
        int pivot = a[high]; //pivot is last element
        int i = low-1; //smallest element
        for (int j=low; j<high; j++)
        {
            // If current element <  pivot
            if (a[j] < pivot)
            {
                i++;
                // swapping of the elements
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        // swap arr[i+1] and pivot
        int temp = a[i+1];
        a[i+1] = a[high];
        a[high] = temp;

        return i+1;
    }
    public static void threeway(int a[], int low, int high)
    {
        if (low < high)
        {

            int pivot = partition(a, low, high);

            threeway(a, low, pivot-1);
            threeway(a, pivot+1, high);
        }
    }
    //made a print function that way i can seperate it from the main in order to just work on printing here
    public static void printArray(int testarray[])
    {
        int n = testarray.length;
        for (int i=0; i<n; ++i)
            System.out.print(testarray[i]+", ");
    }

    public static void main(String args[])
    {
        int testarray[] = {1, 2, 2, 2, 6, 1, 7, 0, -5, 2, 8, 1, 3, 1, 1};
        int n = testarray.length;

        Problem3 object = new Problem3();
        object.threeway(testarray, 0, n-1);

        System.out.print("The Array Sorted: ");
        printArray(testarray);
    }
}
