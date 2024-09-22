public class Binary {
    static int BinarySearch(int a[],int target)
    {
        int n=a.length;
        int st=0;
        int end=n-1;
        while (st<=end) 
        {
            int mid=end+(st-end)/2;
            if (a[mid]==target) 
            {
                return mid;
            } 
            else if (a[mid]<target) 
            {
             st=mid+1;   
            } else 
            {
                end=mid-1;
            }
        }
        return -1;
    }
    static int BinaryByRecurrsion(int a[],int target,int st,int end)
    {
        
      if (st>end) 
      {
        return -1;
      }
      int mid=(end+st)/2;
      if (a[mid]==target) 
      {
        return mid;
      }
      else if (target>a[mid]) 
      {
        return BinaryByRecurrsion(a, target, mid+1, end);
      }else
      return BinaryByRecurrsion(a, target, st, mid-1);
    }
    static int FirstOccurance(int a[],int target)
    {
      int n=a.length;
      int st=0;int end=n-1;
      int fo=0;
      while (st<=end) 
      {
        int mid=(st+end)/2;
        if (a[mid]==target) 
        {
          fo=mid;
          end=mid-1;
        }
        else if (a[mid]>target) 
        {
          end=mid-1;
        }
        else
        st=mid+1;
      }
      return fo;

    }
    static int FirstOccuranceRecurrsion(int a[], int target,int st,int end,int fo)
    {
      int mid=(st+end)/2;
      if (a[mid]==target) 
      {
        fo=mid;
        return FirstOccuranceRecurrsion(a,target,st,mid-1,fo);
      }
      else if(st>=end) 
      {
        return fo;
      }
      else if (a[mid]>target) 
      {
        return FirstOccuranceRecurrsion(a, target,st,mid-1,fo);
      }
      else return  FirstOccuranceRecurrsion(a, target, mid+1, end,fo);
    }
    static int MinInRotatedArray(int a[])
    {
      int st=0;int end=a.length-1;
      int min=0;
      while (st<=end) 
      {
        int mid=end+(st-end)/2;
        if (a[mid]<=a[end]) 
        {
          min=a[mid];
          end=mid-1;
        }
        else st=mid+1;
      }
      return min;
    }
    static int SearchInRotatedArray(int a[],int target)
    {
      int st=0;int end=a.length-1;
      while (st<=end) 
      {
        int mid= end+(st-end)/2;
        if (a[mid]==target)  
        {
          return mid;
        }
        else if (a[mid]<a[end]) 
        {
         if (a[mid]<target && target<=a[end]) 
         {
          st=mid+1;
         }
         else 
         end=mid-1;
        }
        else
        {
          if (a[mid]>target && a[st]<=target) 
          {
            end=mid-1;
          }
          else st=mid+1;
        }
      }
      return -1;
    }
    static int CheckInRotatedArray(int a[]) //Check for target in rotated array
    {
      return -1;
    }
    static boolean SearchInTwo_D_Array(int a[][],int target)
    {
      int n=a[0].length;int m=a.length;
      int st=0;int end=(m*n)-1;
      while (st<=end) 
      {
        int mid= end+(st-end)/2;
        int midel=a[mid/n][mid%m];
        if (midel==target) 
        {
          return true;
        }
        else if (target<midel) 
        {
          end=mid-1;
        }
        else st=mid+1;
      }
      return false;
    }
    //Find Target in Mountain Array
    //Find any of peak elements in mountain array
    public static void main(String args[])
    {
      int a[]={1,2,3,4,6};
       System.out.println(BinarySearch(a, 4));
       System.out.println(BinaryByRecurrsion(a, 4, 0, a.length-1));
       int b[]={1,2,2,3,3,3,4,5,6,7};
       int c[]={5,6,7,8,9,1,2,3,4};
       int d[][]={{1,2,3},{4,5,6},{8,9,10}};
       System.out.println(FirstOccurance(b, 2));
       System.out.println(FirstOccuranceRecurrsion(b, 2, 0, b.length-1,0));
       System.out.println(MinInRotatedArray(c));
       System.out.println(SearchInRotatedArray(c, 1));
       System.out.println(SearchInTwo_D_Array(d, 4));
       System.out.println(SearchInTwo_D_Array(d, 7));

    } 
    
}
