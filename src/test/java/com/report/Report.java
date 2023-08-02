package com.report;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.base.baseclass;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Report extends baseclass {
	public static void generateJVMReport(String jsonFile) throws IOException {

		File file = new File(getProjectPath() + getProperties("jvmPath"));

		Configuration config = new Configuration(file, "Cucumber-API-RestAssured");

		config.addClassifications("FirstName", "Rakesh");

		config.addClassifications("LastName", "Kanojiya");

		config.addClassifications("Testing", "GIT-API");

		config.addClassifications("Browser", "Chrome");

		List<String> json = new ArrayList<String>();

		json.add(jsonFile);

		ReportBuilder builder = new ReportBuilder(json, config);

		builder.generateReports();

	}

}

