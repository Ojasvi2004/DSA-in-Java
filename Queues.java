import java.util.LinkedList;
import java.util.Queue;
public class Queues {
    public static class CyclicArray
    {
    static int arr[]=new int[6];
    static int f,r,size=0;
    static void addCA(int val)
    {
     if (size==arr.length) 
     {
      System.out.println("Error:Array is full ");  
      return;
     }
     else if (size==0) 
     {
        f=r=0;
        arr[0]=val;
     }
     else if (f==arr.length-1 && size<arr.length) 
     {
       f=0;
     }
     else{
        arr[f+1]=val;
        f=f+1;
     }
     size++;
    }
    static void removeCA()
    {
        if (size==0) 
        {
         System.out.println("Error: Array is empty");
         return;   
        }
        else if (f==arr.length-1) {
            f=0;
        }
        else{
            f=f+1;
        }
        size--;
    }
    static void displayCA()
    {
        if (f>r) 
        {
            for (int i = r; i < f+1; i++) 
            {
              System.out.print(arr[i]+ " ");  
            }
        }
        else{
            for (int i = f; i <= r; i++) 
            {
                System.out.print(arr[i]+ " ");
            }
        }
    }
    }
    public static class LLI{
    static class Node{
    int val;
    Node next;
    public  Node(int val)
    {
        this.val=val;
    }   
}
    static int size=0;
    public static Node head= null;
    public static Node tail= null;
    static void addl(int a)
    {
        Node temp=new Node(a);
        if (size==0) {
            head=tail=temp;
        }
        else{
        tail.next=temp;
        tail=temp;
        }
        size++;
    } 
    static void remove()
    {
        if (tail==null) {
            System.out.println("Error:Queue is empty");
            return;
        }
        head=head.next;
        size--;
    }
    static void peakll(){
        System.out.println(head.val);
    }
    static void displayll()
    {
        Node temp= head;
        while (temp !=null) 
        {
          System.out.print(temp.val+" ");
          temp=temp.next;  
        }
    }


}
    public static class ArrayI{
    private static int arr[]=new int[100];
    private static int f=-1, r=-1;
    static int size=0;
    public static void add(int val)
    {
        if (r==arr.length-1) {
            System.out.println("Queue is full");
            return;
        }
        if (f==-1) {
            f=0;r=0;
            arr[0]=val;
        }
        else{
            arr[r+1]=val;
            r=r+1;
        }
        size++;
    }
    public static void remove()
    {
        if (size==0)
        {
          System.out.println("Error:Queue is empty");
          return;  
        }
        else
        {
            f=f+1;
            size--;
        }
    }
    public static void display()
    {
    for (int i = f; i <= r; i++) {
        System.out.print(arr[i]+ " ");
    }
    }
    public static void peeka()
    {
        System.out.println(arr[r]);
    }  
    }
    public static Queue<Integer> q1 = new LinkedList<>();
    public static Queue<Integer> q2 = new LinkedList<>();
        public static void main(String[] args) {
        // q1.add(1);
        // q1.add(2);
        // q1.add(3);
        // q1.add(4);
        // System.out.println(q1);
        // while (!q1.isEmpty()) {
        //     System.out.println(q1.peek());
        //     q2.add(q1.peek()); 
        //     q1.remove();
        // }
        // ArrayI.add(5);
        // ArrayI.add(6);
        // ArrayI.add(7);
        // ArrayI.add(8);
        // ArrayI.display();
        // ArrayI.remove();
        // ArrayI.display();
        // System.out.println();
        // ArrayI.peeka();
        // LLI.addl(9);
        // LLI.addl(10);
        // LLI.addl(11);
        // LLI.addl(12);
        // LLI.addl(13);
        // LLI.displayll();
        // System.out.println();
        // LLI.remove();
        // LLI.displayll();
        CyclicArray.addCA(1);
        CyclicArray.addCA(2);
        CyclicArray.addCA(3);
        CyclicArray.addCA(4);
        CyclicArray.displayCA();
        CyclicArray.removeCA();
        System.out.println();
        CyclicArray.displayCA();
        



    }
}

