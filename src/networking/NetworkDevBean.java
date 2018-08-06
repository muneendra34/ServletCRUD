package networking;

public class NetworkDevBean {
	private static String fname;
	private static String lname;
	private static String pswd;
	private static String repswd;
	private static String add;
	private static String phone;
	private static String designation;
	
	public NetworkDevBean()
	{
		
	}
	
	public NetworkDevBean(String fn, String ln, String pw, String rpw, String ad, String ph, String des)
	{
		NetworkDevBean.fname = fn;
		NetworkDevBean.lname = ln;
		NetworkDevBean.pswd = pw;
		NetworkDevBean.repswd = rpw;
		NetworkDevBean.add = ad;
		NetworkDevBean.phone = ph;
		NetworkDevBean.designation = des;
	}

	public static String getFname() {
		return fname;
	}

	public static void setFname(String fname) {
		NetworkDevBean.fname = fname;
	}

	public static String getLname() {
		return lname;
	}

	public static void setLname(String lname) {
		NetworkDevBean.lname = lname;
	}

	public static String getPswd() {
		return pswd;
	}

	public static void setPswd(String pswd) {
		NetworkDevBean.pswd = pswd;
	}

	public static String getRepswd() {
		return repswd;
	}

	public static void setRepswd(String repswd) {
		NetworkDevBean.repswd = repswd;
	}

	public static String getAdd() {
		return add;
	}

	public static void setAdd(String add) {
		NetworkDevBean.add = add;
	}

	public static String getPhone() {
		return phone;
	}

	public static void setPhone(String phone) {
		NetworkDevBean.phone = phone;
	}

	public static String getDesignation() {
		return designation;
	}

	public static void setDesignation(String designation) {
		NetworkDevBean.designation = designation;
	}
	
}
