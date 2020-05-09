import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Fractionalknapsack {



public static void sortitems(ArrayList<item> svd)
{
	// Sort items by density in descending order

	Collections.sort(svd, new Comparator<item>(){
		public int compare(item o1, item o2){
				if(o1.density == o2.density)
							return 0;
									return o1.density > o2.density ? -1 : 1;
																								}
																});
}

public static double greedyfractionalknapsack(ArrayList<item> svd, int S){

	double value = 0;
	//check if we can take all of the items
	for(int i = 0; i< svd.size(); i++)
	{
		//to see if we can add the value to the total
		if(svd.get(i).size < S)
		{
			S = S - svd.get(i).size;
			value = value + svd.get(i).value;
		}
		//check to see if we can take a fraction of the item instead
		else if(svd.get(i).size > S)
		{
			//fraction of an item conversion from int to double
			double fraction = ((double)(S)/(double)(svd.get(i).size));
			value = value + fraction * svd.get(i).value;
			S = 0;
		}
	}
	return value;
}

public static void main(String[] args) {
								int max_size,n;

								ArrayList<item> items=new ArrayList();
								// item 1, value 6, size 1
								items.add(new item(1, 6, 1));
								// item 2, value 10, size 2
								items.add(new item(2, 10, 2));
								// item 3, value 12, size 3
								items.add(new item(3, 12, 3));
								// the size of your knapsack
								max_size=5;
								// sort items by density
								sortitems(items);

								System.out.println("The maximum value we can place into the knapsack is "+ greedyfractionalknapsack(items, max_size));



}
}
