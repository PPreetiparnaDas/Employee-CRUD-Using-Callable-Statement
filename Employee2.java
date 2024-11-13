package CallableStatementCRUD;

public class Employee2 {
    private int empId;
    private String empName;
    private String empEmail;
    private String empPass;
    private int roleId;
    private String roleName;
    public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
    public int getEmpId() {
        return empId;
    }
    public void setEmpId(int empId) {
        this.empId = empId;
    }
    public String getEmpName() {
        return empName;
    }
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    public String getEmpEmail() {
        return empEmail;
    }
    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }
    public String getEmpPass() {
        return empPass;
    }
    public void setEmpPass(String empPass) {
        this.empPass = empPass;
    }
    @Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empEmail=" + empEmail + ", empPass=" + empPass
				+ ", roleId=" + roleId + ", roleName=" + roleName + "]";
	}
}
