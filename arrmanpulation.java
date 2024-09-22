public class arrmanpulation {
    static int unique(int arr[],int x)
    {
        int n=arr.length;
        for (int i = 0; i < n; i++)
        {
           for (int j=i+1;j<n;j++) 
           {
            if (arr[i]==arr[j]) 
            {
                arr[i]=-1;
                arr[j]=-1;
            }
           }
        }
        for (int i = 0; i < n; i++) 
        {
            if (arr[i]!= -1) 
            {
                x=arr[i];
            }
        }
        return x;
    }
    static int secondlarge(int arr[],int y)
    {
        int n=arr.length;
        int max=0;
        for (int i = 0; i < n; i++) 
        {
           if (arr[i]>arr[0]) 
           {
            max=arr[i];
           } 
        }
        return max;
    }
    public static void main(String[] args) {
        int arr[]={2,3,4,5,4,3,2};
        int num=unique(arr, 0);
        int smax=secondlarge(arr,0);
        System.err.println(smax);
        System.err.println(num);
        
    }
    
}
