package Test;
import java.util.*;
	abstract class Transport
	{
		public String Type;//交通工具类型
		public int arriveTime;//到车站或机场时间
		public int returnTime;//从车站或机场返回时间
		public int ticketTime;//取票时间
		public int savecTime;//安检时间
		public int waitTime;//候车时间
		public double Speed;//车速
		public double Price;//单价
		public int Distance;//距离
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
			System.out.println("汽车所需时间为:"+totalTime+"分钟");
			System.out.println("所需价格为:"+Price+"元");
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
			System.out.println("高铁所需时间为:"+totalTime+"分钟");
			System.out.println("所需价格为:"+Price+"元");
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
			System.out.println("飞机所需时间为:"+totalTime+"分钟");
			System.out.println("所需价格为:"+Price+"元");
		}
	}
public class test {	
	public static void main(String[] args)
	{
		int distance;
		String destination;//目的地
		String departure;//出发地
		Scanner dis=new Scanner(System.in);
		Scanner des=new Scanner(System.in);
		Scanner dep=new Scanner(System.in);
		System.out.println("目的地:");
		destination=des.nextLine();
		System.out.println("出发地:");
		departure=dep.nextLine();
		System.out.println("两地之间距离(千米):");
		distance=dis.nextInt();
		Transport car=new Car(distance);
		Transport subway=new Subway(distance);
		Transport plant=new Plant(distance);
		System.out.println("从"+departure+"到达"+destination+"所需时间如下");
		car.show();
		subway.show();
		plant.show();
	}
}
