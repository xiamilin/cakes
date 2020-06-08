package qianTai;
import java.sql.*;
import java.util.*;

import vo.huiyuan;
import dbc.JdbcUtil;

public class qian {
	  public boolean add(huiyuan hy) throws Exception{
			 Connection conn = null;
			 PreparedStatement ps = null;
			 int count=0;
			 try {
				 conn = JdbcUtil.getConnection();
				 String sql = "insert into huiyuan (id,name,sex,count,dates)  values (?,?,?,?,?) ";
				 ps = conn.prepareStatement(sql);
				 ps.setInt(1, hy.getId());
				 ps.setString(2,hy.getName());
				 ps.setString(3,hy.getSex());
				 ps.setInt(4,hy.getCount());
				 ps.setString(5,hy.getDates());
				 count= ps.executeUpdate();
			 }finally {JdbcUtil.free(null,ps, conn);}
			 System.out.print("-------------count="+count);
			 if(count>0) return true;
			 else return false;
		   }
		   public boolean update(huiyuan hy) throws Exception{
			Connection conn = null;
			PreparedStatement ps = null;
			int count=0;
			try {
				conn = JdbcUtil.getConnection();
				String sql = "update huiyuan set Hname=?,Hsex=? where Hid=? ";
				ps = conn.prepareStatement(sql);
				ps.setInt(1,hy.getId());
				ps.setString(2,hy.getName());
				ps.setString(3, hy.getSex());
				count=ps.executeUpdate();
			}finally {JdbcUtil.free(null,ps, conn);}
			if(count>0) return true;
			else return false;
		   }
		   public boolean delete(int Id) throws Exception{
			 Connection conn = null;
			 PreparedStatement ps = null;
			 int count = 0;
			 try {
				conn = JdbcUtil.getConnection();
				String sql = "delete from huiyuan where Hid=?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1,Id);
				count = ps.executeUpdate();
			}finally {JdbcUtil.free( null,ps, conn);}
			 if(count>0) return true;
			 else return false;
		   }
		     public huiyuan findUserById(String Id) throws Exception{
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			huiyuan hy=null;
			try {
				conn = JdbcUtil.getConnection();
				String sql = "select * from huiyuan where Hid=? ";
				ps = conn.prepareStatement(sql);
				ps.setString(1, Id);
				rs=ps.executeQuery();
				if(rs.next()){
				   hy=new huiyuan();
				   hy.setId(rs.getInt(1));
				   hy.setName(rs.getString(2));
				   hy.setSex(rs.getString(3));
				   hy.setCount(rs.getInt(4));
				   hy.setDates(rs.getString(5));
				}
			}finally {JdbcUtil.free(rs, ps, conn);}
			return hy;
		   }
		   
		   public List<huiyuan> QueryAll() throws Exception{
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			List<huiyuan> hyList=new ArrayList<huiyuan>();
			try {
				conn = JdbcUtil.getConnection();
				String sql = "select * from huiyuan ";
				ps=conn.prepareStatement(sql);
				rs=ps.executeQuery();
				while(rs.next()){
				   huiyuan hy=new huiyuan();
				   hy.setId(rs.getInt(1));
				   hy.setName(rs.getString(2));
				   hy.setSex(rs.getString(3));
				   hy.setCount(rs.getInt(4));
				   hy.setDates(rs.getString(5));
				   hyList.add(hy);
				}
			}finally {JdbcUtil.free(rs, ps, conn);}
			return hyList;
		   }
}
