//filename:Work_2.java
import java.util.*;
class Car
{
    public String CarType;//����
    public int tank;//������
    public int oilcon;//�ͺ�
}
public class Work_2
{
    public static void main(String[] args)
    {
         Car c1,c2,c3;
         c1=new Car();
         c2=new Car();
         c3=new Car();
         Scanner reader=new Scanner(System.in);
         System.out.println("������һ�ų��ĳ���,���������ͺ�");
         c1.CarType=reader.nextLine();
         c1.tank=reader.nextInt();
         c1.oilcon=reader.nextInt();
         reader.nextLine();//..........................nextInt����nextLine��ʱ�����ڽ����м�Ļس���
         System.out.println("��������ų��ĳ���,���������ͺ�");
         c2.CarType=reader.nextLine();
         c2.tank=reader.nextInt();
         c2.oilcon=reader.nextInt();
         reader.nextLine();//..........................nextInt����nextLine��ʱ�����ڽ����м�Ļس���
         System.out.println("���������ų��ĳ���,���������ͺ�");
         c3.CarType=reader.nextLine();
         c3.tank=reader.nextInt();
         c3.oilcon=reader.nextInt();
         String[] List;//..............................���崢�泵�͵�����
         List=new String[3];
         System.out.println("��������������");//.......�����ʹ�������
         reader.nextLine();//..........................nextInt����nextLine��ʱ�����ڽ����м�Ļس���
         List[0]=reader.nextLine();
         List[1]=reader.nextLine();
         List[2]=reader.nextLine();
         System.out.println("�������ĳ��ͣ����������ͺķֱ�Ϊ:");
         int m=3;
         for(int i=0;i<3;i++)
         {
             if(List[i].equals(c1.CarType))
               {System.out.println(c1.CarType+","+c1.tank+","+c1.oilcon);}
             else if(List[i].equals(c2.CarType))
               {System.out.println(c2.CarType+","+c2.tank+","+c2.oilcon);}
             else if(List[i].equals(c3.CarType))
               {System.out.println(c3.CarType+","+c3.tank+","+c3.oilcon);}
             else 
                 {System.out.println("�������!");}
          }
}}                    
        