import java.util.Scanner;
public class LEC16 {
    static void printarray(int arr[])
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    static void swapinarray(int arr[],int i ,int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    static void reverseArray2(int arr[])
    {
        int i=0,j=arr.length-1;
        while (i<j) {
            swapinarray(arr, i, j);
            i++;
            j--;
        }
        printarray(arr);
    }
    static int max(int arr[])
    {
        int max=arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max<arr[i]) {
                max=arr[i];
            }
        }
       
        return max;
    }
    static void reverseArray(int arr[])
    {
        int n=arr.length;
        int j=0;
        int ans[];
        ans=new int [n];
        for (int i = n-1; i >=0; i--) {
            ans[j++]=arr[i];
        }
        printarray(ans);
      
    }

    static int min(int arr[])
    {
        int min=arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min=arr[i];
            }
        }
        return min;
    }
    static void rotate(int arr[],int k)
    { int n=arr.length;
        k=k%n;
        int ans[] = new int[n];
        int j=0;
        for (int i =n-k; i < n; i++)
        {
          ans[j++]=arr[i];  
        }
        for (int i = 0; i < n-k; i++) {
            ans[j++]=arr[i];
        }
        printarray(ans);

    }
    static int secmax(int arr[])
    {
        int maxs=max(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==maxs) {
                arr[i]=Integer.MIN_VALUE;

            }
        }
         maxs=max(arr);
        return maxs;
    }
    static int FirstRepeatingNumber(int arr[])
    {
        int n=arr.length;
        int num=0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (arr[i]==arr[j]) 
                {
                 num=arr[i]; 
                }
            }
        }
        return num;
    }
    public static void main(String[] args) {
        int n;
        int [] a;
        Scanner sc=new Scanner(System.in);
        System.out.println("Input the sze of your array");
        n=sc.nextInt();
        System.out.println("Enter the elements:");
        a=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextInt();
            
        }

        int maxa=max(a);
        int mina=min(a);
        int smaxa=secmax(a);
        int frn=FirstRepeatingNumber(a);
        System.out.println("Maximum is "+maxa);
        System.out.println("Minimum is "+mina);
        System.out.println("Second Maximum is "+smaxa);
        System.out.println("First Repeating Number is: "+frn);
        rotate(a, 3);
        reverseArray2(a);
        sc.close();

        
    }
}