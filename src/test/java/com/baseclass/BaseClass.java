package com.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	
	public static void clear(WebElement element) {
	
		element.clear();
	}
	


	public static String getData(String sheetname,int rownum,int cellnum) throws IOException{

		String res=null;

		File file = new File("C:\\Users\\SONY\\eclipse-workspace\\MavenTest1\\Excel Sheets\\TestNG_Login_Datas.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(stream);
		org.apache.poi.ss.usermodel.Sheet sht = wb.getSheet(sheetname);
		Row r = sht.getRow(rownum);
		Cell cell = r.getCell(cellnum);
		CellType type = cell.getCellType();
		wb.close();

		switch(type){

		case STRING:
			res=cell.getStringCellValue();
			break;

		case NUMERIC:
			if(DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
				res = sdf.format(dateCellValue);
			}
			else {
				double numericCellValue = cell.getNumericCellValue();
				long l = (long) numericCellValue;
				BigDecimal valueOf = BigDecimal.valueOf(l); 
				res = valueOf.toString();
			}

			break;

		default:
			break;	
		}

		return res;

	}



	public static void updateData(String sheetname,int rownum,int cellnum,String olddata, String newdata) throws IOException{

		File file = new File("C:\\Users\\SONY\\eclipse-workspace\\MavenTest1\\Excel Sheets\\Adactin_Task_New.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(stream);
		org.apache.poi.ss.usermodel.Sheet sht = wb.getSheet(sheetname);
		Row r = sht.getRow(rownum);
		Cell cell = r.getCell(cellnum);
		String value = cell.getStringCellValue();
		if(value.equals(olddata)) {
			cell.setCellValue(newdata);
		}
		FileOutputStream out = new FileOutputStream(file);
		wb.write(out);
		wb.close();
		
	}
	
	public static void updateDataEmptyCell(String sheetname,int rownum,int cellnum,String data) throws IOException{

		File file = new File("C:\\Users\\SONY\\eclipse-workspace\\MavenTest1\\Excel Sheets\\Adactin_Task_New.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(stream);
		org.apache.poi.ss.usermodel.Sheet sht = wb.getSheet(sheetname);
		Row r = sht.getRow(rownum);
		Cell cell = r.getCell(cellnum);
		cell.setCellValue(data);
		FileOutputStream out = new FileOutputStream(file);
		wb.write(out);
		wb.close();
		
	}

	public static void writeData(String sheetname,int rownum,int cellnum,String data) throws IOException{

		File file = new File("C:\\Users\\SONY\\eclipse-workspace\\MavenTest1\\Excel Sheets\\POM_Adactin.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(stream);
		org.apache.poi.ss.usermodel.Sheet sht = wb.getSheet(sheetname);
		Row r = sht.getRow(rownum);
		Cell cell = r.createCell(cellnum);
		cell.setCellValue(data);
		FileOutputStream out = new FileOutputStream(file);
		wb.write(out);
		wb.close();
		
	}

	public String getpropertyfile(String key) throws IOException {
		FileInputStream stream = new FileInputStream(System.getProperty("user.dir")+"\\config.properties");

		Properties properties = new Properties();
		properties.load(stream);
		Object name = properties.get(key);
		String value = (String) name;
		return value;
	}
	
	public void getdrivers(String browserType) {
		switch (browserType) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new  ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();

			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();

			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;

		default:
			break;
		}

	}
	
	
		public static void getDriver() {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		public static void launchUrl(String url) {

			driver.get(url);
		}

		public static void maximize() {

			driver.manage().window().maximize();
		}

		public static void type(WebElement element, String data) {

			element.sendKeys(data);
		}

		public void click(WebElement element) {

			element.click();
		}

		public static String getTitle() {

			String title = driver.getTitle();
			return title;
		}

		public static WebElement findElementById(String attributeValue) {

			WebElement element = driver.findElement(By.id(attributeValue));
			return element;
		}

		public static WebElement findElementByName(String attributreValue) {

			WebElement element = driver.findElement(By.name(attributreValue));
			return element;
		}

		public static WebElement findElementByClassName(String attributreValue) {

			WebElement element = driver.findElement(By.className(attributreValue));
			return element;
		}

		public static WebElement findElementByXpath(String xpath) {

			WebElement element = driver.findElement(By.xpath(xpath));
			return element;
		}

		public static String getUrl() {

			String currentUrl = driver.getCurrentUrl();
			return currentUrl;
		}

		public static String getText(WebElement element) {

			String text = element.getText();
			return text;
		}

		public static String getAttribute(WebElement element) {

			String attribute = element.getAttribute("value");
			return attribute;
		}

		public static String getAttribute(WebElement element, String attributeName) {

			String attribute = element.getAttribute(attributeName);
			return attribute;
		}

		public static void selectOptionsByText(WebElement element, String text) {

			Select s = new Select(element);
			s.selectByVisibleText(text);
		}

		public static void selectOptionsByAttribute(WebElement element, String value) {

			Select s = new Select(element);
			s.selectByValue(value);
		}

		public static void selectOptionsByIndex(WebElement element, int index) {

			Select s = new Select(element);
			s.selectByIndex(index);
		}

		public static List<WebElement> selectGetOptions(WebElement element) {

			Select s = new Select(element);
			List<WebElement> options = s.getOptions();
			return options;
		}

		public static List<WebElement> selectGetAllSelectedOptions(WebElement element) {

			Select s = new Select(element);
			List<WebElement> options = s.getAllSelectedOptions();
			return options;
		}

		public static WebElement selectGetFirstlSelectedOptions(WebElement element) {

			Select s = new Select(element);
			WebElement firstSelectedOption = s.getFirstSelectedOption();
			return firstSelectedOption;
		}

		public static boolean selectIsMultiple(WebElement element) {

			Select s = new Select(element);
			boolean multiple = s.isMultiple();
			return multiple;
		}

		public static void deselectOptionsByText(WebElement element, String text) {

			Select s = new Select(element);
			s.deselectByVisibleText(text);
		}

		public static void deselectOptionsByAttribute(WebElement element, String value) {

			Select s = new Select(element);
			s.deselectByValue(value);
		}

		public static void deselectOptionsByIndex(WebElement element, int index) {

			Select s = new Select(element);
			s.deselectByIndex(index);
		}

		public static void deselectAll(WebElement element) {

			Select s = new Select(element);
			s.deselectAll();
		}

		public static void typeJs(String data, WebElement element) {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0],setAttribute('value'," + data + "')", element);

		}

		public static Object getAttributeJs(WebElement element) {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			Object attribute = js.executeScript("return arguments[0],setAttribute('value')", element);
			return attribute;
		}

		public static void clickJs(WebElement element) {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()')", element);

		}

		public static void scrollDownJs(WebElement element) {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0],scrollIntoView(true)", element);

		}

		public static void scrollUpJs(WebElement element) {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0],scrollIntoView(false)", element);

		}

		public static void launchUrlNavigate(String url) {

			driver.navigate().to(url);
		}

		public static void launchUrlNavigateBackward(String url) {

			driver.navigate().back();
		}

		public static void launchUrlNavigateForward(String url) {

			driver.navigate().forward();
		}

		public static void launchUrlNavigateReload(String url) {

			driver.navigate().refresh();
		}
		
		public static void closeAllWindow() {
			
			driver.quit();
		}
		
		public static void closeCurrentWindow() {
			
			driver.close();
		}

		public static void actionsMouseOverAction(WebElement element) {

			Actions a = new Actions(driver);
			a.moveToElement(element).perform();
		}

		public static void actionsDragAndDrop(WebElement source, WebElement target) {

			Actions a = new Actions(driver);
			a.dragAndDrop(source, target);
		}

		// public static void robotKeyPress(String keycode) throws AWTException {
		//
		// Robot r = new Robot();
		// r.keyPress(keycode);
		// }
		//
		// public static void robotKeyRelease(String key) throws AWTException {
		//
		// Robot r = new Robot();
		// r.keyRelease(KeyEvent.key);
		// }

		public static void actionsDoubleClick(WebElement element) {

			Actions a = new Actions(driver);
			a.doubleClick(element).perform();
			;
		}

		public static void actionsRightClick(WebElement element) {

			Actions a = new Actions(driver);
			a.contextClick(element).perform();
		}

		public static Alert simpleAlert() {

			Alert al = driver.switchTo().alert();
			al.accept();
			return al;
		}

		// public Alert confirmAlert() {
		//
		// Alert al = driver.switchTo().alert();
		// al.accept();
		// al.dismiss();
		// return al;
		// }

		// public Alert promptAlert(String text) {
		//
		// Alert al = driver.switchTo().alert();
		// al.sendKeys(text);
		// al.accept();
		// return al;
		// }

		public static File screenshotGetScreenshot(String location) throws IOException {

			TakesScreenshot ts = (TakesScreenshot) driver;
			File file = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File(location);
			FileUtils.copyFile(file, dest);
			return file;
		}

		public static void implicitWait(int duration) {

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
		}

		public static WebDriverWait webDriverWait(int duration,WebElement element) {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
			wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
			return wait;
		}

		public static Wait<WebDriver> fluentWait(int timeOutDuration, int pollingDuration) {

			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOutDuration))
					.pollingEvery(Duration.ofSeconds(pollingDuration)).ignoring(NoSuchElementException.class);
			return wait;
		}

		public static void switchToFrameId(String id) {

			driver.switchTo().frame(id);
		}

		public static void switchToFrameName(String name) {

			driver.switchTo().frame(name);
		}

		public static void switchToFrameElement(WebElement element) {

			driver.switchTo().frame(element);
		}

		public static void switchToFrameIndex(int index) {

			driver.switchTo().frame(index);
		}

		public static void switchToFrameDefault() {

			driver.switchTo().defaultContent();
		}

		public static void switchToFrameParent() {

			driver.switchTo().parentFrame();
		}

		public static void switchToWindowUrl(String url) {

			driver.switchTo().window(url);
		}

		public static void switchToWindowTitle(String title) {

			driver.switchTo().window(title);
		}

		public static void switchToWindowWindowsId(String WindowsId) {

			driver.switchTo().window(WindowsId);
		}

		public static String getWindowHandle() {

			String windowId = driver.getWindowHandle();
			return windowId;
		}

		public static Set<String> getWindowHandles() {

			Set<String> allwindowId = driver.getWindowHandles();
			return allwindowId;
		}

	}
