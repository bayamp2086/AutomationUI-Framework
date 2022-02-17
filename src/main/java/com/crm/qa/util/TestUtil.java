package com.crm.qa.util;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;
import com.opencsv.CSVReader;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	
	public void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}

	public Iterator<Object[]> parseCSVData(String path) throws IOException
	{
		FileReader fileReader=new FileReader(path);
		CSVReader csvReader=new CSVReader(fileReader);
		String[] nextRecord;
		ArrayList<Object[]> data=new ArrayList<Object[]>();
		csvReader.readNext();
		while((nextRecord=csvReader.readNext())!=null)
		{
			data.add((Object[])nextRecord);
		}
		csvReader.close();
		return data.iterator();
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

}
