package test;
import java.util.*;
import java.sql.*;
import com.microsoft.sqlserver.jdbc.*;
public class Operation {
	static class Staff
	{
		protected String Name;
		protected int Salary;
		protected int birthMonth;
		Staff(){};
		Staff(String Name,int Salary,int birthMonth)
		{
			this.Name=Name;
			this.Salary=Salary;
			this.birthMonth=birthMonth;
		}
		public String getName()
		{
			return Name;
		}
		public void setName(String Name)
		{
			this.Name=Name;
		}
		public int getSalary()
		{
			return Salary;
		}
		public void setSalary(int Salary)
		{
			this.Salary=Salary;
		}
		public int getBirthMonth()
		{
			return birthMonth;
		}
		public void setBirthMonth(int birthMonth)
		{
			this.birthMonth=birthMonth;
		}
	}
	static class Manager extends Staff
	{
		private int Bonus;
		Manager(String Name,int Salary,int birthMonth,int Bonus)
		{
			this.Name=Name;
			this.Salary=Salary;
			this.birthMonth=birthMonth;
			this.Bonus=Bonus;
		}
		public int getBonus()
		{
			return Bonus; 
		}
		public void setBonus(int Bonus)
		{
			this.Bonus=Bonus;
		}
	}
	static class Shareholder extends Staff
	{
		private int Bonus;
		Shareholder(String Name,int Bonus)
		{
			this.Name=Name;
			this.Bonus=Bonus;
		}
		public int getBonus()
		{
			return Bonus; 
		}
		public void setBonus(int Bonus)
		{
			this.Bonus=Bonus;
		}
	}
private static Connection getConn()
{
	String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url="jdbc:sqlserver://localhost:1433;databaseName = master";
	String username="sa";
	String password="123456";
	Connection conn=null;
	try {
		Class.forName(driver);
		conn=(Connection) DriverManager.getConnection(url,username,password);
	}
	catch(ClassNotFoundException e) 
	{
		e.printStackTrace();
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	return conn;
}


private static int insertS(Staff staff)
{
	Connection conn = getConn();
	int i=0;
	String sql="insert into staffs (Name,Salary,birthMonth) values(?,?,?)";
	PreparedStatement pstmt;
	try
	{
		pstmt = (PreparedStatement)conn.prepareStatement(sql);
		pstmt.setString(1,staff.getName());
		pstmt.setInt(2,staff.getSalary());
		pstmt.setInt(3,staff.getBirthMonth());
		i=pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	return i;
}
private static int insertM(Manager manager)
{
	Connection conn = getConn();
	int i=0;
	String sql="insert into managers (Name,Salary,birthMonth,bonus) values(?,?,?,?)";
	PreparedStatement pstmt;
	try
	{
		pstmt = (PreparedStatement)conn.prepareStatement(sql);
		pstmt.setString(1,manager.getName());
		pstmt.setInt(2,manager.getSalary());
		pstmt.setInt(3,manager.getBirthMonth());
		pstmt.setInt(4,manager.getBonus());
		i=pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	return i;
}
private static int insertSh(Shareholder shareholder)
{
	Connection conn = getConn();
	int i=0;
	String sql="insert into shareholders (Name,bonus) values(?,?)";
	PreparedStatement pstmt;
	try
	{
		pstmt = (PreparedStatement)conn.prepareStatement(sql);
		pstmt.setString(1,shareholder.getName());
		pstmt.setInt(2,shareholder.getSalary());
		pstmt.setInt(3,shareholder.getBirthMonth());
		i=pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	return i;
}
private static int updateS(Staff staff)
{
	Connection conn=getConn();
	int i=0;
	String sql="update staffs set Salary='"+staff.getSalary()+"',birthMonth='"+staff.getBirthMonth()+"'where Name='"+staff.getName()+"'";
	PreparedStatement pstmt;
	try {
		pstmt =(PreparedStatement)conn.prepareStatement(sql);
		i=pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return i;
}
private static int updateM(Manager manager)
{
	Connection conn=getConn();
	int i=0;
	String sql="update managers set Salary='"+manager.getSalary()+"',birthMonth='"+manager.getBirthMonth()+"',Bonus='"+manager.getBonus()+"'where Name='"+manager.getName()+"'";
	PreparedStatement pstmt;
	try {
		pstmt =(PreparedStatement)conn.prepareStatement(sql);
		i=pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return i;
}
private static int updateSh(Shareholder shareholder)
{
	Connection conn=getConn();
	int i=0;
	String sql="update shareholder set Bonus='"+shareholder.getBonus()+"'where Name='"+shareholder.getName()+"'";
	PreparedStatement pstmt;
	try {
		pstmt =(PreparedStatement)conn.prepareStatement(sql);
		i=pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return i;
}
private static Integer getAllS()
{
	Connection conn =getConn();
	String sql="select*from staffs";
	PreparedStatement pstmt;
	try {
		pstmt=(PreparedStatement)conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		int col =rs.getMetaData().getColumnCount();
		System.out.println("================================");
		while(rs.next())
		{
			for(int i=1;i<=col;i++)
			{
				System.out.print(rs.getString(i)+"\t");
				if((i==2)&&(rs.getString(i).length()<8))
				{
					System.out.print("\t");
				}
			}
			System.out.println("");
		}
		System.out.println("================================");
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return null;
}
private static Integer getAllM()
{
	Connection conn =getConn();
	String sql="select*from managers";
	PreparedStatement pstmt;
	try {
		pstmt=(PreparedStatement)conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		int col =rs.getMetaData().getColumnCount();
		System.out.println("======================================");
		while(rs.next())
		{
			for(int i=1;i<=col;i++)
			{
				System.out.print(rs.getString(i)+"\t");
				if((i==2)&&(rs.getString(i).length()<8))
				{
					System.out.print("\t");
				}
			}
			System.out.println("");
		}
		System.out.println("======================================");
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return null;
}
private static Integer getAllSh()
{
	Connection conn =getConn();
	String sql="select*from shareholders";
	PreparedStatement pstmt;
	try {
		pstmt=(PreparedStatement)conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		int col =rs.getMetaData().getColumnCount();
		System.out.println("================");
		while(rs.next())
		{
			for(int i=1;i<=col;i++)
			{
				System.out.print(rs.getString(i)+"\t");
				if((i==2)&&(rs.getString(i).length()<8))
				{
					System.out.print("\t");
				}
			}
			System.out.println("");
		}
		System.out.println("================");
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return null;
}
private static int deleteS(String name)
{
	Connection conn = getConn();
	int i=0;
	String sql="delete from staffs where Name='"+name+"'";
	PreparedStatement pstmt;
	try {
		pstmt = (PreparedStatement)conn.prepareStatement(sql);
		i= pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return i;
}
private static int deleteM(String name)
{
	Connection conn = getConn();
	int i=0;
	String sql="delete from managers where Name='"+name+"'";
	PreparedStatement pstmt;
	try {
		pstmt = (PreparedStatement)conn.prepareStatement(sql);
		i= pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return i;
}
private static int deleteSh(String name)
{
	Connection conn = getConn();
	int i=0;
	String sql="delete from shareholders where Name='"+name+"'";
	PreparedStatement pstmt;
	try {
		pstmt = (PreparedStatement)conn.prepareStatement(sql);
		i= pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return i;
}
public static void main(String[] args) 
{
	System.out.println("职员信息表");
	Operation.getAllS();
	System.out.println("\n");
	System.out.println("经理信息表");
	Operation.getAllM();
	System.out.println("\n");
	System.out.println("股东信息表");
	Operation.getAllSh();
	System.out.println("\n");
	int ch1;
	Scanner type1=new Scanner(System.in);
	int ch2;
	Scanner type2=new Scanner(System.in);
	String name;
	Scanner n=new Scanner(System.in);
	int bonus;
	Scanner b=new Scanner(System.in);
	int salary;
	Scanner s=new Scanner(System.in);
	int month;
	Scanner m=new Scanner(System.in);
	int gain;//公司年总收入
	Scanner g=new Scanner(System.in);
	System.out.println("请输入公司年总收入:");
	gain=g.nextInt();
	
	
	System.out.println("是否要输入信息:\n1.是\n2.否");
	ch1=type1.nextInt();
	while(ch1==1) {
	System.out.println("请输入类型："+"1.职员"+"\n"+"2.经理"+"\n"+"3.股东");
	ch2=type2.nextInt();
	switch(ch2)
	{
	case 1:
	{
		System.out.println("请输入职员名字:");
		name=n.nextLine();
		System.out.println("请输入职员工资:");
		salary=s.nextInt();
		System.out.println("请输入职员出生月份:");
		month=m.nextInt();
		Operation.insertS(new Staff(name,salary,month));
	}break;
	case 2:
	{
		System.out.println("请输入经理名字:");
		name=n.nextLine();
		System.out.println("请输入经理工资:");
		salary=s.nextInt();
		System.out.println("请输入经理出生月份:");
		month=m.nextInt();
		System.out.println("请输入经理月奖金:");
		bonus=b.nextInt();
		Operation.insertM(new Manager(name,salary,month,bonus));
	}break;
	case 3:
	{
		System.out.println("请输入股东名字:");
		name=n.nextLine();
		System.out.println("请输入股东分红:");
		bonus=b.nextInt();
		Operation.insertSh(new Shareholder(name,bonus));
	}break;
	default:
		System.out.println("输入错误");
	}
	System.out.println("是否继续输入信息:\n1.是\n2.否");
	ch1=type1.nextInt();
	}
	System.out.println("职员信息表");
	System.out.println("================================");
	System.out.println("姓名        工资                  出生月");
	Operation.getAllS();
	System.out.println("\n");
	System.out.println("经理信息表");
	System.out.println("======================================");
	System.out.println("姓名        工资                  出生月        月奖金 ");
	Operation.getAllM();
	System.out.println("\n");
	System.out.println("股东信息表");
	System.out.println("================");
	System.out.println("姓名        分红");
	Operation.getAllSh();
}
}