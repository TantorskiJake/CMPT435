import java.util.*;

public class BST  implements Iterable
{


   private Node root;
   private Comparator comparator;

   public BST()
   {
      root = null;
      comparator = null;
   }

   public BST(Comparator comp)
   {
      root = null;
      comparator = comp;
   }

   private int compare(int x, int y)
   {
      if(comparator == null)
      {
    	if(x>y)
    		return 1;
  		else if (x==y)
   			return 0;
 		else
    		return -1;
      }
      else
      return comparator.compare(x,y);
   }

/*****************************************************
*
*            INSERT
*
******************************************************/
   public void insert(int data)
   {
      root = insert(root, data);
   }
   private Node insert(Node p, int toInsert)
   {
      if (p == null)
         return new Node(toInsert);

      if (compare(toInsert, p.data) == 0)
      	return p;

      if (compare(toInsert, p.data) < 0)
         p.left = insert(p.left, toInsert);
      else
         p.right = insert(p.right, toInsert);

      return p;
   }

/*****************************************************
*
*            SEARCH
*
******************************************************/
   public boolean search(int toSearch)
   {
      return search(root, toSearch);
   }
   private boolean search(Node p, int toSearch)
   {
      if (p == null)
         return false;
      else
      if (compare(toSearch, p.data) == 0)
      	return true;
      else
      if (compare(toSearch, p.data) < 0)
         return search(p.left, toSearch);
      else
         return search(p.right, toSearch);
   }

/*****************************************************
*
*            DELETE
*
******************************************************/

   public void delete(int toDelete)
   {
      root = delete(root, toDelete);
   }
   private Node delete(Node p, int toDelete)
   {
      if (p == null)  throw new RuntimeException("cannot delete.");
      else
      if (compare(toDelete, p.data) < 0)
      p.left = delete (p.left, toDelete);
      else
      if (compare(toDelete, p.data)  > 0)
      p.right = delete (p.right, toDelete);
      else
      {
         if (p.left == null) return p.right;
         else
         if (p.right == null) return p.left;
         else
         {
         // get data from the rightmost node in the left subtree
            p.data = retrieveData(p.left);
         // delete the rightmost node in the left subtree
            p.left =  delete(p.left, p.data) ;
         }
      }
      return p;
   }
   private int retrieveData(Node p)
   {
      while (p.right != null) p = p.right;

      return p.data;
   }


/*************************************************
 *
 *            TRAVERSAL
 *
 **************************************************/

   public void preOrderTraversal()
   {
      preOrderHelper(root);
   }
   private void preOrderHelper(Node r)
   {
      if (r != null)
      {
         System.out.print(r.data+" ");
         preOrderHelper(r.left);
         preOrderHelper(r.right);
      }
   }

   public void inOrderTraversal()
   {
      inOrderHelper(root);
   }
   private void inOrderHelper(Node r)
   {
      if (r != null)
      {
         inOrderHelper(r.left);
         System.out.print(r.data+" ");
         inOrderHelper(r.right);
      }
   }

/*************************************************
 *
 *            CLONE
 *
 **************************************************/

   public BST clone()
   {
      BST twin = null;

      if(comparator == null)
         twin = new BST();
      else
         twin = new BST(comparator);

      twin.root = cloneHelper(root);
      return twin;
   }
   private Node cloneHelper(Node p)
   {
      if(p == null)
         return null;
      else
         return new Node(p.data, cloneHelper(p.left), cloneHelper(p.right));
   }

/*************************************************
 *
 *            MISC
 *
 **************************************************/



   public int countLeaves()
   {
      return countLeaves(root);
   }
   private int countLeaves(Node p)
   {
      if(p == null) return 0;
      else
      if(p.left == null && p.right == null) return 1;
      else
      return countLeaves(p.left) + countLeaves(p.right);
   }



  //This method restores a BST given preorder and inorder traversals
   public void restore(int[] pre, int[] in)
   {
      root = restore(pre, 0, pre.length-1, in, 0, in.length-1);
   }
   private Node restore(int[] pre, int preL, int preR, int[] in, int inL, int inR)
   {
      if(preL <= preR)
      {
         int count = 0;
         //find the root in the inorder array
         while(pre[preL] != in[inL + count]) count++;

         Node tmp = new Node(pre[preL]);
         tmp.left = restore(pre, preL+1, preL + count, in, inL, inL +count-1);
         tmp.right = restore(pre, preL+count+1, preR, in, inL+count+1, inR);
         return tmp;
      }
      else
         return null;
   }

  //The size of a binary tree is the number of elements in the tree.

   public static int size(Node p)
   {
	   if (p!=null)
	   {
		   return 1 + size(p.left) + size(p.right);
	   }
	   return 0;

   }


/*****************************************************
*
*            TREE ITERATOR
*
******************************************************/

   public Iterator iterator()
   {
      return new MyIterator();
   }
   //pre-order
   private class MyIterator implements Iterator
   {
      Stack<Node> stk = new Stack<Node>();

