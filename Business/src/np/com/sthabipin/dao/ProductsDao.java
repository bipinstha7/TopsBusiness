package np.com.sthabipin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;





import np.com.sthabipin.dto.ProductsDto;

public class ProductsDao {

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Business","root","xaharihome");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return conn;
	}
	
	public static int save(ProductsDto p) {
		int status = 0;
		String sql = "insert into Product(id,name,brand,category,weight,price) values(?,?,?,?,?,?)";
		PreparedStatement pst = null;
		try {
			pst = getConnection().prepareStatement(sql);
			pst.setInt(1, p.getId());
			pst.setString(2, p.getName());
			pst.setString(3, p.getBrand());
			pst.setString(4, p.getCategory());
			pst.setDouble(5, p.getWeight());
			pst.setDouble(6, p.getPrice());
			status = pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}finally {
			try {
				pst.close();
			} catch (SQLException e) {
				System.out.println("Exception Thrown");
				e.printStackTrace();
			}
		}
		return status;
	}
	
	public static int delete(int id) {
		String sql = "delete from Product where id=?";
		PreparedStatement pst = null;
		try {
			pst = getConnection().prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				pst.close();
			} catch (SQLException e) {
				System.out.println("Exception Thrown");
				e.printStackTrace();
			}
		}
		return id;
	}
	
	public static List<ProductsDto> getAllRecords() {
		List<ProductsDto> list = new ArrayList<ProductsDto>();
		String sql = "select * from Product";
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = getConnection().prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				ProductsDto pd = new ProductsDto();
				pd.setId(rs.getInt("id"));
				pd.setName(rs.getString("name"));
				pd.setBrand(rs.getString("brand"));
				pd.setCategory(rs.getString("category"));
				pd.setWeight(rs.getDouble("weight"));
				pd.setPrice(rs.getDouble("price"));
				list.add(pd);
			}
		} catch (SQLException e) {
			System.out.println("Exception Thrown");
			System.out.println(e);
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("Exception Thrown");
				e.printStackTrace();
			}
			try {
				pst.close();
			} catch (SQLException e) {
				System.out.println("Exception Thrown");
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public static List<ProductsDto> getRecordsByStart(String start) {
		List<ProductsDto> list = new ArrayList<ProductsDto>();
		String sql = "select * from Product where name like '"+start+"%' ";
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			 pst = getConnection().prepareStatement(sql);
			 rs = pst.executeQuery();
			while(rs.next()) {
				ProductsDto pd =new ProductsDto();
				pd.setId(rs.getInt("id"));
				pd.setName(rs.getString("name"));
				pd.setBrand(rs.getString("brand"));
				pd.setCategory(rs.getString("category"));
				pd.setWeight(rs.getDouble("weight"));
				pd.setPrice(rs.getDouble("price"));
				list.add(pd);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}finally {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("Exception Thrown");
				e.printStackTrace();
			}
			try {
				pst.close();
			} catch (SQLException e) {
				System.out.println("Exception Thrown");
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public static List<ProductsDto> getRecordsByPrice(Double price) {
		List<ProductsDto> list = new ArrayList<ProductsDto>();
		String sql = "select * from Product where price like '"+price+"%' ";
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = getConnection().prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				ProductsDto pd =new ProductsDto();
				pd.setId(rs.getInt("id"));
				pd.setName(rs.getString("name"));
				pd.setBrand(rs.getString("brand"));
				pd.setCategory(rs.getString("category"));
				pd.setWeight(rs.getDouble("weight"));
				pd.setPrice(rs.getDouble("price"));
				list.add(pd);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}finally {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("Exception Thrown");
				e.printStackTrace();
			}
			try {
				pst.close();
			} catch (SQLException e) {
				System.out.println("Exception Thrown");
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public static List<ProductsDto> getRecordsByType(String category){
		List<ProductsDto> list=new ArrayList<ProductsDto>();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try{
			String sql = "select * from Product where category=? ";
			pst = getConnection().prepareStatement(sql);
			pst.setString(1,category);
			rs = pst.executeQuery();
			while(rs.next()){
				ProductsDto productsdto=new ProductsDto();
				productsdto.setId(rs.getInt("id"));
				productsdto.setName(rs.getString("Name"));
				productsdto.setBrand(rs.getString("brand"));
				productsdto.setCategory(rs.getString("category"));
				productsdto.setWeight(rs.getDouble("weight"));
				productsdto.setPrice(rs.getDouble("price"));
				list.add(productsdto);
			}
		}catch(Exception e){
			System.out.println(e);
		}finally {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("Exception Thrown");
				e.printStackTrace();
			}
			try {
				pst.close();
			} catch (SQLException e) {
				System.out.println("Exception Thrown");
				e.printStackTrace();
			}
		}
		return list;
	}
}
