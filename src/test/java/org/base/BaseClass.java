
package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.Action;
import javax.swing.text.Element;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	

	WebDriver driver;
	public void getDriver() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	
	
	public void getUrl(String url) {
		driver.get(url);
		
	}
	
	public void Navigatorurl(String url) {
		driver.navigate().to(url);

	}
	
	public List<WebElement> SelectAllOptions(WebElement elements) {
	Select select = new Select(elements);
	List<WebElement> options = select.getOptions();
	return options;

	}
	
	public List<WebElement> SelectAllSelectedOptions(WebElement elements) {
		
		Select select = new Select(elements);
		List<WebElement> options = select.getAllSelectedOptions();
		return options;
		
		

	}
	
	public WebElement FirstSelectedOptions(WebElement element) {
		Select select = new Select(element);
	    WebElement firstSelectedOption = select.getFirstSelectedOption();
		return firstSelectedOption;

	}
	
	public boolean ISMultiple(WebElement element) {
	Select select = new Select(element);
	boolean multiple = select.isMultiple();
	return multiple;

	}
	
	public void deSelectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByValue(value);
	}
	
	public void deSelectByVisisbleText(WebElement element, String text) {
		
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}
	
	public void deSelectByIndex(WebElement element, int index) {
		
		Select select = new Select(element);
		select.deselectByIndex(index);
	
	}
	
	public void deSelect(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();	

	}
	
	
	public void navigatorurl(String url) {
		driver.navigate().to(url);

	}
	
	public void MoveToElement(WebElement element) {
	
		Actions action = new Actions (driver);
		
		action.moveToElement(element).perform();
		

	}
	
	public void Contextclick() {
      Actions action = new Actions (driver);
		
		action.contextClick().perform();

	}
	
	public void doubleclick() {
		 Actions action = new Actions (driver);
		 action.doubleClick().perform();

	}
	
	public void draganddrop(WebElement source,WebElement target) {
		
		 Actions action = new Actions (driver);
	
		action.dragAndDrop(source, target).perform();
		

	}
	
	public void WindowHandle(String nameOrHandle) {
		
		driver.switchTo().window(nameOrHandle);

	}
	
	public void Frames(String index) {
		driver.switchTo().frame(index);

	}
	
	public void Navigatorback() {
		driver.navigate().back();

	}
	
	public void Navigatorforward() {
		driver.navigate().forward();

	}
	
	public void Navigatorrefresh() {
		driver.navigate().refresh();

	}
	
	public void Sleep() throws Exception {
		Thread.sleep(3000);

	}
	
	public void RoboPress(int arg0) throws AWTException {
		Robot r = new Robot();
		r.keyPress(arg0);
	}
	
	public void Roborelese(int keycode) throws AWTException {
		Robot r = new Robot();
		r.keyRelease(keycode);
	}
	
	public void keyup(CharSequence key) {
		
		Actions action = new Actions (driver);
		action.keyUp(key);
	}
	
	public void keydown(CharSequence key) {
		
		Actions action = new Actions (driver);
		action.keyDown(key);
	}
	
	public void screeshot(OutputType<Object> target) {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		screenshot.getScreenshotAs(target);

	}
	
	public void copy(File srcFile,File destFile) throws Exception {
	
		FileUtils.copyFile(srcFile, destFile);
				

	}
	
	public int Scannernextint() {
		Scanner s = new Scanner(System.in);
		int nextInt = s.nextInt();
		return nextInt;

	}
	
	public void printout() {
		System.out.println();

	}
	
	public void Frames() {
		driver.switchTo().defaultContent();

	}
	
	public String windowhandle() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;

	}
	
	public Set windowhandles() {
		Set<String> windowHandle = driver.getWindowHandles();
		return windowHandle;
		

	}
	
	public void waits(long sec,TimeUnit unit  ) {
		driver.manage().timeouts().implicitlyWait(sec, unit);

	}
	
