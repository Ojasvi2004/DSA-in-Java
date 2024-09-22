import java.util.Stack;

public class Stacks2 {
     public static void InfixEvaluation(String str)
    {
        Stack<Integer> val = new Stack<Integer>();
        Stack<Character> op = new Stack<Character>();
    for (int i = 0; i < str.length(); i++) {
        char ch= str.charAt(i);
        int ascii=(int)ch;
        if (ascii<=57 && ascii>=48) 
        {
         val.push(ascii-48);
        }
        else if (op.size()==0) {
            op.push(ch);
        }
        else{
            if (ch=='+' || ch=='-') {
                int v2= val.pop();
                int v1= val.pop();
                if (op.peek()=='-') {  val.push(v1+v2); }
                if (op.peek()=='+') {  val.push(v1-v2); }
                if (op.peek()=='*') {  val.push(v1*v2); }
                if (op.peek()=='/') {  val.push(v1/v2); }
                op.pop();
                op.push(ch);

            }
            if (ch=='*' || ch=='/') {
                if (op.peek()=='*' || op.peek()=='/') {
                int v2=val.pop();
                int v1=val.pop();
                if (op.peek()=='*') {  val.push(v1*v2); }
                if (op.peek()=='/') {  val.push(v1/v2); }
                op.pop();
                op.push(ch);
                }
                else op.push(ch);
            }
            
        }
        }
    
    while (val.size()>1) {
                int v2= val.pop();
                int v1= val.pop();
                if (op.peek()=='-') {  val.push(v1+v2); }
                if (op.peek()=='+') {  val.push(v1-v2); }
                if (op.peek()=='*') {  val.push(v1*v2); }
                if (op.peek()=='/') {  val.push(v1/v2); }
                op.pop();
    }
    System.out.println(val.peek());
    }



    
    public static void main(String[] args) {
        String str="10-11+2";
       InfixEvaluation(str);
    }
}
