public class Sorting {
    static void Swapping(int a[],int i, int j)
    {
        int temp= a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    static int MaxInArray(int a[])
    {
      int max=a[0];
      for (int i = 0; i < a.length; i++) 
      {
        if (a[i]>max) 
        {
          max=a[i];
        }
      }
      return max;
    }
    static void CountSort(int a[])
    {
      int FrequencyArrayIndex= MaxInArray(a);
      int FrequencyArray[]=new int[FrequencyArrayIndex+1];
      for (int i = 0; i < a.length; i++)
      {
         FrequencyArray[a[i]]++;
      }
      int k=0;
      for (int i = 0; i < FrequencyArray.length; i++) 
      {
        for (int j = 0; j < FrequencyArray[i]; j++) 
        {
          a[k++]=i;
        }
      }

    }
    static void InsertionSort(int a[])
    {
        int n=a.length;
        for (int i = 1; i < n; i++) 
        {
          int j=i;
          while (j>0 && a[j]<a[j-1]) 
          {
            Swapping(a, j, j-1);
            j--;
          }

        }
        PrintArray(a);
    }
   static void Merge(int a[],int l,int mid,int r)
   {
    int n1=mid+1-l;
    int n2=r-mid;
    int  left[]= new int[n1];
    int right[]= new int[n2];
    for (int i = 0; i < n1; i++) 
    {
      left[i]=a[l+i];
    }
    for (int i = 0; i < n2; i++) 
    {
      right[i]=a[mid+i+1];
    }
    int i=0;
    int j=0;
    int k=l;
    while (i<n1 && j<n2) 
    {
     if (left[i]>right[j]) 
     {
      a[k++]=right[j++];
     }
     else a[k++]=left[i++];
    }
    while (i<n1) 
    {
      a[k++]=left[i++];
    }
    while (j<n2) 
    {
      a[k++]=right[j++];
    }

   }
   static void MergeSort(int a[],int l,int r)
   {
    if (l>=r) 
    {
      return;
    }
    int mid=(l+r)/2;
    MergeSort(a,l,mid);
    MergeSort(a,mid+1, r);
    Merge(a, l, mid, r);
   }
    static void SectionSort(int a[])
    {
     int n=a.length;
     for (int i = 0; i < n-1; i++) 
     {
        int min;
        min=i;
        for (int j = i+1; j < n; j++) 
        {
            if (a[j]<a[min]) 
            {
              min=j; 
            }
        }
        Swapping(a, i,min );
     }
     PrintArray(a);
    }
    static void BubbleSort(int a[])
    {
        int n=a.length;
        for (int i = 0; i < n-1; i++) 
        {
           for (int j = i+1; j < n; j++) 
           {
            if (a[i]>a[j]) 
            {
               Swapping(a, i, j); 
            }
           } 
        }
        PrintArray(a);

    }
    static int Partition(int a[],int st,int end)
    {
      int pivot=a[0];
      int count=0;
      for (int i = 0; i < a.length; i++) 
      {
        if (pivot>a[i]) 
        {
          count++;
        }
        else continue;
      }
      Swapping(a, 0, count);
      int i=0;
      int j=end;
      while (i<count && j>count)
      {
        while (a[i]<pivot) 
        {
          i++;
        }
        while (a[j]>pivot) 
        {
          j++;
        }
        if (i<count && j>count) 
        {
          Swapping(a, i, j);

        }
      }
      return count;
    }
    static void QuickSort(int a[],int st,int end)
    {
      if (st>end) 
      {
        return;
      }
      int pi=Partition(a, st, end);
      QuickSort(a, st, pi-1);
      QuickSort(a, pi-1, end);

    }
    static void PrintArray(int a[])
    {
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
    }
    public static void main(String []args)
    {
        int []a={2,3,5,7,6,4};
        // BubbleSort(a);
        // System.out.println();
        // SectionSort(a);
        // System.out.println();
        //  InsertionSort(a);
         // System.out.println();
        // System.out.println("By Merge Sort");
        // MergeSort(a, 0, a.length-1);
        // PrintArray(a);
        // QuickSort(a, 0, a.length);
        // PrintArray(a); 
        CountSort(a); 
        PrintArray(a);  

        
        

    }
}
