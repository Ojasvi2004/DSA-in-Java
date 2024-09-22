import java.util.ArrayList;

public class Recurrsion {
    static String RemoveOccurance(String s,int i,char a)
    {
        if (i==s.length()) {
            return "";
        }
         String smallans= RemoveOccurance(s, i+1, a);
         char currchar=s.charAt(i);
         if (currchar != a) 
         {
             return currchar+smallans;
         }
         return smallans; 

    }
    static boolean StringPalindrome2(String s,int l,int r)       
    {
       if (l>=r) 
       {
        return true;
       }
       return (s.charAt(r)==s.charAt(l) && StringPalindrome2(s, l+1, r-1));

    }
    static String Subsets(String s)               //H.W
    {
       return s;
    }

    static String StringReversalWithSubstring(String s)
    {
        if (s.length()==0) 
        {
           return ""; 
        }
        char currchar=s.charAt(0);
        String smallans=StringReversalWithSubstring(s.substring(1));
        return smallans+currchar;

    }
    static boolean StringPalindrome(String s)
    {
        String s2=StringReversalWithSubstring(s);
        if (s.equals(s2)) 
        {
            return true;
        }
        else return false;
    }
    static String StringReversal(String s,int i)
    {
        if (i==s.length()) {
            return "";
        }
        String smallans= StringReversal(s, i+1);
        return smallans+ s.charAt(i);
    }
    static String RemoveOccuranceBySubstring(String s,char a)
    {
       
        if (s.length()==0) {
            return "";
        } 
         String smallans= RemoveOccuranceBySubstring(s.substring(1),a);
         char currchar=s.charAt(0);
        if (currchar != a) 
        {
            return currchar+smallans;
        }
         return smallans;
    }   
    static  void func1(int n)
    {
        if (n==1) 
        {
            System.out.println(1);
            return;
        }
        System.out.println(n);
        func1(n-1);
       
    }
    static ArrayList<Integer> Allindices(int a[],int target,int i)          //BUGGED
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if (a[i]==target)
        {
            ans.add(i);
        }
        if (i>=a.length) 
        {
         return new ArrayList<Integer>();   
        }
        ArrayList<Integer> smallans= Allindices(a, target, i+1);
        ans.addAll(smallans);
         return ans;

    }
    static int IndexOfTarget(int a[],int target, int i)
    {
        if (a[i]==target) 
        {
         return i;   
        }
        if (i==a.length-1) 
        {
            System.out.println("Element does not exist");
            return -1;
        }
        return IndexOfTarget(a, target, i+1);

    }
    static boolean LinearSearch(int a[],int target,int i)
    {
        if (a[i]==target) 
        {
           return true; 
        }
        if (i==a.length-1) 
        {
           return false; 
        }
        return LinearSearch(a, target, i+1);
        
    }
    static int SumOfArray(int a[],int i)
    {
        int sum=0;
        if (i==a.length-1) 
        {
          return a[i];   
        }
         sum =a[i] + SumOfArray(a, i+1) ;
         return sum;

    }
    static void PrintArray(int a[],int i)
    {
        if (i==a.length) {
            return;     
        }
        System.out.println(a[i]);
        PrintArray(a, i+1);

    }
    static int MAXVAL(int a[],int i)
    {
        if (i==a.length-1) 
        {
            return a[i];
        }
        int smallans=MAXVAL(a, i+1);
        return Math.max(smallans, a[i]);
    }
    static int fibonacci(int a)
    {
        if (a==1 || a==2) 
        {
            return 1;
        }
        if (a==0) 
        {
            return 0;
        }
        return fibonacci(a-1) + fibonacci(a-2);
        
    }
    static int DigitSum(int a)
    {
        if (a<10) 
        {
            return a;
        }
        int sum= (a%10) + DigitSum(a/10);
        return sum;
    }
    static int Pow(int p,int q)
    {
        if(q==0)
        {
            return 1;
        }
        int val= p * Pow(p, q-1);
        return val;

    }
    static void multiples(int num, int k)
    {
        if (k==1) 
        {
          System.out.println(num); 
          return ;
        }
        multiples(num, k-1);
        System.out.println(num *k);
        
    }
    static int factorial(int a)
    {
        if (a==1) 
        {
         return 1;   
        }
        return a *factorial(a-1);

    }
    static int GCD(int x, int y)
    {
     if (y==0) {
        return x;
     }
     return GCD(y,x%y);
    }
    static int series(int n)
    {
        if (n==0) 
        {
         return 0;   
        }
        if (n%2 == 0) 
        {
           return -n + series(n-1) ;
           
        }
        return n+series(n-1);

    }
    public static void main(String[ ] args )
    {
     /* func1(5);
     int fac=factorial(5);
     System.out.println(fac);
     int fibb=fibonacci(6);
     System.out.println(fibb);
     int a=DigitSum(151);
     System.out.println(a);
      int power=Pow(2, 5);
      System.out.println(power);
      multiples(3, 5);
      int b=series(5);
      System.out.println(b);
      int x=GCD(15, 24);
      System.out.println(x);     */
      int ab[]={1,2,3,3,5,6};
      PrintArray(ab,0); 
      int bc=MAXVAL(ab, 0);
      System.out.println(bc);
      int cd=SumOfArray(ab, 0);
      System.out.println(cd);
      Boolean AC=LinearSearch(ab, 4, 0);
      System.out.println(AC);
      int ad=IndexOfTarget(ab, 4, 0);
      System.out.println(ad);
      /* ArrayList<Integer> L=new ArrayList<>();
        L=Allindices( ab,3,0);
      for (Integer i : L)
      {
        System.out.println(i);
      } */
      String name="Ojasvi";
      String college="wallaw";
      char first='v';
      System.out.println(RemoveOccurance(name, 0, first));
      System.out.println(RemoveOccuranceBySubstring(name, first));
      System.out.println(StringReversal(name, 0));
      System.out.println(StringReversalWithSubstring(name));
      System.out.println(StringPalindrome(college));
      System.out.println(StringPalindrome(name));
      System.out.println(StringPalindrome2(college, 0,5));
      System.out.println(StringPalindrome2(name, 0,name.length()-1));

    }
    
    
}
