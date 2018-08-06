package dotnetdev;

public class DotNetDevBean {
	private static String fname;
	private static String lname;
	private static String pswd;
	private static String repswd;
	private static String add;
	private static String phone;
	private static String designation;
	
	public DotNetDevBean()
	{
		
	}
	
	public DotNetDevBean(String fn, String ln, String pw, String rpw, String ad, String ph, String des)
	{
		DotNetDevBean.fname = fn;
		DotNetDevBean.lname = ln;
		DotNetDevBean.pswd = pw;
		DotNetDevBean.repswd = rpw;
		DotNetDevBean.add = ad;
		DotNetDevBean.phone = ph;
		DotNetDevBean.designation = des;
	}

	public static String getFname() {
		return fname;
	}

	public static void setFname(String fname) {
		DotNetDevBean.fname = fname;
	}

	public static String getLname() {
		return lname;
	}

	public static void setLname(String lname) {
		DotNetDevBean.lname = lname;
	}

	public static String getPswd() {
		return pswd;
	}

	public static void setPswd(String pswd) {
		DotNetDevBean.pswd = pswd;
	}

	public static String getRepswd() {
		return repswd;
	}

	public static void setRepswd(String repswd) {
		DotNetDevBean.repswd = repswd;
	}

	public static String getAdd() {
		return add;
	}

	public static void setAdd(String add) {
		DotNetDevBean.add = add;
	}

	public static String getPhone() {
		return phone;
	}

	public static void setPhone(String phone) {
		DotNetDevBean.phone = phone;
	}

	public static String getDesignation() {
		return designation;
	}

	public static void setDesignation(String designation) {
		DotNetDevBean.designation = designation;
	}
	
	


}