public String getData(String value,String sheetName,int rowNo, int cellIndex) throws IOException {
	String data = null;
	
	File file =new File(value);
	FileInputStream stream=new FileInputStream(file);
	
Workbook workbook = new XSSFWorkbook(stream);
	
	Sheet sheet = workbook.getSheet(sheetName);
	
	 Row row = sheet.getRow(rowNo);
	 
	 Cell cell = row.getCell(cellIndex);
	 
	 int type = cell.getCellType();
	 
	 if(type==1) {
		data = cell.getStringCellValue();
	 }
	if(type==0) {
		if(DateUtil.isCellDateFormatted(cell)) {
			Date date = cell.getDateCellValue();
			SimpleDateFormat dateformat=new SimpleDateFormat("dd-MM-yyyy");
		 data = dateformat.format(date);
		 
		}
		
		else {
			double d = cell.getNumericCellValue();
			long l=(long)d;
			data=String.valueOf(l);
			
		}
	}
	 return data;
	 
	

}

 public void updateData(String value, String sheetName, int rowNo,int cellNo, String newData ) throws IOException
 {
	 
		
		File file =new File(value);
		FileInputStream stream=new FileInputStream(file);
		
	Workbook workbook = new XSSFWorkbook(stream);
		
		Sheet sheet = workbook.getSheet(sheetName);
		
		 Row row = sheet.getRow(rowNo);
		 
		 Cell cell = row.createCell(cellNo);
		 
		 cell.setCellValue(newData);
		 
		 FileOutputStream stream1=new FileOutputStream(file);
		 
		 workbook.write(stream1);
		 
		
	 
 }
 
 public void impWait(long time,TimeUnit hrs  ) {
	 driver.manage().timeouts().implicitlyWait(time, hrs);
	 
	 
 }
 
 
 public String getAttributeValue(WebElement element,String value) {
	 String attribute = element.getAttribute(value);
	 return attribute;
	 }

public void DateForm(Date data) {
	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yy");

	String format = dateformat.format(data);
	

}

public void loadurl(String url) {
	driver.get(url);

}

public void type(WebElement element, String data) {
	
	element.sendKeys(data);

}


public void click(WebElement element) {
	
	element.click();
	

}

public String getText(WebElement element) {
	
	String text = element.getText();
	return text;
	

}

public WebElement findElementById(String id) {
	

	WebElement element = driver.findElement(By.id(id));
	return element;

}

public WebElement findElementByName(String name) {

	WebElement element = driver.findElement(By.name(name));
	return element;

}


public WebElement findElementByClass(String className) {
	 
	
	WebElement element = driver.findElement(By.className(className));
	return element;

}

public WebElement findElementByXpath(String xpathExpression) {
	

	WebElement element = driver.findElement(By.xpath(xpathExpression));
	return element;

}
public void maximize() {
	
	driver.manage().window().maximize();

}

public void alertOk() {
	Alert alert = driver.switchTo().alert();
	alert.accept();

}

public void alertCancel() {
	Alert alert = driver.switchTo().alert();
	alert.dismiss();
	
}

public void closeAllWindow() {
	driver.quit();

}

public void closeCurrentWindow() {
	driver.close();

}

public String getTitle() {
	
	String title = driver.getTitle();
	return title;

}

public void getCurrentUrl() {
	driver.getCurrentUrl();

}

public void selectOptionByText(WebElement element, String text) {
	
	new Select (element).selectByVisibleText(text);
	

}

public void selectOptionByValue(WebElement element,String value) {
	
	new Select(element).selectByValue(value);
	

}

public void selectOptionByIndex(WebElement element,int index) {
	
	new Select(element).selectByIndex(index);


}

public void setAttribute(WebElement element,String data) {
	
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].setAttribute('value',"+data+"'))", element);

}

public void getAttribute(WebElement element) {
	
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("return arguments[0].getAttribute('value')", element);


}

public void scrollIntoView(WebElement element) {
	
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("argument[0].scrollIntoView(true)", element);


}

public void scrollIntoView2(WebElement element) {
	
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("argument[0].scrollIntoView(false)", element);

}

public void jsClick(WebElement element) {
	
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("argument[0].click", element);

}

}

		
	
	
	


