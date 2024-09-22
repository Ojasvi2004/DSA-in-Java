
public class sortcheck {

    static void sortchecking(int arr[])
    {
        int flag=1;
        int n=arr.length;
    for ( int i = 1; i < n; i++) 
    {
        if (arr[i]>=arr[i-1])
        {
          flag=1;
          continue; 
        }
        else{
            flag=0;
            break;
        }

    }
    if (flag==1)
    {
        System.err.println("Array is sorted");
    }
    else System.err.println("Array is not sorted");
    }
    static void arrin(int n)
    {
        
    }
    public static void main(String[] args) {
        int arr[] ={2,3,9,7,8};
        sortchecking(arr);

        
        
    }
}