package com.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
/**
 * 
 * @author Linges
 * @Descriptiom Generate JVM Report
 * @Date 7-Jul-2020
 */
public class Reporting {
	
	/**
	 * 
	 * @param jsonFile
	 */
	
public static void generateJVMReport(String jsonFile) {
		
		File f = new File("C:\\Users\\SONY\\eclipse-workspace\\OMRBranchAdactinAutomatiom\\JVM_Report");
		
		Configuration config =new Configuration(f, "AdactinHotel Automation");

		config.addClassifications("Browser", "Chrome");
		config.addClassifications("Version", "103");
		config.addClassifications("OS", "WIN10");
		
		List<String> jsonFiles = new ArrayList<String>();
		
		jsonFiles.add(jsonFile);
		
		ReportBuilder rb = new ReportBuilder(jsonFiles, config);
		
		rb.generateReports();
		
		
	}

}
