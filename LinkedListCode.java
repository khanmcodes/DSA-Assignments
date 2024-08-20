class Node
{
    int data;
    Node next;

    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}

class LinkedList
{
    Node head;
    Node tail;

    LinkedList()
    {
        this.head = null;
        this.tail = null;
    }

    LinkedList(int data)
    {
        Node newNode = new Node(data);
        head = newNode;
        tail = newNode;
    }

    void pushFront(int data)        // Push Front
    {
        Node newNode = new Node(data);

        if(this.head==null)
        {
            this.head = newNode;
            this.tail = newNode;
        }

        else
        {
            newNode.next = head;
            head = newNode;
        }
    }

    void pushBack(int data)         // Push Back
    {
        Node newNode = new Node(data);

        if(this.head==null)
        {
            this.head = newNode;
            this.tail = newNode;
        }

        else
        {
            tail.next = newNode;
            tail = newNode;
        }
    }

    boolean isEmpty()               // Is Empty
    {
        if(head==null)
        {
            System.out.println("Linked List is Empty!");
            return true;
        }

        else
            return false;
    }

    int topFront()                  // Top Front
    {
        if(this.isEmpty())
        {
            return -1;          // -1 indicates empty, nothing.
        }

        else
            return head.data;
    }

    void popFront()                 // Pop Front
    {
        if(head==null)
        {
            return;
        }

        head = head.next;
    }

    void popBack()                 // Pop Back
    {
        if(head==null)
        {
            return;
        }

        if(head==tail)
        {
            head = null;
            tail = null;
            return;
        }

        Node temp = head;

        while(temp.next!=tail)
        {
            temp = temp.next;
        }

        temp.next = null;
        tail = temp;
    }

    boolean find(int data)          // Find Key
    {
        Node temp = head;
        
        while(temp!=null)
        {
            if(data==temp.data)
            {
                return true;
            }

            temp = temp.next;
        }

        return false;
    }

    void printList()                // Print List
    {
        Node temp = head;

        System.out.print("\n{");

        while(temp!=null)
        {
            System.out.print(temp.data+", ");
            temp = temp.next;
        }

        System.out.println("\b\b}\n");
    }

    void printList(Node node)       // Print Using Recursion
    {
        if(node == null)
        {
            return;
        }

        System.out.print(node.data+", ");
        printList(node.next);
    }

    void printListRev(Node temp)    // Reverse Print Using Recursion
    {
        if(temp == null)
        {
            return;
        }

        printListRev(temp.next);
        System.out.print(temp.data+", ");
    }
}

class LinkedListCode
{
    public static void main(String [] args)
    {
        LinkedList l1 = new LinkedList(12);

        System.out.print("\nList: ");  
        l1.printList();
        
        System.out.print("Push Front 11 then 10: ");
        l1.pushFront(11);
        l1.pushFront(10);
        l1.printList();

        System.out.print("Push Back 13 then 14: ");
        l1.pushBack(13);
        l1.pushBack(14);
        l1.printList();

        // l1.printList(l1.head);
        // l1.printListRev(l1.head);

        System.out.println("First Element of this Linked List is = "+l1.topFront());

        System.out.print("\nPop Front: ");
        l1.popFront();
        l1.printList();

        System.out.print("Pop Back: ");
        l1.popBack();
        l1.printList();

        System.out.print("Find Key (12): ");
        if(l1.find(12))
        {
            System.out.println("FOUND!");
        }

        else
        {
            System.out.println("NOT FOUND!");
        }

        System.out.print("Find Key (15): ");
        if(l1.find(15))
        {
            System.out.println("FOUND!");
        }

        else
        {
            System.out.println("NOT FOUND!");
        }
        
        System.out.print("\nPush Back 14 then 15: ");
        l1.pushBack(14);
        l1.pushBack(15);
        l1.printList();
        
    }
}
