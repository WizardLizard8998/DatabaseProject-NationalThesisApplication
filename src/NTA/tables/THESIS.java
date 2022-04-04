package NTA.tables;

public class THESIS {
	private String T_No;
	private String T_Title;
	private String T_Abstract;
	private String A_Code;
	private String WrittenYear;
	private String TypeOfThesis;
	private String PageNumber;
	private String T_Language;
	private String SubmissionDate;
	private String Sv_Code;
	private String Sv2_Code;
	
	public String getT_No() {
		return T_No;
	}
	public void setT_No(String string) {
		T_No = string;
	}
	public String getT_Title() {
		return T_Title;
	}
	public void setT_Title(String t_Title) {
		T_Title = t_Title;
	}
	public String getT_Abstract() {
		return T_Abstract;
	}
	public void setT_Abstract(String t_Abstract) {
		T_Abstract = t_Abstract;
	}
	public String getA_Code() {
		return A_Code;
	}
	public void setA_Code(String a_Code) {
		A_Code = a_Code;
	}
	public String getWrittenYear() {
		return WrittenYear;
	}
	public void setWrittenYear(String writtenYear) {
		WrittenYear = writtenYear;
	}
	public String getTypeOfThesis() {
		return TypeOfThesis;
	}
	public void setTypeOfThesis(String typeOfThesis) {
		TypeOfThesis = typeOfThesis;
	}
	public String getPageNumber() {
		return PageNumber;
	}
	public void setPageNumber(String pageNumber) {
		PageNumber = pageNumber;
	}
	public String getT_Language() {
		return T_Language;
	}
	public void setT_Language(String t_Language) {
		T_Language = t_Language;
	}
	public String getSubmissionDate() {
		return SubmissionDate;
	}
	public void setSubmissionDate(String submissionDate) {
		SubmissionDate = submissionDate;
	}
	public String getSv_Code() {
		return Sv_Code;
	}
	public void setSv_Code(String sv_Code) {
		Sv_Code = sv_Code;
	}
	public String getSv2_Code() {
		return Sv2_Code;
	}
	public void setSv2_Code(String sv2_Code) {
		Sv2_Code = sv2_Code;
	}
	public THESIS(String t_No, String t_Title, String t_Abstract,  String a_Code, 
			String writtenYear, String typeOfThesis, String pageNumber, String t_Language,
			String submissionDate,String sv_Code,String sv2_Code) {
		
		T_No = t_No;
		T_Title = t_Title;
		T_Abstract = t_Abstract;
		A_Code = a_Code;
		WrittenYear = writtenYear;
		TypeOfThesis = typeOfThesis;
		PageNumber = pageNumber;
		T_Language = t_Language;
		SubmissionDate = submissionDate;
		Sv_Code = sv_Code;
		Sv2_Code = sv2_Code;
	}
	public THESIS() {
		super();
	}
	
	
	

}
