package Test;
import java.util.*;
	abstract class Transport
	{
		public String Type;//��ͨ��������
		public int arriveTime;//����վ�����ʱ��
		public int returnTime;//�ӳ�վ���������ʱ��
		public int ticketTime;//ȡƱʱ��
		public int savecTime;//����ʱ��
		public int waitTime;//��ʱ��
		public double Speed;//����
		public double Price;//����
		public int Distance;//����
		abstract void count();
		public void show()
		{
			count();
		}
	}
	class Car extends Transport
	{
		public Car(int distance)
		{
			this.Type="car";
			this.arriveTime=30;
			this.returnTime=30;
			this.ticketTime=5;
			this.savecTime=1;
			this.waitTime=10;
			this.Speed=1;
			this.Price=0;
			this.Distance=distance;
		}
		void count()
		{
			int totalTime;
			totalTime=(int) Math.rint(arriveTime+returnTime+ticketTime+savecTime+waitTime+Distance/Speed);
			Price=Distance*0.32;
			System.out.println("��������ʱ��Ϊ:"+totalTime+"����");
			System.out.println("����۸�Ϊ:"+Price+"Ԫ");
		}
	}
	class Subway extends Transport
	{
		public Subway(int distance)
		{
			this.Type="subway";
			this.arriveTime=30;
			this.returnTime=30;
			this.ticketTime=10;
			this.savecTime=5;
			this.waitTime=30;
			this.Speed=6;
			this.Price=0;
			this.Distance=distance;
		}
		void count()
		{
			int totalTime;
			totalTime=(int) Math.rint(arriveTime+returnTime+ticketTime+savecTime+waitTime+Distance/Speed);
			Price=Distance*0.45;
			System.out.println("��������ʱ��Ϊ:"+totalTime+"����");
			System.out.println("����۸�Ϊ:"+Price+"Ԫ");
		}
	}
	class Plant extends Transport
	{
		public Plant(int distance)
		{
			this.Type="plant";
			this.arriveTime=60;
			this.returnTime=60;
			this.ticketTime=20;
			this.savecTime=10;
			this.waitTime=60;
			this.Speed=150;
			this.Price=0;
			this.Distance=distance;
		}
		void count()
		{
			int totalTime;
			totalTime=(int) Math.rint(arriveTime+returnTime+ticketTime+savecTime+waitTime+Distance/Speed);
			Price=Distance*0.75;
			System.out.println("�ɻ�����ʱ��Ϊ:"+totalTime+"����");
			System.out.println("����۸�Ϊ:"+Price+"Ԫ");
		}
	}
public class test {	
	public static void main(String[] args)
	{
		int distance;
		String destination;//Ŀ�ĵ�
		String departure;//������
		Scanner dis=new Scanner(System.in);
		Scanner des=new Scanner(System.in);
		Scanner dep=new Scanner(System.in);
		System.out.println("Ŀ�ĵ�:");
		destination=des.nextLine();
		System.out.println("������:");
		departure=dep.nextLine();
		System.out.println("����֮�����(ǧ��):");
		distance=dis.nextInt();
		Transport car=new Car(distance);
		Transport subway=new Subway(distance);
		Transport plant=new Plant(distance);
		System.out.println("��"+departure+"����"+destination+"����ʱ������");
		car.show();
		subway.show();
		plant.show();
	}
}
