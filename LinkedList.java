public class LinkedList {
    public static class Node {
    int data;
    Node next;
    Node(int val)
    {
        data=val;
    }
    
}
static Node head2=null;
public void LinkedList2()
{
    head=null;
}
static void InsertAtIndex(int i,int val)
{
    int index=0;
    Node temp=head;
    Node t =new Node(val);
    while (index<i-1) {
        temp=temp.next;
        index++;   
    }
    t.next=temp.next;
    temp.next=t;
}
static void DeleteElement(int i)
{
    Node temp=head;
    int index=0;
    while (index<i-1) 
    {
     temp=temp.next;
     index++;   
    }
    temp.next=temp.next.next;
}
    static void DeleteNodeByParameter(Node n)
    {
     n.data=n.next.data;
     n.next=n.next.next;
     
    }
    static Node FindNthNodeFromEnd_1(int n)
    {
        int size=0;
     Node temp=head;
     while (temp != null) {
        temp=temp.next;
        size++;
     }
     temp=head;
     int nterm=size-n+1;
     for (int i = 0; i < nterm-1; i++) {
        temp=temp.next;
     }
     return temp;

    }
    static Node FindNthNodeFromEnd_2(int n)
    {
        Node fast=head;
        Node slow=head;
        for (int i = 0; i < n; i++) {
            fast=fast.next;
        }
        while (fast != null) 
        {
           fast=fast.next;
           slow=slow.next; 
        }
        return slow;

    }
    static  Node FindIntersectionOfTwoLists()
    {
       return head;
    }
    
     static void DisplayLL(Node head)
    {
        Node temp=head;
        while (temp != null) 
        {
           System.out.println(temp.data+" ");
           temp=temp.next; 
        }
    }
     static void DisplayLLRecurrsively(Node head)
    {
        Node temp=head;
        if (temp==null) {
            return;
        }
        System.out.println(temp.data+" ");
        DisplayLLRecurrsively(temp.next);
    }
    static Node head;
    public  void LinkedList1()
    {
        head=null;;
    }
    static void  DisplayLLRecurrsively_Reverse(Node head)
    {
        Node temp=head;
        if (temp==null) {
            return;
        }
        DisplayLLRecurrsively_Reverse(temp.next);
        System.out.println(temp.data+" ");
    }
    static void InsertAtEnd(int val)
    {
    Node temp=head;
     Node t=new Node(val);
     if (head==null) {
        head=t;
        return;
     }
     while (temp.next != null) {
        temp=temp.next;
     }
     temp.next=t;

    }
    public static void main(String[] args) {
        // Node a=new Node(5);
        // Node b=new Node(10);
        // Node c=new Node(15);
        // Node d=new Node(20);
        // a.next=b;
        // b.next=c;
        // c.next=d;
        // DisplayLL(a);
        // DisplayLLRecurrsively(a);
        // DisplayLLRecurrsively_Reverse(a);
        InsertAtEnd(1);
        InsertAtEnd(2);
        InsertAtEnd(3);
        InsertAtEnd(6);
        InsertAtIndex(3, 4);
        InsertAtIndex(4, 5);
        DisplayLL(head);
       //  DeleteElement(3);
       //  DisplayLL(head);
       //  System.out.println(FindNthNodeFromEnd(2).data);
        System.out.println(FindNthNodeFromEnd_1(4).data);
        System.out.println(FindNthNodeFromEnd_2(4).data);

                 
    }
}
