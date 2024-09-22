import java.util.*;
import java.util.LinkedList;

public class trees {
    static   Scanner sc = new Scanner(System.in);
    public static int rootv;
    public static class Node
    {
    int value;
    Node left;
    Node right;
    int height;
    Node(int value)
    {
        this.value=value;
    } 
    Node(int value,Node left,Node right)
    {
        this.value=value;
        this.left=left;
        this.right=right;
    }    
    }
    static Node root= new Node(rootv);
    static void input(Node N) {
        System.out.println("Do you want to enter the left child of node " + N.value + "? (true/false)");
        boolean a = sc.nextBoolean();

        if (a) {
            System.out.println("Enter the value of the left child:");
            int c = sc.nextInt();
            N.left = new Node(c);
            input(N.left);
        }

        System.out.println("Do you want to enter the right child of node " + N.value + "? (true/false)");
        boolean b = sc.nextBoolean();
        
        if (b) {
            System.out.println("Enter the value of the right child:");
            int d = sc.nextInt();
            N.right = new Node(d);
            input(N.right);
        }
    }
    public static int height(Node node)
    {
        if (node==null)
         {
        return -1;    
        }
        else return node.height;
    }
    
    static void display(Node N,int level)
    {
        if (N==null) 
        {
         return;   
        }
        display(N.right,level+1);
        if (level != 0) 
        {
         for (int i = 0; i < level-1; i++) 
         {
           System.out.print("|\t"); 
         }
         System.out.println("|------>"+N.value);   
        }
        else{ System.out.println(N.value);}
        display(N.left, level+1);
    }
    public void insert(int value)
    {
        root=insert(value, root);
    }
    private Node insert(int value,Node N)
    {
        if (N==null) 
        {
            N =new Node(value);
          return N;  
        }
        if (value>N.value) 
        {
        N.left=new Node(value);
        insert( value,N.left);  
        }
        if (value<N.value)
         {
          N.right=new Node(value);
          insert( value,N.right);  
        }
        N.height=Math.max(height(N.left), height(N.right))+1;
        return N;
    }
    static int[] nums={4,3,2,6,8,7,9};
    public   void populate(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }
    static void inorder(Node N)
    {
        if (N==null) 
        {
         return;    
        }
        inorder(N.left);
        System.out.println(N.value);
        inorder(N.right);
    }
    static void preorder(Node N)
    {
        if (N==null) 
        {
        return;    
        }
        System.out.println(N.value);
        preorder(N.left);
        preorder(N.right);
    }
    static void postorder(Node N)
    {
        if (N==null) 
        {
        return;    
        }
        postorder(N.left);
        postorder(N.right);
        System.out.println(N.value);
    }
    static void level_order(Node N)
    {
        if (N==null) 
        {
            System.out.println("Tree is empty");
         return;    
        }
      Queue<Node> q= new LinkedList<>();
      q.add(N);
      q.add(null);
      while (!q.isEmpty()) 
      {
        Node temp = q.remove();
        if (temp==null) 
        {
           System.out.println();
           if (q.isEmpty()) 
           {
           break; 
           }
           else {q.add(null);}

        }
        else {System.out.print(temp.value+" ");
        if (temp.left != null) 
        {
         q.add(temp.left);    
        }
        if (temp.right != null) 
        {
         q.add(temp.right);    
        }
    }

      }

    }
    static void Iterative_preorder(Node N)
    {
        if (N==null) {
            return;
        }
     Stack<Node> s1 = new Stack<>();
     s1.push(N);
     while (!s1.isEmpty()) 
     {
        Node temp = s1.pop();
        System.out.print(temp.value+" ");
        if (temp.right != null) 
        {
           s1.push(temp.right); 
        }
        if (temp.left != null) 
        {
           s1.push(temp.left);    
        }
     }
     
    }
    static void Iterative_postorder1(Node N)
    {
        Stack<Node> s1=new Stack<>();
        Stack<Node> s2=new Stack<>();
        s1.push(N);
        while (!s1.isEmpty()) 
        {
            Node temp=s1.pop();
            if (temp.left!=null) 
            {
                s1.push(temp.left);
            }
            if (temp.right != null) 
            {
                s1.push(temp.right);    
            }
            s2.add(temp);
        }
        while (!s2.isEmpty()) {
            System.out.print(s2.pop().value+" ");
        }
    }
    static class Pair {
    Node node;
    int num;
    Pair(Node n,int a){
        node=n;
        num=a;
    }
        
    }
    static void all_in_one(Node N)
    {
        Stack<Pair> s1= new Stack<Pair>();
        List<Integer> pre=new ArrayList<>();
        List<   Integer> in =new ArrayList<>();
        List<Integer> post= new ArrayList<>();
        s1.push(new Pair(N, 1));
        if (N==null) {
            return;
        }
        while (!s1.isEmpty()) 
        {
          Pair it= s1.pop();
          if (it.num==1) 
          {
            pre.add(it.node.value);
            it.num++;
            s1.push(it);
            if (it.node.left != null) 
            {
                s1.push(new Pair(it.node.left,1));
            }
          }
          else if (it.num==2) 
          {
          in.add(it.node.value);
         it.num++;
         s1.push(it);
         if (it.node.right!=null) 
         {
         s1.push(new Pair(it.node.right,1));   
         }
          } 
          else 
          {
            post.add(it.node.value);
          } 
        }
        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);

    }
    static int Max_Depth(Node N)
    {
        if (N==null) 
        {
           return 0; 
        }
       int lh=Max_Depth(N.left);
       int rt=Max_Depth(N.right);
        return 1+Math.max(lh, rt);
    }
    static int Balance_Checker(Node N)
    {
    {
        if (N==null) 
        {
           return 0; 
        }
       int lh=Balance_Checker(N.left);
       if (lh==-1) {
        return -1;
       }
       int rt=Balance_Checker(N.right);
       if( rt==-1) return -1;
       if(Math.abs(lh-rt)>1) return -1;
        return 1+Math.max(lh, rt);
    }
}
    static boolean isBalanced(Node N)
    {
         int a= Balance_Checker(N);
         if (a==-1) {
            return false;
         }
         else return true;
    }
    static int diameter1(Node N)
    {
        if (N==null) {
            return 0;
        }
        int left=diameter1(N.left);
        int right=diameter1(N.right);
        int lh=Max_Depth(N.left);              // N^2
        int rh=Max_Depth(N.right);
        int curr=lh+rh+1;
        return Math.max(curr,Math.max(left, right));

    }
    static int dia=0;
    static int Diameter(Node N)
    {
        if (N==null) {
            return 0;
        }
                                                           //O(N)
        int left=Diameter(N.left);
        int right= Diameter(N.right);
        dia=Math.max(dia, right+left+1);
        return 1+Math.max(left, right);
    }
    static int sum=0;
    static int Max_Path_Sum(Node N)
    {
        if (N==null) {
            return 0;
        }
        int rh=Max_Path_Sum(N.right);
        int lh=Max_Path_Sum(N.left);
        sum=Math.max(sum, lh+rh+N.value);
        return N.value+Math.max(rh, lh);
    }
    static boolean isSame(Node N1,Node N2)
    {
        if (N1==null && N2==null )
        {
           return true; 
        }
        if (N1==null || N2==null) {
            return false;
        }
        if (N1.value!=N2.value) {
            return false;
        }
         boolean a=isSame(N1.left, N2.left);
         boolean b=isSame(N1.right, N2.right);
         return a&&b;
    }
    static void ZigZag(Node N)
    {
        int flag=0;
        Queue<Node> q1= new LinkedList<>();
        if (N==null) {
            return ;}
        q1.add(N);
   while (!q1.isEmpty()) { 
    Node temp=q1.remove();
    System.out.print(temp.value);
    if (flag==0) {
        if (temp.left != null)  q1.add(temp.left);
        if (temp.right != null) q1.add(temp.right);
        flag=flag+1;
    }
    else if (flag==1) {
        if (temp.right!=null) q1.add(temp.right);
        if (temp.left != null)  q1.add(temp.left);
        flag=flag-1;
    }
   
    }
}
static void BoundryTraversal(Node N)
{
    Queue<Integer> q1 = new LinkedList<>();
    Stack<Node> s1= new Stack<>();         //Incomplete
    while (N.left!=null) {
        q1.add(N.value);
        N=N.left;
    }
   while (!s1.isEmpty()) 
   {
    if (N.left!=null) {
        s1.push(N.left);
    }
    if (N.right!=null) {
        s1.push(N.right);
    }
    if (N.right==null && N.left==null) {
        
    }
   }

}
static void Vertical_Level_Traversal(Node N)                    //Incomplete
{
return;
}
static class Pair1{
int hd;
Node n;
Pair1(Node n,int hd)
{
this.hd=hd;
this.n=n;
}
    
}
static ArrayList<Integer> Top_View(Node N)
{
    Queue<Pair1> q1=new LinkedList<>();
     ArrayList<Integer> a1= new ArrayList<Integer>();
    Map<Integer,Integer> mp = new TreeMap<>();
    q1.add(new Pair1(N, 0));
    if (N==null) {
        return a1;
    }
    while (!q1.isEmpty()) {
        Pair1 temp=q1.remove();
       mp.putIfAbsent(temp.hd, temp.n.value);
        if (temp.n.left != null) {
            q1.add(new Pair1(temp.n.left,temp.hd-1));
        }
        if (temp.n.right != null) {
            q1.add(new Pair1(temp.n.right, temp.hd+1));
        }
    }
    for (Integer i : mp.keySet()) 
    {
     a1.add(mp.get(i)) ;
    }
    return a1;
}
static ArrayList<Integer> Bottom_View(Node N)
{
    ArrayList<Integer> a2= new ArrayList<>();
    Queue<Pair1> q2= new LinkedList<>();
    Map<Integer,Integer> mp2= new TreeMap<>();
    q2.add(new Pair1(N, 0));
    if (N==null) {
        return a2;
    }
    while (!q2.isEmpty()) {
        Pair1 temp= q2.remove();
        mp2.put(temp.hd, temp.n.value);
     if (temp.n.left != null) {
        q2.add(new Pair1(temp.n.left,temp.hd-1));
     }
     if (temp.n.right != null) {
        q2.add(new Pair1(temp.n.right,temp.hd+1));
     }
    }
    for (Integer i : mp2.keySet()) {
        a2.add(mp2.get(i));
    }
    return a2;
}
public static Queue<Integer> q3= new LinkedList<>();
static void Right_view(Node N,int level)
{

    if (N==null) {
        return;
    }
    if (level==q3.size()) {
        q3.add(N.value);
    }
        Right_view(N.right,level+1);
    

        Right_view(N.left,level+1);
}
static boolean Symmetric_Tree_Check(Node N)
{
    Node temp1=N.left;
    Node temp2=N.right;
    if (temp1==null && temp2 == null) {
        return true;
    }
    if (temp1.value != temp2.value) {
        return false;
    }
    return(Symmetric_Tree_Check(temp1)&& Symmetric_Tree_Check(temp2));
    
}
static ArrayList<Integer> l1= new ArrayList<Integer>();
static void Root_to_Node_Path(Node N,Node target,ArrayList<Integer> l1)
{
    if (N== null) return;
    l1.add(N.value);
    if (N==target) {
        System.out.println(l1);
    }
    
     else{   
        Root_to_Node_Path(N.left, target, l1);

        Root_to_Node_Path(N.right, target, l1);
     }
    
    l1.remove(l1.size()-1);

}
static void Lowest_common_Ancestor(Node N,Node a,Node b)
{
    return;
}
static class Pair2{
    int id;
    Node n;
    Pair2(Node n,int id)
    {
    this.id=id;
    this.n=n;
    }}
