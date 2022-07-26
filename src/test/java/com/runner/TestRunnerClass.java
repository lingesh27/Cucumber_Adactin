package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.report.Reporting;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	
		dryRun=false,
		snippets=SnippetType.CAMELCASE, 
		plugin= {"pretty","json:target\\outputnew.json","rerun:src\\test\\resources\\failed.txt"},
		monochrome=true,
		features = {"src\\test\\resources\\Features" }, 
		glue = {"com.stepdefinition" })

/**
 * 
 * @author Linges
 * @Descriptiom Generate Test Runner Class for execution
 * @Date 7-Jul-2020
 */

public class TestRunnerClass {


	@AfterClass
	public static void afterClass() {

		Reporting.generateJVMReport("C:\\Users\\SONY\\eclipse-workspace\\OMRBranchAdactinAutomatiom\\target\\outputnew.json");

	}

}		


