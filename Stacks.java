import java.util.Stack;


public class Stacks {
    public static Stack<Integer> st= new Stack<Integer>();
    public static Stack<Character> st2=new Stack<Character>();
    public static Stack<Integer> st3=new Stack<Integer>(); 
    public static Stack<Integer> st4=new Stack<Integer>();
    public static Stack<Integer> st5= new Stack<Integer>();
    public static Stack<Integer> st6= new Stack<Integer>();
    public static class Node {
          int val;
          Node next;
          Node(int val){
            this.val=val;
          }
    }
    
    static  Node head=null;
    public static void pushl(int val)
    {
        // int size=0;
        Node temp=new Node(val);
        temp.next=head;
        head=temp;
        // size++;
    }
    public static int peakl()
    {
        if (head==null) {
            System.out.println("Stack is empty");
        }
     return head.val;   
    }
    public static void popl()
    {
        if (head==null) {
            System.out.println("Stack is empty");
        }
        head=head.next;
    }
    public static void displayl()
    {
        Node temp=head;
        while (temp != null) {
            System.out.println(temp.val);
            temp=temp.next;
        }

    }
    public static Boolean BalancedBracket(String str){
        int i=0;
        int n=str.length();
        while (i<n) 
        {
            char ch=str.charAt(i);
            
            if (ch=='(') 
            {
                st2.push(ch);
            }

            if (ch==')')
            {
                if (st2.isEmpty()) {
                    return false;
                }
                st2.pop();

            }
            else {if(st2.size()==0) return false;

        }
        i++;   
        }
    if (st2.size()>0) return false;
        else return true;
}
 static void RemoveSequence(int a[])
 {int idx=0;
  while (idx < a.length) 
  {
    if (st4.size()==0 || st4.peek()!=a[idx]) {
        st4.push(a[idx]);
    } 
    else if (st4.peek()==a[idx])
    {
       if(idx==a.length-1 || a[idx]!=a[idx+1])
       {
        st4.pop();
       }
    }
    idx++;

  }

 }
 static void NextGreaterElement(int a[])
  {
    int n=a.length;
    int ans[]=new int[n];
    for (int i = n-1; i>0; i--) 
    {
       while (st.size()>0 && st.peek()<a[i] ) 
       {
        st.pop();
       }
       if (st.isEmpty())
       {
        ans[i]= -1;
       } 
        else {ans[i]=st.peek();}
      
        st.push(a[i]);
    }
    Sorting.PrintArray(ans);

  }
  static void StockSpanProblem(int a[])  
  {
   int n=a.length;
   int ans[]=new int[n];
   for (int i = 0; i < a.length; i++) 
   {
    while (st6.size()>0 && a[st6.peek()]<a[i])
    {
       st6.pop(); 
    }
    if (st6.isEmpty()) {
        ans[i]=1;
    }
    else {ans[i]=i-st6.peek();}
    st6.push(i);
   }
   Sorting.PrintArray(ans);
  }
  static void PreviousGreaterElement(int a[])  
  {
   int n=a.length;
   int ans[]=new int[n];
   for (int i = 0; i < a.length; i++) 
   {
    while (st5.size()>0 && st5.peek()<a[i])
    {
       st5.pop(); 
    }
    if (st5.isEmpty()) {
        ans[i]=-1;
    }
    else {ans[i]=st5.peek();}
    st5.push(a[i]);
   }
   Sorting.PrintArray(ans);
  }
  static void MaxAreaOfHistogram(int a[])
  {
  Stack<Integer> st7 = new Stack<Integer>();
    int n=a.length;
    int Psmaller[]=new int[n];
    for (int i = 1; i <n; i++) {
        while (st7.size()>0 && st7.peek()>a[i]) {
            st7.pop();
        }
        if (st7.isEmpty()) {
            Psmaller[i]=-1;
        }
        else { Psmaller[i]=st.peek();}
        st7.push(a[i]);
    }
    while (!st7.isEmpty()) {
        st7.pop();
    }
    int Nsmaller[]=new int[n];
    for (int i = n-1; i >0; i--) 
    {
       while (st7.size()>0 && st7.peek()>a[i]  ) {
        
       } 
       if (st7.isEmpty() ) {
        Nsmaller[i]= -1;
       }
       else {Nsmaller[i]=st7.peek();}
       st7.push(a[i]);
    }
  }
 static Stack<Integer> stm=new Stack<Integer>();
 public static int min=-1;
   public  static void  push1(int val)
    {
        if (stm.isEmpty()) {
            min=val;
            stm.push(val);
        }
      else if (val>min) {
        stm.push(val);
      }
      else{
        stm.push(val-min);
        min=val;
      }
    }
    public static void pop1()
    {if (stm.peek()>=min) 
        {
          stm.pop();
        }
    else if (stm.isEmpty()) {
        return;
    }
    else {
        min=min-stm.peek();
        stm.pop();
    }
    }
    public static void getmin()
    {
        System.out.println(min);
    }
    public static int InfixEvaluation(String str)
    {
        Stack<Integer> val = new Stack<Integer>();
        Stack<Character> op = new Stack<Character>();
    for (int i = 0; i < str.length(); i++) {
        char ch= str.charAt(i);
        int ascii=(int)ch;
        if (ascii<57 && ascii>48) 
        {
         val.push(ascii-48);
        }
        else{
        if (op.isEmpty()) {
            op.push(ch);
        }
        else{
            if (ch=='+' || ch=='-') {
                int v1= val.pop();
                int v2= val.pop();
                if (op.peek()=='+') {  val.push(v1+v2); }
                if (op.peek()=='1') {  val.push(v1-v2); }
                if (op.peek()=='*') {  val.push(v1*v2); }
                if (op.peek()=='/') {  val.push(v1/v2); }
                op.pop();
                op.push(ch);

            }
            if (ch=='*' || ch=='/') {
                int v1=val.pop();
                int v2=val.pop();
                if (op.peek()=='*') {  val.push(v1*v2); }
                if (op.peek()=='/') {  val.push(v1/v2); }
                op.pop();
                op.push(ch);
            }
            else op.push(ch);
            
        }
        }
    }
    while (val.size()>1) {
                int v1= val.pop();
                int v2= val.pop();
                if (op.peek()=='+') {  val.push(v1+v2); }
                if (op.peek()=='1') {  val.push(v1-v2); }
                if (op.peek()=='*') {  val.push(v1*v2); }
                if (op.peek()=='/') {  val.push(v1/v2); }
                op.pop();
    }
    return val.peek();
    }


 
    public static void main(String[] args) {
        // String str="(())";
        // String str2=")()";
        // System.out.println(st);
        // System.out.println(BalancedBracket(str));
        // System.out.println(BalancedBracket(str2));
        // pushl(9);
        // pushl(8);
        // pushl(7);
        // pushl(6);
        // pushl(5);
        // displayl();
        // System.out.println();
        // popl();
        // displayl();
        //  int arr[] = {1,2,2,3,3,4,5,6,6,6,7,8};
        // int arr2[] = {100,80,60,70,60,75,85};
        //  RemoveSequence(arr);
        //  System.out.println(st4);
        // NextGreaterElement(arr2);
        // System.out.println();
        // PreviousGreaterElement(arr2);
        // System.out.println();
        // StockSpanProblem(arr2);
       // MaxAreaOfHistogram(arr2);
    //    push1(4);
    //    push1(5);
    //    getmin();
    //    push1(2);
    //    push1(6);
    //    push1(1);
    //    getmin();
    //    pop1();
    //    getmin();
      String str1=new String();
      str1="9+4-3";
      System.out.println(InfixEvaluation(str1));
       


        


    }
    
}

