package com.my.longtail.property;

import java.util.ResourceBundle;

public class Property {

	private static ResourceBundle res = ResourceBundle.getBundle("com.general.util.property/GeneralProperty");

	private static String PROJECT_LOG_PATH = res.getString("PROJECT_LOG_PATH");

	private static String GENERAL_FOLDER_NAME = res.getString("GENERAL_FOLDER_NAME");
	private static String WEBSERVICE_FOLDER_NAME = res.getString("WEBSERVICE_FOLDER_NAME");
	private static String WEBPORTAL_FOLDER_NAME = res.getString("WEBPORTAL_FOLDER_NAME");
	private static String EMAILBLAST_FOLDER_NAME = res.getString("EMAILBLAST_FOLDER_NAME");
	private static String SMSBLAST_FOLDER_NAME = res.getString("SMSBLAST_FOLDER_NAME");

	private static String ACT_FILENAME = res.getString("ACT_FILENAME");
	private static String ERR_FILENAME = res.getString("ERR_FILENAME");

	public static ResourceBundle getRes() {
		return res;
	}

	public static void setRes(ResourceBundle res) {
		Property.res = res;
	}

	public static String getPROJECT_LOG_PATH() {
		return PROJECT_LOG_PATH;
	}

	public static void setPROJECT_LOG_PATH(String pROJECT_LOG_PATH) {
		PROJECT_LOG_PATH = pROJECT_LOG_PATH;
	}

	public static String getGENERAL_FOLDER_NAME() {
		return GENERAL_FOLDER_NAME;
	}

	public static void setGENERAL_FOLDER_NAME(String gENERAL_FOLDER_NAME) {
		GENERAL_FOLDER_NAME = gENERAL_FOLDER_NAME;
	}

	public static String getWEBSERVICE_FOLDER_NAME() {
		return WEBSERVICE_FOLDER_NAME;
	}

	public static void setWEBSERVICE_FOLDER_NAME(String wEBSERVICE_FOLDER_NAME) {
		WEBSERVICE_FOLDER_NAME = wEBSERVICE_FOLDER_NAME;
	}

	public static String getWEBPORTAL_FOLDER_NAME() {
		return WEBPORTAL_FOLDER_NAME;
	}

	public static void setWEBPORTAL_FOLDER_NAME(String wEBPORTAL_FOLDER_NAME) {
		WEBPORTAL_FOLDER_NAME = wEBPORTAL_FOLDER_NAME;
	}

	public static String getEMAILBLAST_FOLDER_NAME() {
		return EMAILBLAST_FOLDER_NAME;
	}

	public static void setEMAILBLAST_FOLDER_NAME(String eMAILBLAST_FOLDER_NAME) {
		EMAILBLAST_FOLDER_NAME = eMAILBLAST_FOLDER_NAME;
	}

	public static String getSMSBLAST_FOLDER_NAME() {
		return SMSBLAST_FOLDER_NAME;
	}

	public static void setSMSBLAST_FOLDER_NAME(String sMSBLAST_FOLDER_NAME) {
		SMSBLAST_FOLDER_NAME = sMSBLAST_FOLDER_NAME;
	}

	public static String getACT_FILENAME() {
		return ACT_FILENAME;
	}

	public static void setACT_FILENAME(String aCT_FILENAME) {
		ACT_FILENAME = aCT_FILENAME;
	}

	public static String getERR_FILENAME() {
		return ERR_FILENAME;
	}

	public static void setERR_FILENAME(String eRR_FILENAME) {
		ERR_FILENAME = eRR_FILENAME;
	}

}
