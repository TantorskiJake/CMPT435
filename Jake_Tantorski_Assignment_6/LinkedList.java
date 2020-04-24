
public class LinkedList {

    // The LinkedList Node class
    private class Node {

        int data;
        Node next;

        Node(int gdata) {
            this.data = gdata;
            this.next = null;
        }

        Node sortedMerge(Node node1, Node node2) {
            Node result = null;

            // BS if the nodes are null
            if (node1 == null) {
                return node2;
            }
            if (node2 == null) {
                return node1;
            }


            if (node1.data <= node2.data) {
                result = node1;
                result.next = sortedMerge(node1.next, node2);
            } else {
                result = node2;
                result.next = sortedMerge(node1, node2.next);
            }
            return result;

        }

        Node mergeSort(Node nodeX) {

            //check to see if base case null
            if (nodeX == null || nodeX.next == null) {
                return nodeX;
            }

            //middle node
            Node middle = getMiddle(nodeX);
            Node nextofmiddle = middle.next;

            //next to the middle becomes null
            middle.next = null;

            // MS to the left side
            Node left = mergeSort(nodeX);

            //MS to the right side
            Node right = mergeSort(nextofmiddle);

            // Merge the two sides together
            Node sortedlist = sortedMerge(left, right);

            return sortedlist;

        }

    }

    // The LinkedList fields
    Node head;

    // Constructor
    LinkedList(int gdata) {
        this.head = new Node(gdata);
    }

    public static Node getMiddle(Node head) {
        if (head == null) {
            return head;
        }

        Node slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void Insertend(int gdata) {
        Node current = this.head;

        while (current.next != null) {
            current = current.next;
        }

        Node newnode = new Node(gdata);
        current.next = newnode;

    }

    public void Listprint() {
        Node current = this.head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();

    }

    public void Listsort(Node sortNode) {
        // Complete this method to sort a Linked list
        // Return the first node in the sorted list
        // Feel free to change the method type, add/remove parameters
        // Full credit (30 points) will be awarded for an algorithm that is O(nlog n).
        // Algorithms that are O(n^2) slower will be scored out of 10 points.

        sortNode = sortNode.mergeSort(sortNode);

    }

    public static void main(String[] args) {

        LinkedList exlist = new LinkedList(0);
        exlist.Insertend(1);
        exlist.Insertend(5);
        exlist.Insertend(2);
        exlist.Insertend(7);
        exlist.Insertend(10);
        exlist.Insertend(3);

        exlist.Listprint();
        exlist.Listsort(exlist.head);
        exlist.Listprint();


    }

}
