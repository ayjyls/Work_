import java.util.*;
public class Work_Game
{
    public static void main(String[] args)
    {
         int player1=0,player2=0,player3=0;//�������
         int r=0;//......................��������
         int score1=0,score2=0,score3=0;//...������ҵĵ÷�
         Random rand=new Random();
         Scanner reader=new Scanner(System.in);
         int m=5;
         for(int i=0;i<m;i++)
         {
            r=rand.nextInt(10);
            System.out.println("����������ɡ�");
            System.out.print("��1����Ҳ�����:");
            player1=reader.nextInt();
            System.out.print("��2����Ҳ�����:");
            player2=reader.nextInt();
            System.out.print("��3����Ҳ�����:");
            player3=reader.nextInt();
            if(player1==r)
                {    System.out.println("1����Ҳ¶�;");
                     score1=score1+1;
                }
                 else
                {    System.out.println("1����Ҳ´�;");
                     score1=score1-1;
                }
            if(player2==r)
                {    System.out.println("2����Ҳ¶�;");
                     score2=score2+1;
                }
                 else
                {    System.out.println("2����Ҳ´�;");
                     score2=score2-1;
                }
            if(player3==r)
                {    System.out.println("3����Ҳ¶�;");
                     score3=score3+1;
                }
                 else
                {    System.out.println("3����Ҳ´�;");
                     score3=score3-1;
                }
           }
           System.out.println("1����ҵ÷�Ϊ:"+score1+";2����ҵ÷�Ϊ:"+score2+";3����ҵ÷�Ϊ:"+score3);
}
}
            
                     
            

       