      public MyIterator()
      {
         if(root != null) stk.push(root);
      }
      public boolean hasNext()
      {
         return !stk.isEmpty();
      }

      public Integer next()
      {
         Node cur = stk.peek();
         if(cur.left != null)
         {
            stk.push(cur.left);
         }
         else
         {
            Node tmp = stk.pop();
            while( tmp.right == null )
            {
               if(stk.isEmpty())
            	   return cur.data;
               tmp = stk.pop();
            }
            stk.push(tmp.right);
         }

         return cur.data;
      }//end of next()

      public void remove()
      {

      }
   }//end of MyIterator

/*****************************************************
*
*            the Node class
*
******************************************************/

   private class Node
   {
      private int data;
      private Node left, right;

      public Node(int data, Node l, Node r)
      {
         left = l; right = r;
         this.data = data;
      }

      public Node(int data)
      {
         this(data, null, null);
      }


   } //end of Node

  //starting indexes for each funnctionn
  static int index = 0;
  static int indexMin = 0;
  static int indexMax = 0;
  static int indexRange = 0;


  //KTH SMALL

  public static int kthSmallestElement(int k, Node root, int counter)
  {
    int newArray[] = inOrderTraversalK(root, counter);
    //the new array should have all elements in order and the k-1 value would be equal to the k value you are looking for
    return newArray[k-1];
  }
//Using the above inOrderTraversalfucntions in order to find the elements and compare it to the new array made
  private static int[] inOrderTraversalK(Node root, int counter)
  {
     int newArray[] = new int[counter];
     inOrderHelperK(root,newArray);
     return newArray;
  }

  private static void inOrderHelperK(Node r, int[] newArray)
  {
     if (r != null)
     {
        inOrderHelperK(r.left,newArray);
        //the data within the node at that particular index
        newArray[index] = r.data;
        //move to the next index
        index++;
        inOrderHelperK(r.right,newArray);
     }
  }


//K1K2RANGE


   public static void k1k2Range(int k1, int k2, Node root, int counter)
   {
     int newArray[] = inOrderTraversalRange(root, counter);
     for(int i = 0; i < newArray.length; i++)
     {
       //checks to see if the element at index i is within range
       if(newArray[i] >= k1 && newArray[i] <= k2)
       {
         //outputs each ofg the elements of array
         System.out.print(newArray[i]+ " ");

       }
     }
   }

   private static int[] inOrderTraversalRange(Node root, int counter)
   {
      int newArray[] = new int[counter];
      inOrderHelperRange(root,newArray);
      return newArray;
   }

   private static void inOrderHelperRange(Node r, int[] newArray)
   {
      if (r != null)
      {
         inOrderHelperRange(r.left,newArray);
         newArray[indexRange] = r.data;
         indexRange++;
         inOrderHelperRange(r.right,newArray);
      }
   }


// FIND MIN


   public static int findmin(Node root, int counter)
   {
     int newArray[] = inOrderTraversalMin(root, counter);
     //in order to find minimum i just said the min was the first element of the array
     return newArray[0];

   }
   private static int[] inOrderTraversalMin(Node root, int counter)
   {
      int newArray[] = new int[counter];
      inOrderHelperMin(root,newArray);
      return newArray;
   }

   private static void inOrderHelperMin(Node r, int[] newArray)
   {
      if (r != null)
      {
         inOrderHelperMin(r.left,newArray);
         newArray[indexMin] = r.data;
         indexMin++;
         inOrderHelperMin(r.right,newArray);
      }
   }


//FIND MAX

   public static int findmax(Node root, int counter)
   {
     int newArray[] = inOrderTraversalMax(root, counter);
     //the max of the array would be the element at the end of the array thus at length -1
     return newArray[newArray.length-1];

   }
   private static int[] inOrderTraversalMax(Node root, int counter)
   {
      int newArray[] = new int[counter];
      inOrderHelperMax(root,newArray);
      return newArray;
   }

   private static void inOrderHelperMax(Node r, int[] newArray)
   {
      if (r != null)
      {
         inOrderHelperMax(r.left,newArray);
         newArray[indexMax] = r.data;
         indexMax++;
         inOrderHelperMax(r.right,newArray);
      }
   }






   public static void main(String[] args)
   {
	  // example code to create a tree and print the tree inorder
      int[] a = {4,5,2,7,1};
      BST bst = new BST();
      for(int n : a) bst.insert(n);
      bst.inOrderTraversal();
      System.out.println();
      System.out.println("The 2nd smallest node is " + kthSmallestElement(2,bst.root,a.length));
	  // the output should be 2
	    System.out.println("The smallest node is " + findmin(bst.root,a.length));
	  // the output should be 1
	    System.out.println("The largest node is " + findmax(bst.root,a.length));
	  // the output should be 7
      System.out.println("Values in [2,5]:  ");
      k1k2Range(2,5,bst.root,a.length);
	  // the output should be 2, 4, 5

   }

}//end of BST
