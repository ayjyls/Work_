public class Work_1
{
public static void main(String[] args)
{
   int N;
   int M=0;
   for(N=99;N>M;N--)
   {
      if(N>2)
      System.out.println(N+"bottles of beer on the wall."+(N-1)+"bottles of beer on the wall."); 
      else if(N==2)
      System.out.println(N+"bottles of beer on the wall."+(N-1)+"bottle of beer on the wall.");
      else
      System.out.println(N+"bottle of beer on the wall.No more bottles of beer on the wall.");}
}
}