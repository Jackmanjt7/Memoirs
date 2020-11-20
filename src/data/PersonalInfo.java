package data;

// STATIC CLASS, DO NOT INSTANTIATE 
public class PersonalInfo {

	private static String 
	FIRST_NAME,
	LAST_NAME,
	BIRTHDAY,
	BIRTHPLACE,
	CURRENT_HOME,
	MOTHER, 
	FATHER,
	ADOPTIVE_PARENT_1,
	ADOPTIVE_PARENT_2;
	
	private static boolean ADOPTED = false;

	public static String getFIRST_NAME() {
		return FIRST_NAME;
	}

	public static void setFIRST_NAME(String fIRST_NAME) {
		FIRST_NAME = fIRST_NAME;
	}

	public static String getLAST_NAME() {
		return LAST_NAME;
	}

	public static void setLAST_NAME(String lAST_NAME) {
		LAST_NAME = lAST_NAME;
	}

	public static String getBIRTHDAY() {
		return BIRTHDAY;
	}

	public static void setBIRTHDAY(String bIRTHDAY) {
		BIRTHDAY = bIRTHDAY;
	}

	public static String getBIRTHPLACE() {
		return BIRTHPLACE;
	}

	public static void setBIRTHPLACE(String bIRTHPLACE) {
		BIRTHPLACE = bIRTHPLACE;
	}

	public static String getCURRENT_HOME() {
		return CURRENT_HOME;
	}

	public static void setCURRENT_HOME(String cURRENT_HOME) {
		CURRENT_HOME = cURRENT_HOME;
	}

	public static String getMOTHER() {
		return MOTHER;
	}

	public static void setMOTHER(String mOTHER) {
		MOTHER = mOTHER;
	}

	public static String getFATHER() {
		return FATHER;
	}

	public static void setFATHER(String fATHER) {
		FATHER = fATHER;
	}

	public static String getADOPTIVE_PARENT_1() {
		return ADOPTIVE_PARENT_1;
	}

	public static void setADOPTIVE_PARENT_1(String aDOPTIVE_PARENT_1) {
		ADOPTIVE_PARENT_1 = aDOPTIVE_PARENT_1;
	}

	public static String getADOPTIVE_PARENT_2() {
		return ADOPTIVE_PARENT_2;
	}

	public static void setADOPTIVE_PARENT_2(String aDOPTIVE_PARENT_2) {
		ADOPTIVE_PARENT_2 = aDOPTIVE_PARENT_2;
	}
	
	public static void setAdopted(boolean adopted) {
		ADOPTED = adopted;
	}
	
	public static boolean isAdopted() {
		return ADOPTED;
	}
	
	public static String allInfoToString() {
		String info = "";
		info += "First Name: " + getFIRST_NAME() + "\n";
		info += "Last Name: " + getLAST_NAME() + "\n";
		info += "DOB: " + getBIRTHDAY() + "\n";
		info += "Birthplace: " + getBIRTHPLACE() + "\n";
		info += "Current Home: " + getCURRENT_HOME() + "\n";
		return info;
	}
	
	
}
