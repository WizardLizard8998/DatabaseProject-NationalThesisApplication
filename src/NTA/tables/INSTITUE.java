package NTA.tables;

public class INSTITUE {
	
	private String I_Name;
	private String I_Code;
	private String U_Code;
	
	public String getI_Code() {
		return I_Code;
	}

	public void setI_Code(String i_Code) {
		I_Code = i_Code;
	}
	
	public String getI_Name() {
		return I_Name;
	}
	
	public void setI_Name(String i_Name) {
		I_Name = i_Name;
	}
	
	public String getU_Code() {
		return U_Code;
	}
	
	public void setU_Code(String u_Code) {
		U_Code = u_Code;
	}

	public INSTITUE(String i_Name,String i_Code, String u_Code) {
		I_Name = i_Name;
		I_Code = i_Code;
		U_Code = u_Code;
	}

	public INSTITUE() {
		super();
	}
	
	
	
	
}