static int Max_Width(Node N)
{
    Queue<Pair2> q= new LinkedList<>();
    q.add(new Pair2(N, 0));
    int wd=0;
    while (!q.isEmpty())
    {
      if (N==null) {
        return 0;
      } 
      int size=q.size();
      int first=q.peek().id;
      int last =q.peek().id;
    for (int i = 0; i < size; i++) {
        Pair2 temp=q.poll();
        last=temp.id;
        if (temp.n.left != null) {
            q.add(new Pair2(temp.n.left,temp.id*2+1)); 
          } 
          if (temp.n.right != null) {
            q.add(new Pair2(temp.n.right,temp.id*2+2)); 
          }
    }
    wd=Math.max(wd, last-first+1);
    }

    return wd;
}
public static void mark_parents(Queue<Node> qt,Node N,HashMap<Node,Node> mp1)
{
qt.add(N);
while (!qt.isEmpty()) 
{
    Node temp=qt.poll();
    if (temp.left != null) {
        qt.add(temp.left);
        mp1.put(temp.left, temp);
    }
    if (temp.right !=null) 
    {
    qt.add(temp.right);
    mp1.put(temp.right, temp);    
    }
}
}
   public static List<Integer> getNodesAtDistance(Node N,Node target,int step)
   {
      HashMap<Node, Node> parent_info= new HashMap<>();
      Queue<Node> qn= new LinkedList<>();
      mark_parents(qn, N, parent_info);
      Queue<Node> qn2 = new LinkedList<>();
      HashMap<Node,Boolean> mp2=new HashMap<>();
      qn2.offer(target);
      mp2.put(target, true);
      int curr=0;
      
      while (!qn2.isEmpty()) 
      {
        if (curr==step) {
            break;
        }
        int size = qn2.size();
        for (int i = 0; i < size; i++) 
        {
            Node tempo=qn2.poll();
           if (tempo.left != null && mp2.containsKey(tempo.left)==false) {
            qn2.add(tempo.left);
            mp2.put(tempo.left, true);
           } 
           if (tempo.right != null && mp2.containsKey(tempo.right)==false) {
            qn2.add(tempo.right);
            mp2.put(tempo.right, true);
           }
           if (parent_info.get(tempo) != null && mp2.containsKey(parent_info.get(tempo))==false) {
            qn2.add(parent_info.get(tempo));
            mp2.put(parent_info.get(tempo), true);
           }
        }
        curr++;
        

      }
      List<Integer> result= new ArrayList<>();
      while (!qn2.isEmpty()) {
        Node temp=qn2.remove();
        result.add(temp.value);
      }
      return result;
   }
   static int leftheight(Node N)
   {
    int lh=0;
    while (N.left !=null) {
        N=N.left;
        lh++;
    }
    return lh;
   } 
   static int rightheight(Node N)
   {
    int rh=0;
    while (N.right != null) {
        N=N.right;
        rh++;
    }
    return rh;
   }
   static int NodeCount(Node N)
   {
    
    if (N==null) {
        return 0;
    }
    int rh=rightheight(N);
    int lh=leftheight(N);
    if (rh==lh) {
        return ((2<<(lh))-1);
    }
    else return NodeCount(N.left)+NodeCount(N.right)+1;
   }
   static HashMap<Integer,Integer> inmap=new HashMap<>();
    static Node BinaryTreeConstruction(int [] inorder,int[] preorder)
   {
    for (int i = 0; i < inorder.length; i++) {
       inmap.put(inorder[i],i); 
    }
    return BuildTreeHelper(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
   
   }
   static Node BuildTreeHelper(int preorder[],int prestart,int preend,int inorder[],int instart,int inend)
   {
    if (prestart > preend || instart > inend) {
        return null;
    }
    Node temp= new Node(preorder[prestart]);
    int temp_index=inmap.get(temp.value);
    int leftTreeSize=temp_index-instart;;

    temp.left=BuildTreeHelper(preorder,prestart+1, prestart+leftTreeSize, inorder, instart, temp_index-1);
    temp.right=BuildTreeHelper(preorder,prestart+leftTreeSize+1, preend, inorder, temp_index+1, inend);
    return temp;
   }
   static Node BuildTree2(int[]inorder,int[] postorder)
   {
    HashMap<Integer,Integer> inMap2=new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
        inMap2.put(inorder[i], i);
    }
    return BuildTreeHelper2(inorder,0,inorder.length-1,postorder,0,postorder.length-1,inMap2);
   }
    static Node BuildTreeHelper2(int inorder[],int inStart,int inEnd,int postorder[],int postStart,int postEnd,HashMap<Integer,Integer>inMap2)
    {
   if (inStart>inEnd || postStart>postEnd) {
    return null;
   }
   Node temp=new Node(postorder[postEnd]);
   int temp_index=inMap2.get(temp.value);
   int leftTreeSize=temp_index-inStart;
   temp.left=BuildTreeHelper2(inorder, inStart, temp_index-1, postorder, postStart,postStart+ leftTreeSize-1, inMap2);
   temp.right=BuildTreeHelper2(inorder, temp_index+1, inEnd, postorder, postStart+leftTreeSize, postEnd-1, inMap2);
   return temp;

    }
    static String Serialization1(Node N)
    {
        Queue<Node> qr= new LinkedList<>();
        qr.add(N);
        qr.add(null);
        StringBuilder s1= new StringBuilder();
        while (!qr.isEmpty())                             //Cannot create a unique tree
        {
        Node temp=qr.poll();

        if (temp==null) {
          s1.append("#"); 
          if (qr.isEmpty()) {
            break;
          }
          else qr.add(null); 
          
        }
        else
        {
        s1.append(Integer.toString(temp.value));
        if (temp.left != null) {
            qr.add(temp.left);
        }
        if (temp.right != null) {   
            qr.add(temp.right);
        }
        }}
        return s1.toString();
    }

    static String Serialization2(Node N)
    {
        StringBuilder s1= new StringBuilder();
    Queue<Node> qr= new LinkedList<>();
    qr.add(N);
    while (!qr.isEmpty()) 
    {
        Node temp=qr.poll();
        if (temp==null) {
            s1.append('#');
            s1.append(" ");
            continue;
        }
        else{
            s1.append(Integer.toString(temp.value));
            s1.append(" ");
            if (temp.left==null) {
                qr.add(null);
            }
            else qr.add(temp.left);
            if (temp.right==null) {
                qr.add(null);
            }
            else qr.add(temp.right);
        }
    }
    return s1.toString();

    
    }
 public static Node De_Serialize(String str)
 {
    if (str=="") {
       return null; 
    }
Queue<Node> qr= new LinkedList<>();
String[] sta= str.split(" ");
Node root=new Node(Integer.parseInt(sta[0]));
qr.add(root);
for (int i = 1; i < sta.length; i++) 
{
    Node temp=  qr.poll();
    
    if (!sta[i].equals("#")) 
    {
        temp.left=new Node(Integer.parseInt(sta[i]));
        qr.add(temp.left);
    }
    if (!sta[++i].equals("#")) 
    {
       temp.right= new Node(Integer.parseInt(sta[i])); 
       qr.add(temp.right);
    }
}
return root;
 }

 static ArrayList<Integer> Morris_Inorder(Node N)
 {
    ArrayList<Integer> Inorder= new ArrayList<>();
    Node curr=N;
    while (curr != null) {
       if (curr.left == null) {                                             //T.C=O(N)      
        Inorder.add(curr.value);                                            // S.C=O(N)
       } 
      else{
        Node temp=curr.left;
        while (temp.right != null && temp.right != curr) 
        {
            temp=temp.right;
        }
        if (temp.right==null) {
            temp.right=curr;
            curr=curr.left;                                              //Logic Revision
        }
        else{
            temp.right=null;
            Inorder.add(curr.value);
            curr=curr.right;
        }

      }
    }
    return Inorder;
 }
 static void Flatten_BTree(Node N)
 {
 return;
 }
 static Boolean SEARCH_IN_BST(Node N,int target) 
 {
    Node temp=N;
    while (temp !=null && temp.value!=target) 
    {
      if (target>temp.value) {
        temp=temp.right;
      } 
      else temp=temp.left; 
    }
    if (temp==null) {
        return false;
    }
   else return true;
 }
 static int ceiling_in_BST(Node N,int target)
 {
    Node temp=N;
    int ceil=-1;
    while (temp != null) 
    {
        if (target<temp.value) {
            ceil=temp.value;
            temp=temp.left;
        }
        else if (target>temp.value) {
            ceil=temp.value;
            temp=temp.right;
        }
        else{ return temp.value;}
    }
    return ceil;
 }
 static int floor_in_BST(Node N)
 {
    return -1;
 }
 static Node insert_in_BST(Node N,int key)
 {
    Node temp=N;
    while (temp != null) 
    {
      if (key>temp.value) {
        if (temp.right !=null) {
            temp=temp.right;
        }
        else {temp.right=new Node(key); 
            return N;}
        
      }  
      else if (key<temp.value) {
        if (temp.left != null) {
            temp=temp.left;
        }
        else {temp.left=new Node(key);
            return N;}
        
      }
    }
   
return N;

 }
 static Node FindLast_Right_Node(Node N)
 {
    Node temp=N;
    while (temp.right != null) {
        temp= temp.right;
    }
    return temp;
 }
