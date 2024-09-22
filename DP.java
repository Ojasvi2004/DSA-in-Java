import java.util.ArrayList;

public class DP {
   

    public  class Fibonacci {
    
           static int[] DP;
            static int initialize(int a)
           {
               DP=new int[a+1];
               for (int i = 0; i < DP.length; i++) {
                DP[i]=-1;
               }
               return fibo(a);
           }
      
           private static int fibo(int a)
           {
               if (a<=1) {
                   return a;
               }
               if (DP[a] != -1) {
                   return DP[a];
               }
               else {
                DP[a]=fibo(a-1)+fibo(a-2);
                return DP[a];
               }
           }
           private static int Iteration_fibo(int a)
           {
            int DP[] =new int[a+1];
            DP[0]=0;
            DP[1]=1;                                        //This reduces the space complexity as we are not using any call stack space
            for (int i = 2; i < DP.length; i++) {
                DP[i]=DP[i-1]+DP[i-2];                       //we can optise it furthe it bu usif 2 variables instead of DP array as DP[i-1],DP[i-2]
            }
            return DP[a];
           }
          
       
    }
    public static int Stairs_Climbing(int n)
    {
        if (n<=1) {
            return n;
        }
        if (n==2) {
            return 2;
        }
        else{
            return Stairs_Climbing(n-1)+Stairs_Climbing(n-2);  
        }
    }
    
    public static int Frog_Jump(int path[],int ind)
    {   
       if (ind==0) {
        return 0;
       }
       if (ind>1) {
        int single_jump=Frog_Jump(path, ind-1)+Math.abs(path[ind]-path[ind-1]);
       int double_step=Frog_Jump(path, ind-2)+Math.abs(path[ind]-path[ind-2]);
       return Math.min(single_jump, double_step);
       }
       else{
        int single_jump=Frog_Jump(path, ind-1)+Math.abs(path[ind]-path[ind-1]);
        return single_jump;
       }            
    }
    private static int initialize2(int nums[])
    {
        int DP[] =new int[nums.length];
        for (int i = 0; i < DP.length; i++) {
            DP[i]=-1;
        }
        return Frog_Jump2(nums,DP, DP.length-1);
    }
    static int Frog_Jump2(int path[],int DP[],int ind)
    {
     if (ind==0) {
        return 0;
     }
     if (DP[ind] != -1) {
        return DP[ind];
     }
     if (ind>1) {
        int single_jump=Frog_Jump2(path,DP, ind-1)+Math.abs(path[ind]-path[ind-1]);
        int double_step=Frog_Jump2(path,DP, ind-2)+Math.abs(path[ind]-path[ind-2]);
         DP[ind]=Math.min(single_jump, double_step);
         return DP[ind];

     }
     else{
        int single_jump=Frog_Jump2(path,DP, ind-1)+Math.abs(path[ind]-path[ind-1]);
        DP[ind]= single_jump;
        return DP[ind];
     }
    }
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		int sum=0;
       int f=0;int g=0;
		for ( int i=0; i < nums.size(); i++) {
			for (int j = i+2; j < nums.size(); j++) {
				if (sum<(nums.get(i)+nums.get(j))) {                         //BruteForce
                                                            //only take pairs into account does not take the larger sunsequences
					sum=(nums.get(i)+nums.get(j));
                    i=f;
                    j=g;
                
					
				}
				else continue;
			}
		}
       
