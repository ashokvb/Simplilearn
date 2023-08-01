package com.framework.base.constants;

import java.io.File;

public class FrameworkConstants {
	public static final boolean GRID_RUN = false;

	static String datapath = System.getProperty("user.dir") + "//data//";
	// paths
	public static final String CHROME_DRIVER_EXE = System.getProperty("user.dir")
			+ "//Browser_Drivers//chromedriver.exe";
	
	public static final String EDGE_DRIVER_EXE = System.getProperty("user.dir")
			+ "//Browser_Drivers//msedgedriver.exe";
	
	public static final String FIREFOX_DRIVER_EXE = System.getProperty("user.dir")
			+ "//Browser_Drivers//geckodriver.exe";

	public static final String IEXPLORE_DRIVER_EXE = System.getProperty("user.dir")
			+ "//Browser_Drivers//IEDriverServer.exe";
	// paths
	public static final String REPORTS_PATH = System.getProperty("user.dir") + "//test-reports//";
	
	//***** Master Test Data File****
	public static final String PS_DATA_XLS_PATH = datapath + "Student_Master_DataSheet.xlsx";
	//***** Master Test Data File API****
	public static final String PS_DATA_XLS_PATH_API = datapath + "Student_Master_DataSheet_API.xlsx";

	//***** Vasu Test Data File****
	//public static final String PS_DATA_XLS_PATH = datapath + "StudentScenarios.xlsx";

	//***** Sneha Test Data File****
	//public static final String PS_DATA_XLS_PATH = datapath + "Student_Data_Web_Sneha.xlsx";
	
    // ASHOK Data Sheet
	//public static final String PS_DATA_XLS_PATH = datapath + "Student_Data_Web.xlsx";

    //***** Nanda Test Data File****
    //public static final String PS_DATA_XLS_PATH = datapath + "StudentTestData.xlsx";
	
	public static final String PS2_DATA_XLS_PATH = datapath + "Student_Data_Web.xlsx";
	public static final String User_Autoit_Exe = datapath + "horizon1.exe";
	public static final String DOWNLOADS_PATH = System.getProperty("user.dir") + File.separator + "Downloads";
	public static final String DATA_XLS_RESTAPI = datapath + "Data_RestAPI.xlsx";

	public static final String TESTDATA_SHEET = "TestData";
	public static final Object RUNMODE_COL = "Runmode";
	public static final String TESTCASES_SHEET = "TestCases";
	public static final String TESTDATABASE_SHEET = "Database";

	public static String acctNumber = null;
	public static String accountNumber_Commercial;
	public static String accountNumber_Contract = null;
	public static String accountNumber_International = null;
	public static String bondNumber = null;
	public static String diaryBondNumber = null;

	public static String PremiumValueUSD = null;
	public static String collatralAmountValueUSD = null;
	public static String collatralAdjAmountValueUSD = null;
	public static String collatralAmount2ValueUSD = null;
	public static String collatralAmount3ValueUSD = null;
	public static String collatralAmount4ValueUSD = null;

	public static String indmenityApprovalCount = null;
	public static String beforeAccountApprovalCount = null;
	public static String afterAccountApprovalCount = null;
	public static String InternationalBondQuestionDes = null;
	public static String InternationalAcntQuestionDes = null;
	public static String QuestionDes = null;

	public static String CommercialBondQuestionDes = null;
	public static String ContractBondQuestionDes = null;

	public static String ContractQuestionDes = null;
	public static String RoleDes = null;
	public static String Date = null;
	public static String Report_Name = null;

}
