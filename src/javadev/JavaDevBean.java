package javadev;

public class JavaDevBean {
	
	private static String fname;
	private static String lname;
	private static String pswd;
	private static String repswd;
	private static String add;
	private static String phone;
	private static String designation;
	
	public JavaDevBean()
	{
		
	}
	
	public JavaDevBean(String fn, String ln, String pw, String rpw, String ad, String ph, String des)
	{
		JavaDevBean.fname = fn;
		JavaDevBean.lname = ln;
		JavaDevBean.pswd = pw;
		JavaDevBean.repswd = rpw;
		JavaDevBean.add = ad;
		JavaDevBean.phone = ph;
		JavaDevBean.designation = des;
	}

	public static String getFname() {
		return fname;
	}

	public static void setFname(String fname) {
		JavaDevBean.fname = fname;
	}

	public static String getLname() {
		return lname;
	}

	public static void setLname(String lname) {
		JavaDevBean.lname = lname;
	}

	public static String getPswd() {
		return pswd;
	}

	public static void setPswd(String pswd) {
		JavaDevBean.pswd = pswd;
	}

	public static String getRepswd() {
		return repswd;
	}

	public static void setRepswd(String repswd) {
		JavaDevBean.repswd = repswd;
	}

	public static String getAdd() {
		return add;
	}

	public static void setAdd(String add) {
		JavaDevBean.add = add;
	}

	public static String getPhone() {
		return phone;
	}

	public static void setPhone(String phone) {
		JavaDevBean.phone = phone;
	}

	public static String getDesignation() {
		return designation;
	}

	public static void setDesignation(String designation) {
		JavaDevBean.designation = designation;
	}
	
}
