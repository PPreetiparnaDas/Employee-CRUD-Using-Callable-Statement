package CallableStatementCRUD;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeOperation2 {
	private static Connection con=null;
	private static CallableStatement cs=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	private static String sql=null;

	public static Connection getCon() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bcet","root","preeti");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public static int addEmployee(Employee2 emp) {
		int status=0;
		try {
			con=getCon();
			String query="{call bcet.addEmployee(?,?, ?, ?, ?)}";
			cs=con.prepareCall(query);
			cs.setInt(1, emp.getEmpId());
			cs.setString(2,emp.getEmpName());
			cs.setString(3,emp.getEmpEmail());
			cs.setString(4,emp.getEmpPass());
			cs.setInt(5, emp.getRoleId());
			status=cs.executeUpdate();
			cs.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public static void viewEmployee() {
		try {
			con=getCon();
			String query="{call bcet.viewEmployee()}";
			cs=con.prepareCall(query);
			rs=cs.executeQuery();
			while(rs.next()) {
				System.out.println("EmployeeId :"+rs.getInt(1));
				System.out.println("Employee Name :"+rs.getString(2));
				System.out.println("Employee Email :"+rs.getString(3));
				System.out.println("Employee Password:"+rs.getString(4));
				System.out.println("Employee Role Id:"+rs.getInt(5));
				System.out.println("Employee Role Name:"+rs.getString(6));
				System.out.println();
				System.out.println("-------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void viewEmployeebyId(int empId) {
		try {
			con=getCon();
			String query="{call bcet.viewEmployeeById(?)}";
			cs=con.prepareCall(query);
			cs.setInt(1, empId);
			rs=cs.executeQuery();
			while(rs.next()) {
				System.out.println("Employee Id :"+rs.getInt(1));
				System.out.println("Employee Name :"+rs.getString(2));
				System.out.println("Employee Email :"+rs.getString(3));
				System.out.println("Employee Pass :"+rs.getString(4));
				System.out.println("Employee Role Id:"+rs.getInt(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static int updateEmployee(Employee2 uemp) {
		int status=0;
		try {
			con=getCon();
			String query="{call bcet.updateEmployee(?,?,?,?,?)}";
			cs=con.prepareCall(query);
			cs.setString(1,uemp.getEmpName());
			cs.setString(2,uemp.getEmpEmail());
			cs.setString(3,uemp.getEmpPass());
			cs.setInt(4, uemp.getRoleId());
			cs.setInt(5, uemp.getEmpId());
			status=cs.executeUpdate();
			cs.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public static int deleteEmployee(int empId) {
		int status = 0;
		try {
			con = getCon();
			String query = "{call bcet.deleteEmployee(?)}";
			cs = con.prepareCall(query);
			cs.setInt(1, empId);
			status = cs.executeUpdate();
			cs.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
