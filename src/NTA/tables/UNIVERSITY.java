package NTA.tables;

public class UNIVERSITY {
	
	private String U_Code;
	private String U_Name;
	
	public String getU_Code() {
		return U_Code;
	}
	public void setU_Code(String u_Code) {
		U_Code = u_Code;
	}
	public String getU_Name() {
		return U_Name;
	}
	public void setU_Name(String u_Name) {
		U_Name = u_Name;
	}
	
	public UNIVERSITY(String u_Code, String u_Name) {
		U_Code = u_Code;
		U_Name = u_Name;
	}
	
	public UNIVERSITY() {
		super();
	}
	
	

}
