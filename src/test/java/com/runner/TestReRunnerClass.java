package com.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		
		monochrome = true, 
		features = {"@C:\\Users\\SONY\\eclipse-workspace\\OMRBranchAdactinAutomatiom\\src\\test\\resources\\failed.txt" }, 
		glue = { "com.stepdefinition" })




public class TestReRunnerClass {

}