		return sum;
	}
    public static void Print_Subsequences(ArrayList<Integer> ar,int nums[],int ind)
    {
    //  if (ind>=nums.length) {
    //     System.err.println(ar);
    //     return;
    //  }
    //  ar.add( nums[ind]);  
    //  Print_Subsequences(ar, nums, ind+1);
    //  ar.remove(nums[ind]);
    //  Print_Subsequences(ar, nums, ind+1);

    // if (ind>=nums.length) 
    // {
    //     return;
    // }
    // ar.add(nums[ind]);
    // System.out.println(ar);


    }



   public static int maximumNonAdjacentSum2(int nums2[],int ind) 
    {
	if (ind>=nums2.length) {
        return 0;
    }
    int include=maximumNonAdjacentSum2( nums2, ind+2)+nums2[ind];
    
    int exclude=maximumNonAdjacentSum2( nums2, ind+1);

        return Math.max(include, exclude);
	}


   public static int maximumNonAdjacentSum3_DP_Initialize(int nums[])
    { 
        int DP[]=new int[nums.length+1];                        
        for (int i = 0; i < DP.length; i++) {
            DP[i]=-1;
        }
        return maximumNonAdjacentSum3_DP(nums, 0, DP);
    }
    public static int maximumNonAdjacentSum3_DP(int nums[],int ind,int DP[])
    {
        if (ind>=nums.length) {
            return 0;
        }
        if (DP[ind] != -1) {
            return DP[ind];
        }
        int include=maximumNonAdjacentSum3_DP(nums, ind+2,DP)+nums[ind];
        int exclude=maximumNonAdjacentSum3_DP(nums, ind+1,DP);
        return DP[ind]=Math.max(include, exclude);
    }
    
    public static int initialize_ninja_training(int nums[][],int days)
   {
     int DP[][]=new int[days][4];
     for (int i = 0; i < days; i++) {
        for (int j = 0; j < 3; j++) {
            DP[i][j]=-1;
        }
     }  
         return ninjaTraining_Help(nums, days, 0, -1,DP);
   }

    public static int ninjaTraining_Help(int nums[][],int days,int ind,int last,int DP[][])
    {
        if (ind>=days) {
            return 0;
        }
        if (DP[ind][last+1] != -1) {
            return DP[ind][last+1];
        }
       
      int max=0;
      for (int i = 0; i < 3; i++) {
        if (last != i) {
            int score=nums[ind][i]+ninjaTraining_Help(nums,days, ind+1, i,DP);
            max= Math.max(score, max);
            }  
      }
       
        DP[ind][last+1]=max;
        return max;
      
    }
    public static int ninjaTraining(int n, int points[][]) {
            return initialize_ninja_training(points, n);
       
    }

    public static void Sum_of_Subsequences(int[]nums,ArrayList<Integer> arr,int ind,int sum,int last)
    {
       if (ind==nums.length) {
        if (sum==last) {
            System.out.println(arr);
        }
         return;
       }
       
        arr.add(nums[ind]);
        last=last+nums[ind];
        Sum_of_Subsequences(nums, arr, ind+1, sum, last);
        arr.remove(arr.size()-1);
        last=last-nums[ind];
        Sum_of_Subsequences(nums, arr, ind+1, sum, last);


    }

    
    public static void main(String[] args) {
        // System.out.println(Fibonacci.initialize(6));
        // System.out.println(Fibonacci.Iteration_fibo(3));

        // System.out.println(Stairs_Climbing(4));
        // int path[]={0,2,5,6,7};
        // System.out.println(initialize2(path));
        // System.out.println(Frog_Jump(path, path.length-1));
         ArrayList<Integer> a1= new ArrayList<>();
    //     a1.add(9);
    //     a1.add(2);
    //     a1.add(4);
    //     a1.add(8);
    //    // a1.add(10);
    //     // System.out.println(maximumNonAdjacentSum(a1));
        // int []a={9,2,4,8,2,5};
        // System.out.println(maximumNonAdjacentSum2(a, 0));
        // System.out.println(maximumNonAdjacentSum(a1));
        // System.out.println(maximumNonAdjacentSum3_DP_Initialize(a));


        // int nums[][]={{1,2,5},{3,1,1},{6,3,3} };
        // System.out.println(ninjaTraining(3, nums));
        int nums[]={1,2,1};

        Sum_of_Subsequences(nums, a1, 0, 2, 0);


        
    }
}
