public class OOPs {
    public static class Students
    {
       String Name;
       int Roll_Number;
       double Percentage;
    }
    public static void main(String[] args)
    {
       Students S1 = new Students();
       S1.Name="Rahul";
       S1.Roll_Number=21;
       S1.Percentage=95.4;
       System.out.println(S1.Name);
       System.out.println(S1.Percentage);
       Students S2 = new Students();
       S2.Name="Mayank";
       S2.Roll_Number=22;
       S2.Percentage=93.4;
       System.out.println(S2.Name);
       System.out.println(S2.Percentage);
    }
    
}
