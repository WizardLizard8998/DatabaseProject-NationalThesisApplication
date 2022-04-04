package NTA.tables;

public class SUPERVISOR {
	private String Sv_Code;
	private String Sv_FName;
	private String Sv_LName;
	private String I_Code;
	public String getSv_Code() {
		return Sv_Code;
	}
	public void setSv_Code(String sv_Code) {
		Sv_Code = sv_Code;
	}
	public String getSv_FName() {
		return Sv_FName;
	}
	public void setSv_FName(String sv_FName) {
		Sv_FName = sv_FName;
	}
	public String getSv_LName() {
		return Sv_LName;
	}
	public void setSv_LName(String sv_LName) {
		Sv_LName = sv_LName;
	}
	public String getI_Code() {
		return I_Code;
	}
	public void setI_Code(String i_Code) {
		I_Code = i_Code;
	}
	public SUPERVISOR(String sv_Code, String sv_FName, String sv_LName, String i_Code) {
		Sv_Code = sv_Code;
		Sv_FName = sv_FName;
		Sv_LName = sv_LName;
		I_Code = i_Code;
	}
	public SUPERVISOR() {
		super();
	}
	
	
	
}
