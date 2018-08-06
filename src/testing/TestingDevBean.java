package testing;

import javadev.JavaDevBean;

public class TestingDevBean {
	private static String fname;
	private static String lname;
	private static String pswd;
	private static String repswd;
	private static String add;
	private static String phone;
	private static String designation;
	
	public TestingDevBean()
	{
		
	}
	
	public TestingDevBean(String fn, String ln, String pw, String rpw, String ad, String ph, String des)
	{
		TestingDevBean.fname = fn;
		TestingDevBean.lname = ln;
		TestingDevBean.pswd = pw;
		TestingDevBean.repswd = rpw;
		TestingDevBean.add = ad;
		TestingDevBean.phone = ph;
		TestingDevBean.designation = des;
	}

	public static String getFname() {
		return fname;
	}

	public static void setFname(String fname) {
		TestingDevBean.fname = fname;
	}

	public static String getLname() {
		return lname;
	}

	public static void setLname(String lname) {
		TestingDevBean.lname = lname;
	}

	public static String getPswd() {
		return pswd;
	}

	public static void setPswd(String pswd) {
		TestingDevBean.pswd = pswd;
	}

	public static String getRepswd() {
		return repswd;
	}

	public static void setRepswd(String repswd) {
		TestingDevBean.repswd = repswd;
	}

	public static String getAdd() {
		return add;
	}

	public static void setAdd(String add) {
		TestingDevBean.add = add;
	}

	public static String getPhone() {
		return phone;
	}

	public static void setPhone(String phone) {
		TestingDevBean.phone = phone;
	}

	public static String getDesignation() {
		return designation;
	}

	public static void setDesignation(String designation) {
		TestingDevBean.designation = designation;
	}
	
}
