package com.scrapPlant.functions;

import org.testng.annotations.Test;

import com.scrapPlant.utilities.ReusableFunctions;

import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.testng.annotations.AfterTest;

public class execution {
	 @Test
	  public void Execution() throws Exception {
		  ReusableFunctions.launchBrowser("chrome");
		  System.out.println("Execution started -------");
		  ReusableFunctions.cpoyFolder("sourcePath","destinationPath");
		
	  }
	  @BeforeTest
	  public void beforeTest() throws Exception {
		 // String pathname="D:\\com.scrapPlant.test\\com.scrapPlant.test\\Downloads";
		 ReusableFunctions.path = System.getProperty("user.dir");
		  System.out.println("Execution started -------");
	      //ReusableFunctions.mail();
		  ReusableFunctions.folderdelete();
		  ReusableFunctions.getTimestamps();
	  }

	  @AfterTest
	  public void afterTest() throws Exception {
		  
		 //ReusableFunctions.renamefile();
		  //Copy files and folders from source
		  //ReusableFunctions.cpoyFolder("C:\\HuskPower\\TemporaryFolder\\Downloads\\LatestReading","C:\\HuskPower\\Dev\\Downloads\\LatestReading");
		  ReusableFunctions.cpoyFolder("sourcePath","destinationPath");
	  }

	}