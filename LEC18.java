import java.util.Scanner;
public class LEC18 {
    static void frequencycount(int arr[])
    {
        int i=0;
        int frequency[]=new int [10];
        while (i<arr.length) {
           frequency[arr[i]] =frequency[arr[i]]+1;
           i++;
        }
        for (int j = 0; j < frequency.length; j++) {
            if (frequency[j] > 0) {
                System.out.println("There is "+frequency[j]+" frequecy of element "+j);
            }
        }
       
    }
    static void SUMinRANGE(int arr[])
    {
        Scanner sc=new Scanner(System.in);
        int sum=0;
       prefixSum(arr);
        System.out.println("Enter the number of queries:");
        int queries=sc.nextInt();
        while (queries>0) 
        {
        System.out.println( "Enter the range" );
        System.out.println("From");
        int l=sc.nextInt();
        System.out.println("To");
        int r=sc.nextInt();
        sum=arr[r]-arr[l-1];
        System.out.println("Sum is "+sum); 
        queries--;
        }
       sc.close();

    }
    static void prefixSum(int arr[])
    {
        for (int i = 1; i < arr.length; i++) 
        {
            arr[i]=arr[i]+arr[i-1];
        }
    }
    static void swapinarray(int arr[],int a,int b)
    {
      int temp= arr[a];
     arr[a] =arr[b];
      arr[b]=temp;
    }
    static void printarray(int arr[])
    {
        int n=arr.length;
        int i=0;
      while (i<n) {
        System.out.println(arr[i]);
        i++;
      }
    }
    //two pointer concept
    static int zerosort(int arr[])
    {  
        int zeroes=0;  
     for (int i = 0; i < arr.length; i++) {
        if (arr[i]==0) 
        {
            zeroes++;
        }
     }
     int i=0;
     while ( i<arr.length) 
     {
        if (i<zeroes) {
            arr[i]=0;
        i++;
        }
        else arr[i]=1;
        i++;
     }

     return 0;
    }
    static void zeroesort2(int arr[])
    {
        int n=arr.length;
        int i=0;
        int j=n-1;
        while (i<j) 
        {
           if (arr[i]==1 && arr[j]==0) 
           {
            swapinarray(arr, i, j);
            i++;
            j--;
           } 
         if (arr[i]==0) 
         {
            i++;
         }
         if (arr[j]==1) {
            j--;
         }
            

        }
    }
   

    public static void main(String[] args) {
       /*  int array[]={1,0,1,1,0,1,0,1,0};
        zerosort(array);
        printarray(array);
    
        int array2[]={1,0,1,1,0,1,0,1,0,0};
        zeroesort2(array2);
        printarray(array2); */
        int array3[]={2,3,4,3,2,3,4,5,4,3,2,3,4,};
        // frequencycount(array3);
        prefixSum(array3);
        printarray(array3);
        SUMinRANGE(array3 );

    }
}
