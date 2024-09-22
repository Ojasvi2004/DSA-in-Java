import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;;
public class Queues2 {
  static Queue<Integer> q1=new LinkedList<>();
     static  Stack<Integer> s1= new Stack<Integer>();
    public static void  ReverseQueue()
    { 
      while(q1.size()>0)
      {
      s1.push(q1.remove());
      }
      while(s1.size()>0)
      {
        q1.add(s1.pop());
      }
    }
    public class StacksasQueues
    {
     void push(int val)
     {
      q1.add(val);
     } 
     int pee;
    }
    public static void main(String[] args) 
    {
    q1.add(1);
    q1.add(2);
    q1.add(3);
    System.out.println(q1);
     //ReverseQueue();
     //System.out.println(q1);
    System.out.println(q1.poll());
    }
}
