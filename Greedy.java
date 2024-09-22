public class Greedy {

    public static int Assign_Cookies(int child[],int cookies[])
    {
        Sorting.BubbleSort(child);
        Sorting.BubbleSort(cookies);
        int i=0;
        for (int j = 0; j < cookies.length; j++) {
            if (child[i]<=cookies[j]) 
            {
                i++;
            }
            else continue;
        }
        return i;

    }
    public static boolean Lemenade_Change(int arr[])
    {
        int five=0;
        int ten=0;
        int twenty=0;
        for (int i = 0; i < arr.length; i++) 
        {
          if (arr[i]==5)
          {
            five=five+1;
          } 
          else if (arr[i]==10) 
          {
           if (five>0) {
            five=five-1;
            ten=ten+1;
           }
           else return false;
          }
          else {
            if (five>0 && ten>0) 
            {
                five=five-1;
                ten=ten-1;
                twenty=twenty+1;
            }
            else if (five>=3) 
            {
                five=five-3;
                twenty=twenty+1;
            }
            else return false;
          }
           
        }
        return true;
    }
    public static boolean Jump_Game(int arr[])
    {
        int maxjump=0;
        for (int i = 0; i < arr.length; i++) 
        {
         if (maxjump<i){ 
            maxjump=i+arr[i];
         return false;}
         else{
                  maxjump=Math.max(maxjump, i+arr[i]);
         }
         
            
         } 
         return true;  
        }
    
        public static void main(String args[])
    {
        //  int arr[]={5,5,5,10,20};
        //  int arr2[]={5,5,10,10,20};
        //  System.out.println(Lemenade_Change(arr));
        //  System.out.println(Lemenade_Change(arr2));

        int arr[]={1,2,4,1,1,0,5};
        System.out.println(Jump_Game(arr));

    }
}
