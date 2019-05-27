package com.scrapPlant.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ReusableFunctions extends DriverClass{

	public static String path = null;	
	public static String userName;
	public static String passWord;
	public static String PlantCode;
	public static String dateString;
	//Function for Print the steps in allure report
	
	public static void logStep(String stepName ){

	}

	public static void selectBydropDown(WebElement ele, String value) {
		ele.click();
		Select paymentoption= new Select (ele);
		paymentoption.selectByVisibleText(value);
	}

	public static byte[] attachScreen(WebDriver driver ) {
		logStep("Taking screenshot");
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}

	public static byte[] attachScreen_TestCaseError(WebDriver driver ) {
		logStep("Taking screenshot");
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}

	//Mouse hover
	public static void mouseHover(WebDriver driver, WebElement we) {
		Actions action = new Actions(driver);
		action.moveToElement(we).build().perform();
	}

	//Get exection time stamps
	public static void getTimestamps() {
		Timestamp ts=new Timestamp(System.currentTimeMillis());
		SimpleDateFormat dateformate = new SimpleDateFormat("dd-MM-yyyy_HH_mm");
		dateString = dateformate.format(ts);
		System.out.println("Execution date : "+dateString); 
	}
	public static void browserLaunch(int line, String browserName, String downloadName) throws Exception {

		String url = ReadexcelFile.readdata[line][1];
		userName= ReadexcelFile.readdata[line][2];
		passWord=ReadexcelFile.readdata[line][3];
		System.out.println("Col count"+ReadexcelFile.colCount);
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",path+ "//lib//chromedriver.exe");
			//String downloadFilepath = path+"\\Downloads\\"+downloadName;
			String downloadFilepath ="C:\\HuskPower\\TemporaryFolder\\Downloads\\"+downloadName ;
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", downloadFilepath);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			driver=new ChromeDriver(options);
		}else if(browserName.equalsIgnoreCase("fireFox")) {
			System.setProperty("webdriver.gecko.driver", path+"/lib/geckodriver.exe");
			driver = new FirefoxDriver();

		}else if(browserName.equalsIgnoreCase("IE")) {

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.id("email")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(passWord);
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
	}
	//Launch browser based on select 
	public static void launchBrowser(String browserName) throws Exception {

		Actions act;
		JavascriptExecutor js;
		ReadexcelFile.readExcel("Sheet1");
		for(int line =1;line<=ReadexcelFile.rowCount-1;line++) {
			PlantCode =ReadexcelFile.readdata[line][4]+"_"+dateString;
			for(int downAction=2;downAction<=2;downAction++) {
				if(downAction==1) {
					System.out.println("Transactions start here");
					browserLaunch(line,browserName,"Transactions");
					//for History option
					waitForVisible(driver.findElement(By.xpath("//*[@class='btn btn-default dropdown-toggle']")));
					WebElement history=driver.findElement(By.xpath("//*[@class='btn btn-default dropdown-toggle']"));

					history.click();
					//for transactions option

					//WebElement trans= driver.findElement(By.xpath("//*[@class='col-md-2 action-nav-button open']/ul/li/a/span[contains(text(),'Transactions')]"));
					WebElement trans=driver.findElement(By.xpath("//*[@class='col-md-2 action-nav-button open']/ul/li/a/span[contains(text(),'Transactions')]/preceding::a[1]//following::a[1]"));
					System.out.println(trans.getAttribute("href"));
					trans.click();


					try {
						driver.findElement(By.id("email")).sendKeys(userName);
						driver.findElement(By.id("password")).sendKeys(passWord);
						driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
					}catch(Exception e) {
						System.out.println("User already on required page");
					}
					//clicking on settings icon
					driver.findElement(By.xpath("//a[@class='cog']")).click();
					//*[@id="export-menu"]/li/a[1]/text()

					waitForVisible(driver.findElement(By.xpath("//ul[@id='export-menu']/li/a[1]")));
					driver.findElement(By.xpath("//ul[@id='export-menu']/li/a[1]")).click();
					Thread.sleep(5000);
					driver.close();
				}else if(downAction==2) {
					System.out.println("Lattest Reading starts here");
					browserLaunch(line,browserName,"LatestReading");
					try {
						waitForVisible(driver.findElement(By.xpath("//*[@class=\"breadcrumb-button blue\"]")));
						driver.findElement(By.xpath("//*[@class='breadcrumb-button blue']")).click();
						System.out.println("User Navigated to Home screen and try to click on Last Readings option");
					}catch(Exception e) {
						//waitForVisible(driver.findElement(By.xpath("//*[@class=\"navbar-brand\"]")));
						driver.findElement(By.xpath("//*[@class='navbar-brand']")).click();
						System.out.println("User Navigated to Home screen and try to click on Last Readings option");

					}

					try {
						driver.findElement(By.id("email")).sendKeys(userName);
						driver.findElement(By.id("password")).sendKeys(passWord);
						driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
					}catch(Exception e) {
						System.out.println("User already on required page");
					}
					driver.findElement(By.xpath("//div[@class='col-md-2 action-nav-button'][3]")).click();

					driver.findElement(By.xpath("//li[@class='toolbar-link']//*[@class='icon-cog']")).click();

					driver.findElement(By.xpath("//li[@class='toolbar-link open']/ul[@class='dropdown-menu']")).click();

					System.out.println("Last Readings file downloaded sucessfully");
					Thread.sleep(5000);
					driver.close();
				}else if(downAction==3){
					System.out.println("SparkMeter start here");
					browserLaunch(line,browserName,"SparkMeter");
					act=new Actions(driver);
					try {
						//waitForVisible(driver.findElement(By.xpath("//*[@class=\"breadcrumb-button blue\"]")));
						driver.findElement(By.xpath("//*[@class='breadcrumb-button blue']")).click();
						System.out.println("User Navigated to Home screen and try to click on Last Readings option");
					}catch(Exception e) {
						//waitForVisible(driver.findElement(By.xpath("//*[@class=\"navbar-brand\"]")));
						driver.findElement(By.xpath("//*[@class='navbar-brand']")).click();
						System.out.println("User Navigated to Home screen and try to download Customer meters ");

					}

					try {
						driver.findElement(By.id("email")).sendKeys(userName);
						driver.findElement(By.id("password")).sendKeys(passWord);
						driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
					}catch(Exception e) {
						System.out.println("User already on required page");
					}

					WebElement settingicon=driver.findElement(By.xpath("//*[@id='main-content']/div[3]/div/div[4]/div/div/div[1]/ul/li[2]/a"));
					act.moveToElement(settingicon).click().build().perform();
					js = (JavascriptExecutor) driver;

					js.executeScript("window.scrollBy(0,250)","");

					WebElement element=driver.findElement(By.xpath("//div[@data-list='customer']//ul[@class='box-toolbar']//ul//li//a[1]"));
					((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);

					Thread.sleep(6000);
					driver.close();
				}

			}
			renamefile();
			getAllReportsPath();

		}
	}

	public static void folderdelete() throws IOException {
		//String downloadPath = path+"\\Downloads";
		String[] downloadPath = {"C:\\HuskPower\\TemporaryFolder\\Downloads\\LatestReading"};
		for(String download:downloadPath) {
			File index = new File(download);
			File[] files = index.listFiles();
			if(files!=null) { //some JVMs return null for empty dirs
				for(File f: files) {
					if(f.isDirectory()) {
						FileUtils.cleanDirectory(f);
					} else {
						f.delete();
					}
				}
			}
			index.delete();
		}
	}
	public static void Scroll(String scrollType) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if(scrollType.equalsIgnoreCase("down")) {
			js.executeScript("window.scrollBy(0,1000)");
		}else  if(scrollType.equalsIgnoreCase("up")){

		}

	}
	//Function for provide wait for loader image
	public static void waitforloadingDisable(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("theImg")));
	}

	public static void waitforloadingDisableinsuredDetailsPg(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("Img1")));
	}


	public static void waitforloadingDisableTW(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 600);
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("theImg")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("typing_loader")));
	}	

	public static void waitforloadingDisablePaymentPage(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 750);
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("theImg")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
	}	

	//Wait functions
	public static WebElement waitTillElementVisible(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement elementloaded = wait.until(ExpectedConditions.visibilityOf(element));
		return elementloaded;
	}


	public static WebElement waitTillElementTobeLocated(By by, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement elementloaded = wait.until(ExpectedConditions.presenceOfElementLocated(by));
		return elementloaded;
	}

	public static WebElement waitTillElementToBeClickable(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement elementloaded = wait.until(ExpectedConditions.elementToBeClickable(element));
		return elementloaded;
	}
	public static void waitForVisible(WebElement locator) throws Exception {
		Thread.sleep(1000);
		for (int i = 0; i <= 40; i++) {
			try {
				locator.isDisplayed();
				break;

			} catch (Exception e) {
				if (i == 40) {
					throw e;

				} else {
					Thread.sleep(1000);
				}
			}
		}
	}

	public static void waitForVisibleDropdown(List<WebElement> elements) throws Exception {
		Thread.sleep(1000);
		for (int i = 0; i <= 25; i++) {
			try {
				if (elements.size() != 0) {
					break;
				} else {
					throw new Exception("list size is 0");
				}

			} catch (Exception e) {
				if (i == 25) {
					throw e;

				} else {
					Thread.sleep(1000);

				}
			}

		}
	}

	//Wait for Page Load
	public static void waitTillPageLoaded(WebDriver driver)  {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};

		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		try {
			wait.until(expectation);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Click functionality by Java Script
	public static void clickByJS(WebElement el, WebDriver driver) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", el);

		} catch (Exception e) {
			e.getMessage();
		}
	}

	//Move to Element Function 
	public static void moveToElement(WebElement element, WebDriver driver) {
		try{
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
		}
		catch(Exception e){
			e.getMessage();
		}
	}

	// Point To Element
	public static void pointToElement(WebElement e1, WebDriver driver){
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", e1);
	}

	// Function for provide wait for VerifyPage Title
	public static void verifypageTitle(String str, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.titleContains(str));
	}

	@SuppressWarnings("resource")
	public static void cpoyFolder(String Source, String Destination) throws Exception {
		File file = new File("C:\\Users\\tejaswini\\Desktop\\lattestReading\\com.scrapPlant.test\\config.properties");
		Properties properties = new Properties();
		FileInputStream fileInput = new FileInputStream(file); 
		properties.load(fileInput);
		String sourcePath = properties.getProperty("sourcePath");
		System.out.println("sourcePath is : ---"+sourcePath);
		String destinationPath=properties.getProperty("destinationPath");
		System.out.println(destinationPath);
		
		File sourceFile = new File(	sourcePath);

		File destFile = new File(destinationPath);
		FileUtils.copyDirectory(sourceFile, destFile);

	
	}
	private static void getAllReportsPath() throws IOException {
		System.out.println("report generation initiated");
		Properties properties = new Properties();
		properties.load(ReusableFunctions.class.getResourceAsStream("/config.properties"));
		String destinationPath = properties.getProperty("sourcePath");
		File folder = new File(destinationPath + "\\LatestReading");
		String reportPath = properties.getProperty("reportPath");
		File fileName = new File(reportPath + "\\SparkmeterLRDev.xlsx");
		try {
			createReportFile(fileName, folder.listFiles());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static void createReportFile(File fileName, File[] listOfFiles) throws IOException {
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			XSSFWorkbook  workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("Plant");
			Row row = sheet.createRow(0);
			Cell cell0 = row.createCell(0);
			cell0.setCellValue("Name");
			for (int i = 0; i < listOfFiles.length; i++) {
		  		  if (listOfFiles[i].isFile()) {
		  			row = sheet.createRow(i+1);   
			        cell0 = row.createCell(0);
			        cell0.setCellValue(listOfFiles[i].getName());
		  		  }
}
	        
	        workbook.write(fos);
	        fos.flush();
	        fos.close();
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	}
	
	public static void renamefile() {
		//PlantCode="HINUP-01-06";
		String folder_path = 
				"C:\\HuskPower\\TemporaryFolder\\Downloads"; 
		File[] directories = new File(folder_path).listFiles();
		// creating new folder 
		//File myfolder = new File(folder_path);
		String folderName =null;
		for(int folder=0;folder<directories.length;folder++) {
			folderName=directories[folder].toString();
			File[] file_array = directories[folder].listFiles(); 
			for (int i = 0; i < file_array.length; i++) 
			{ 
				System.out.println("File list is :" +file_array.length);
				if (file_array[i].isFile()) 
				{ 

					File myfile = new File(folderName + 
							"\\" + file_array[i].getName()); 
					if(myfile.toString().contains("HI")) {
						System.out.println("File name already changed : "+myfile );
					}else {
						String long_file_name = file_array[i].getName(); 
						String[] tokens = long_file_name.split(".csv") ;
						String new_file_name = PlantCode+".csv"; 
						System.out.println(long_file_name); 
						System.out.print(new_file_name); 

						myfile.renameTo(new File(folderName+"\\" + new_file_name)); 
						
					}
				} 
			} 
		}
	
	}

	
}
