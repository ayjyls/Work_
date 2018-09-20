import java.util.*;
public class Work_Game
{
    public static void main(String[] args)
    {
         int player1=0,player2=0,player3=0;//三个玩家
         int r=0;//......................存放随机数
         int score1=0,score2=0,score3=0;//...三个玩家的得分
         Random rand=new Random();
         Scanner reader=new Scanner(System.in);
         int m=5;
         for(int i=0;i<m;i++)
         {
            r=rand.nextInt(10);
            System.out.println("随机数已生成。");
            System.out.print("请1号玩家猜数字:");
            player1=reader.nextInt();
            System.out.print("请2号玩家猜数字:");
            player2=reader.nextInt();
            System.out.print("请3号玩家猜数字:");
            player3=reader.nextInt();
            if(player1==r)
                {    System.out.println("1号玩家猜对;");
                     score1=score1+1;
                }
                 else
                {    System.out.println("1号玩家猜错;");
                     score1=score1-1;
                }
            if(player2==r)
                {    System.out.println("2号玩家猜对;");
                     score2=score2+1;
                }
                 else
                {    System.out.println("2号玩家猜错;");
                     score2=score2-1;
                }
            if(player3==r)
                {    System.out.println("3号玩家猜对;");
                     score3=score3+1;
                }
                 else
                {    System.out.println("3号玩家猜错;");
                     score3=score3-1;
                }
           }
           System.out.println("1号玩家得分为:"+score1+";2号玩家得分为:"+score2+";3号玩家得分为:"+score3);
}
}
            
                     
            

       