static void delete_node_in_BST(Node N,int target)
{   Node temp=N;
    Node curr=N;
    while (temp != null) 
    {
     if (target<temp.value && temp.left != null) 
     {
     curr=temp;
      temp=temp.left;
     }
     else if (target>temp.value && temp.right != null) {
       curr=temp;
       temp=temp.right; 
     } 
     else if (target==temp.value) 
     {
        if (temp.left ==null && temp.value>curr.value) {
            curr.right=temp.right;
        }
        if (temp.right ==null && temp.value>curr.value) {
            curr.right=temp.left;
        }
        if (temp.left ==null && temp.value<curr.value) {
            curr.left=temp.right;
        }
        if (temp.right ==null && temp.value<curr.value) {
            curr.left=temp.left;
        }
        if (temp.right==null && temp.left==null) {
            if (temp.value<curr.value) {
                curr.left=null;
            }
            else curr.right=null;
        }
        else{

        }
     }  
    }

    return;
}

/**
 * NodesAtDistance
 */

    // static void Iterative_inorder(Node N)
    // {
    //     if (N==null) 
    //     {
    //     return;    
    //     }
    //     Stack<Node> s3= new Stack<>();
    //     s3.push(N);
    //     while (!s3.isEmpty())
    //     {
    //         Node temp=s3.peek();
    //         if (temp.left != null) 
    //         {
    //             s3.push(temp.left);
    //             continue;
    //         }
    //         if (temp.left==null) 
    //         {
    //           System.out.print(temp.value+" ");  
    //           s3.pop();
    //           return;
    //         }
    //         System.out.print(temp.value+" ");
    //         if (temp.right != null) 
    //         {
    //             s3.push(temp.right);       
    //         }
    //     }
    // }

    public static void main(String[] args)
    {
    //  System.out.println("Enter the root value:");
    //  rootv=sc.nextInt();
     
    //   input(root);
    //   display(root, 0);
    //  sc.close();
    //  display(root, rootv); 
     
    // }
   

    
    
    // Node j = new Node(10, null, null);
    // Node i= new Node(9, null, null);
    // Node h=new Node(8, i, j);
    // Node d = new Node(4, null, null);
    // Node e = new Node(5, null, null);
    // Node f = new Node(6, null, null);
    // Node g = new Node(7, null, null);
    
    // Node c=new Node(3, f, g);
    // Node b = new Node(2, d, e);

    //  Node a =new Node(1, b, c);
    
    //   display(a, 0);




     
    // Node q = new Node(4, null, null);
    // Node r = new Node(5, null, null);
    
    // Node n=new Node(13, q, r);
    // Node m = new Node(2, null, null);
    // Node l =new Node(1, m, n);
    //  preorder(a);
    //  inorder(a);
    // //  level_order(a);
    //  all_in_one(a);
    // System.out.println(Max_Depth(a));
    // System.out.println(Balance_Checker(a));
    // System.out.println(diameter1(a));
    // Diameter(a);
    // System.out.println(dia);
    // Max_Path_Sum(a);
    // System.out.println(sum);
    // Node y= new Node(2, null, null);
    // Node z= new Node(3, null, null);
    // Node x=new Node(1, y, z);
    // Node b= new Node(2, null, null);
    // Node c= new Node(3, null, null);
    // Node a=new Node(1, b, c);
    // System.out.println(isSame(x, a));
//    display(a, 0);
//    System.out.println(Top_View(a));
//    System.out.println(Bottom_View(a));
//    Right_view(a, 0);
//    System.out.println(q3);
//    System.out.println(Symmetric_Tree_Check(a));
//    Root_to_Node_Path(a, f,l1);
//    System.out.println(Max_Width(a));
//    List<Integer> l1= new ArrayList<>();
//    l1=getNodesAtDistance(a, b, 3);
//    System.out.println(l1);
//    System.out.println(NodeCount(a));
//    System.out.println(rightheight(a));
// int pre[]={1,2,4,5,3,6,7};
// int in[]={4,2,5,1,6,3,7};
// int post[]={4,5,2,6,7,3,1};
//  display(BinaryTreeConstruction(in, pre), 0);
 // display(BuildTree2(in, post),0);
 // System.out.println(Serialization2(l));
 // display(De_Serialize(Serialization2(l)), 0);
 Node root = new Node(10);
         root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(2);
        root.left.right = new Node(7);
        root.right.right = new Node(20);
       //  display(root, 0);
    // boolean t= SEARCH_IN_BST(root, 20);
    // System.out.println(t);
    // System.out.println(ceiling_in_BST(root, 5));
    // System.out.println();
    //  insert_in_BST(root, 13);
    // display(root, 0);
    

    // Insert values into the BST
    
    insert_in_BST(root, 13);
 
   //  delete_node_in_BST(root, 13);
    
    display(root, 0);
    

   
} 
}
