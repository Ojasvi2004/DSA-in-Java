import java.util.Stack;

public class Temp{
    public static void NextGreaterElement(int a[]) {
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[a.length];
        for (int i = a.length - 2; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() < a[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }
            st.push(a[i]);
        }
        // Print the result (you can replace this with your own display logic)
        for (int val : ans) {
            System.out.print(val + " ");
        }
    }
    static void NextGreaterElement2(int a[])
  {
    Stack<Integer> st2=new Stack<Integer>();
    int n=a.length;
    int ans[]=new int[n];
    for (int i = n-2; i>0; i--) 
    {
       while ( st2.size()>0 &&st2.peek()<a[i] ) 
       {
        st2.pop();
       }
       if (st2.isEmpty())
       {
        ans[i]= -1;
        st2.push(a[i+1]);
       } 
        else {ans[i]=st2.peek();}
       st2.push(a[i]);
    }
    Sorting.PrintArray(ans);

  }

    public static void main(String[] args) {
        int[] arr = {2,3,5,4,7,6,9};
        NextGreaterElement(arr);
        NextGreaterElement2(arr);
    }
}

