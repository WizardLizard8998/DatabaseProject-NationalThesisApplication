package NTA.tables;

public class AUTHOR {

	private String A_Code;
	private String A_FName;
	private String A_LName;
	private String A_Password;
	
	public String getA_Password() {
		return A_Password;
	}
	public void setA_Password(String a_Password) {
		A_Password = a_Password;
	}
	public String getA_Code() {
		return A_Code;
	}
	public void setA_Code(String a_Code) {
		A_Code = a_Code;
	}
	public String getA_FName() {
		return A_FName;
	}
	public void setA_FName(String a_FName) {
		A_FName = a_FName;
	}
	public String getA_LName() {
		return A_LName;
	}
	public void setA_LName(String a_LName) {
		A_LName = a_LName;
	}
	
	public AUTHOR(String a_Code, String a_FName, String a_LName, String a_Password) {
		A_Code = a_Code;
		A_FName = a_FName;
		A_LName = a_LName;
		A_Password = a_Password;
	}
	
	public AUTHOR() {
		super();
	}
	
	

}
