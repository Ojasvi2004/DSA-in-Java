import java.util.Scanner;;
public class Lec20 {
    static void MySwapMatrix(int a[][],int i,int j,int n,int m)
    {
        int temp= a[i][j];
        a[i][j]=a[n][m];
        a[n][m]=temp;
    }
    static void PascalTriangle(int r)
    {
        int ans[][]= new int [r][];
        for (int i = 0; i < r; i++) 
        {
            ans[i]=new int [i+1];
           ans[i][0]=ans[i][i]=1;
        for (int j = 1; j < i; j++) 
        {
            ans[i][j]=ans[i-1][j]+ ans[i-1][j-1];
        }
        
    }

    }
    static void MatrixPrintMethod(int a[][],int r1,int c1)
    {
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                System.out.print(a[i][j]+" ");
            }
        System.out.println();
        }
    }
    static void MatrixAdd(int a[][],int b[][],int r1,int c1,int r2,int c2)
    {
        int ans[][]= new int [r1][c1]; 
    if (r1==r2 && c1==c2) {
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
               ans[i][j] = a[i][j] + b[i][j]; 
            }
        }
    MatrixPrintMethod(ans, r1, c1);
    }
    }
    static void MatrixMultiplication(int a[][],int b[][],int r1,int c1,int r2,int c2)
    {
        int ans[][]= new int [r1][c2];
    if (c1==r2) {
        for (int i = 0; i <r1 ; i++) {
            for (int j = 0; j < c2; j++) {
                int sum=0;
                for (int j2 = 0; j2 < c1; j2++) {
                   sum =sum+ a[i][j2]+b[j2][j];
                }
                ans[i][j]=sum;
            }
        }
        MatrixPrintMethod(ans, r1, c1);
    }
    else System.out.println("Matrix Cannot be Multiplied");

    }
    static void TransposeInplace(int a[][],int r1,int c1)
    {
        for (int i = 0; i < r1; i++) 
        {
           for (int j = i; j < c1; j++) 
           {
            MySwapMatrix(a, i, j, j, i);
           } 
        }
        MatrixPrintMethod(a, c1, r1);
    }
    static void TransposeMatrix(int a[][],int r1,int c1)
    {
        int ans[][]= new int[c1][r1];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                ans[j][i]=a[i][j];
            }
        }
        MatrixPrintMethod(ans, r1, c1);    }
    public static void main(String[] args) 
    {Scanner sc =new Scanner(System.in);
        /* int r1,c1,r2,c2,n;
         System.out.println("Enter the number of rows in first matrix:");
        r1=sc.nextInt();
        System.out.println("Enter the number of columns in first matrix:");
        c1=sc.nextInt();
        System.out.println("Enter the number of rows in second matrix:");
        r2=sc.nextInt();
        System.out.println("Enter the number of columns in second matrix:");
        c2=sc.nextInt();
        int a[][]=new int [r1][c1];
        int b[][]= new int [r2][c2];
        System.out.println("Enter the elements for first Matrix:");
        for (int i = 0; i < r1; i++)
        {
           for (int j = 0; j < c1; j++) 
           {
            a[i][j]=sc.nextInt();
           } 
        }
        System.out.println("Enter the elements for second Matrix:");
        for (int i = 0; i < r2; i++)
        {
           for (int j = 0; j < c2; j++) 
           {
            b[i][j]=sc.nextInt();
           } 
        }
        System.out.println("Enter 1 for Matrix Multiplication: ");
        System.out.println("Enter 2 for Matrix Addition: ");
        System.out.println("Enter 1 for Matrix Transpose: ");
        n=sc.nextInt();
        if (n==1) 
        {
          MatrixMultiplication(a, b, r1, c1, r2, c2);  
        }
        if (n==2) 
        {
           MatrixAdd(a, b, r1, c1, r2, c2); 
        }
        if (n==3) 
        {
          TransposeMatrix(a, r1, c1); 
          TransposeInplace(b, r2, c2); 
        }  */
        int b;
        System.out.println("Enter the number of rows for pascal triangle:");
        b= sc.nextInt();
        PascalTriangle(b);

        



       sc.close(); 
    }
}
