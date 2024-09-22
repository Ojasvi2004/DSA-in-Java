// import java.util.Collections;
import java.util.HashMap;

public class WinowSlide {
    static int  MaxCardPoint(int arr[],int k)
    {
        int lsum=0;
        int rsum=0;
        int maxsum=0;
        for (int i = 0; i < k; i++) {
            lsum=lsum+arr[i];  
            maxsum=lsum;
        }
       for (int i = k-1; i >= 0; i--) {
           lsum=lsum-arr[i];
           rsum=rsum+arr[arr.length-(k-i)];
           maxsum=Math.max(maxsum, lsum+rsum);
       }
       return maxsum;
}
    static int Longest_Non_Repeating_Substring( String s )
    {
         HashMap<Character,Integer> mp= new HashMap<>();
         int i=0;
         int maxlength=0;
         int length;
         for (int j = 0; j < s.length(); j++) {
           
            Character c=s.charAt(j);
            if (mp.containsKey(c)  && mp.get(c)>=i) 
            {
                i=mp.get(c)+1;
                
            }
            mp.put(c, j);
            length=j-i+1;
            maxlength=Math.max(maxlength, length);
         }
         return maxlength;
    }
      static int Max_Subarray_of_1_afterFLIPPING0_(int arr[],int k)
      {
          int i=0;
          int length=0;
          int maxlength=0;
          int j=0;
          int n0=0;
          while (j<arr.length) 
          {
            if (arr[j]==0 ) 
            {
              n0++;

            }
            while (n0>k) 
            {
              if (arr[i]==0) 
              {
                n0--;
              }
              i++;
            }
            length=j-i+1;
            maxlength=Math.max(maxlength, length);
            j++;
          
          }
            
          return maxlength;
      }
      static int Fruit_in_Basket(int arr[])
      {
        HashMap<Integer,Integer> mp = new HashMap<>();
        int i=0;
        int length=0;
        int maxlength=0;
        for (int j = 0; j < arr.length; j++) 
        {
          // mp.put(arr[j], mp.getOrDefault(arr[j], 0)+1);
         if (mp.containsKey(arr[j])) {
          mp.put(arr[j], mp.get(arr[j])+1);
         }
         else mp.put(arr[j], 1);

          while (mp.size()>2) 
          {
            mp.put(arr[i], mp.get(arr[i])-1);
            
            if (mp.get(arr[i])==0) {
              mp.remove(arr[i]);
            }
            i++;
          }
          length=j-i+1;
          maxlength=Math.max(maxlength, length);
        }
        return maxlength;
      }
    public static int  LongestSubstringWithAtMostKDistinctCharacters(String s,int k)
    {
      int i =0;
      int length,maxlength=0;
      HashMap <Character,Integer> mp=new HashMap<>();
      for (int j = 0; j < s.length(); j++) 
      {
        mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j), 0)+1);
        while (mp.size()>k) 
        {
          mp.put(s.charAt(i),mp.get(s.charAt(i))-1);
          if (mp.get(s.charAt(i))==0) {
            mp.remove(s.charAt(i));
          }
          i++;
        }
        length=j-i+1;
        maxlength=Math.max(maxlength, length);
      }
     return maxlength;
    }
    public static int  Longest_Repeating_Character_Replacement(String s,int k)
    {
      HashMap<Character,Integer> mp= new HashMap<>();
      int i=0;
      int maxfreq=0;
      int maxlength=0;
      int length=0;
      for (int j = 0; j < s.length(); j++) 
      {
        Character c=s.charAt(j);
        // if (mp.containsKey(c) )
        // {
        //  mp.put(c, mp.get(c)+1) ;
        // }
        // else mp.put(c, 1);
        mp.put(c, mp.getOrDefault(c,0)+1);
        maxfreq = Math.max(maxfreq, mp.get(s.charAt(j)));       //this line is more efficient than using collection library
        //  maxfreq=(Collections.max(mp.values()));
        while (j-i+1-maxfreq>k)  //we can use if in place of while to  futurter decrease the T.C
        {
          mp.put(s.charAt(i), mp.get(s.charAt(i))-1);
          if (mp.get(s.charAt(i))==0) {
            mp.remove(s.charAt(i));
          }
          i++;
        }
        // maxfreq=(Collections.max(mp.values()));
        length=j-i+1;
        maxlength=Math.max(maxlength, length);
      }
      return maxlength;
    }
    static int Binary_Subarrays_With_Sum_Help(int arr[],int target)
    {
      int i=0;
      int sum=0;
      int count=0;
      int length=0;
      for (int j = 0; j < arr.length; j++) 
      {
        sum=sum+arr[j];
        while (sum>target) 
        {
          sum=sum-arr[i];                //We can also do this using hashmap
          i++;
        }
        length=j-i+1;
        count=count+length;
      }
      return count;
    }
    static int Binary_Subarrays_With_Sum(int arr[],int target)
    {
      return (Binary_Subarrays_With_Sum_Help( arr, target))-(Binary_Subarrays_With_Sum_Help( arr, target-1));
    }
    static int  Subarray_with_k_different_integers_Help(int arr[],int k)
    {
      HashMap<Integer,Integer> mp = new HashMap<>();
       int i=0;
       int length=0;
       int count=0;
       for (int j = 0; j < arr.length; j++) 
       {
        mp.put(arr[j], mp.getOrDefault(arr[j], 0)+1);
        while (mp.size()>k) 
        {
          mp.put(arr[i], mp.get(arr[i])-1);
          if (mp.get(arr[i])==0) 
          {
            mp.remove(arr[i]);
          }
          i++;
        }
        length=j-i+1;
        count=count+length;
       }
       return count;
    }
    static int  Subarray_with_k_different_integers(int arr[],int k)          //TC--O(2N)
    {  
      if (k==0) {
        return 0;
      }                                                                      //SC--O(N)
      return  Subarray_with_k_different_integers_Help( arr, k)- Subarray_with_k_different_integers_Help(arr, k-1);
    }
    static int   Minimum_Window_Substring(String s, String t)
    {
      HashMap<Character,Integer> mp = new HashMap<>();
      for (int i = 0; i < t.length(); i++) 
      {
        mp.put(t.charAt(i), mp.getOrDefault(t.charAt(i), 0)+1);
      }
      int i=0;
      int count=0;
      for (int j = 0; j < s.length(); j++) 
      {
        if (mp.get(s.charAt(j))>0) 
        {
          count=count+1;
          mp.put(s.charAt(j),mp.get(s.charAt(j))-1 );
        }
        if (count==t.length()) 
        {
          return 0;          //Incomplete
        }
      }
      return i;
    }
    
    public static void main(String[] args) {


    // int arr[]={6,2,3,4,7,2,1,7};
    // int sum=MaxCardPoint(arr, 4);
    // System.out.println(sum);


    // String s="abcbad";
    // int l=Longest_Non_Repeating_Substring(s);
    // System.out.println(l);

    // int a[]={1,1,1,0,0,0,1,1,1,1,0};
    // System.out.println(Max_Subarray_of_1_afterFLIPPING0_(a, 2));


    // int x[]={3,3,3,1,2,1,1,1,2,3,3,4};
    // System.out.println(Fruit_in_Basket(x));


    // String s2="aaabbccd";
    // System.out.println(LongestSubstringWithAtMostKDistinctCharacters(s2, 2));


    // String s="AABABBA";
    // System.out.println(Longest_Repeating_Character_Replacement(s, 2));

    // int c[]={1,0,1,0,1};
    // System.out.println(Binary_Subarrays_With_Sum(c, 2));

    
    int d[]={1, 2, 1, 2, 3};;
    System.out.println(Subarray_with_k_different_integers(d, 2));
    }
}
