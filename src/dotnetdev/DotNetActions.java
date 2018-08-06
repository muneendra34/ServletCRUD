package dotnetdev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DotNetActions {

	static
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException cnfe)
		{
			System.out.println(cnfe);
		}
	}
	
	static int si = 0;
	static int sj = 0;
	static int sk = 0;
	
	public int goDotNetInsert() throws SQLException
	{	
		Connection con = null;
		PreparedStatement ps= null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "muni";
		String password = "admin";
		
		try
		{
		con = DriverManager.getConnection(url,username,password);
		boolean b = false;
		Checks chks = new Checks();
		b = chks.tableCheck("DOTNETDEV");
		if( b == true)
		{
			String sql = "insert into dotnetdev values(?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1,DotNetDevBean.getFname());
			ps.setString(2,DotNetDevBean.getLname());
			ps.setString(3,DotNetDevBean.getPswd());
			ps.setString(4,DotNetDevBean.getRepswd());
			ps.setString(5,DotNetDevBean.getAdd());
			ps.setString(6,DotNetDevBean.getPhone());
			ps.setString(7,DotNetDevBean.getDesignation());
			
			si = ps.executeUpdate(); 
			if(si != 0)
			{
				return si;
			}
		}
		else
		{
			DotNetActions dna = new DotNetActions();
			dna.goDotNetCreate();
		}
		}
		catch(Exception e)
		{	
			System.out.println(e);
			
		}
		finally
		{
		try
		{
			if(ps != null)
			{
				ps.close();
				ps = null;
			}
		}
		catch(SQLException sq1)
		{
			System.out.println(sq1);
		}
		
		try
		{
			if(con != null)
			{
				con.close();
				con = null;
			}
		}
		catch(SQLException sq2)
		{
			System.out.println(sq2);
		}
		}
		return si;
	}
	
	public void goDotNetCreate()
	{
		Connection con = null;
		PreparedStatement ps = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "muni";
		String password = "admin";
		try
		{
		con = DriverManager.getConnection(url,username,password);
		String sql = "create table dotnetdev (fname varchar2(20) unique,lname varchar2(20),password varchar2(20),repassword varchar(20),address varchar2(30),phone varchar2(15),designation varchar2(20))";
		ps = con.prepareStatement(sql);
		int i = ps.executeUpdate();
		if( i == 0 )
		{
			goDotNetInsert();
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
		try
		{
			if(ps != null)
			{
				ps.close();
				ps = null;
			}
		}
		catch(SQLException sq1)
		{
			System.out.println(sq1);
		}
		
		try
		{
			if(con != null)
			{
				con.close();
				con = null;
			}
		}
		catch(SQLException sq2)
		{
			System.out.println(sq2);
		}
		}
	}
	
	public ResultSet goGetDetails(String fnam)
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "muni";
		String password = "admin";
		try
		{
		con = DriverManager.getConnection(url,username,password);
		String sql = "select * from dotnetdev where fname=?";
		ps = con.prepareStatement(sql);
		ps.setString(1, fnam);
		rs = ps.executeQuery(); 
		if( rs != null)
		{	
			return rs;
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			return rs;
	}
	
	public int goDotNetUpdate(String fnam, String lnam, String pw, String rpw, String ad, String ph, String des,String ofnam)
	{	
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "muni";
		String password = "admin";
		try
		{
		con = DriverManager.getConnection(url,username,password);
		String sql = "update dotnetdev set fname=?,lname=?,password=?,repassword=?,address=?,phone=?,designation=? where fname=?";
		ps = con.prepareStatement(sql);
		ps.setString(1, fnam);
		ps.setString(2, lnam);
		ps.setString(3, pw);
		ps.setString(4, rpw);
		ps.setString(5, ad);
		ps.setString(6, ph);
		ps.setString(7, des);
		ps.setString(8, ofnam);
		sj = ps.executeUpdate();
		if(sj != 0)
		{
			return sj;
		}
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			try
			{
				if(rs != null)
				{
					rs.close();
					rs = null;
				}
			}
			catch(SQLException sq1)
			{
				System.out.println(sq1);
			}
		try
		{
			if(ps != null)
			{
				ps.close();
				ps = null;
			}
		}
		catch(SQLException sq2)
		{
			System.out.println(sq2);
		}
		
		try
		{
			if(con != null)
			{
				con.close();
				con = null;
			}
		}
		catch(SQLException sq3)
		{
			System.out.println(sq3);
		}
		}
		return sj;
	}
	
	public int goDotNetDelete(String fnam)
	{
		Connection con = null;
		PreparedStatement ps = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "muni";
		String password = "admin";
		try
		{
		con = DriverManager.getConnection(url,username,password);
		String sql = "delete from dotnetdev where fname=?";
		ps = con.prepareStatement(sql);
		ps.setString(1, fnam);
		sk = ps.executeUpdate();
		if(sk !=0)
		{
			return sk;
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return sk;
	}
	
}

