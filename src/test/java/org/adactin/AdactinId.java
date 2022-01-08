package org.adactin;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;

public class AdactinId {
	public static void main(String[] args) throws IOException, InterruptedException {
		BaseClass b=new BaseClass();
		
		b.getDriver();
		b.maximize();
		b.impWait(30, TimeUnit.SECONDS);
		b.getUrl("https://adactinhotelapp.com/index.php");
		
		WebElement txtuser = b.findElementById("username");
		
		String txt = b.getData("C:\\Users\\Jeeva\\eclipse-workspace\\MavenBase\\Excel1\\adact.xlsx", "Input", 1, 0);
		//System.out.println(data);
		
		b.type(txtuser,txt );
		
		WebElement txtpass = b.findElementById("password");
		
		String pass = b.getData("C:\\Users\\Jeeva\\eclipse-workspace\\MavenBase\\Excel1\\adact.xlsx", "Input", 1, 1);
		
		b.type(txtpass, pass);
		
		WebElement btnLogin = b.findElementById("login");
		
		
		b.click(btnLogin);
		
		
		WebElement location = b.findElementById("location");
		b.selectOptionByIndex(location, 1);
		
		
		WebElement dDnhotel = b.findElementById("hotels");
		b.selectOptionByIndex(dDnhotel, 1);
		
		
		
		
		WebElement dDnroom = b.findElementById("room_type");
		
		b.selectOptionByIndex(dDnroom, 1);
		
		WebElement dDnroomNos = b.findElementById("room_nos");
		
		b.selectOptionByIndex(dDnroomNos, 1);
		
//		WebElement dateIn = b.findElementById("datepick_in");
//		String datein = b.getData("C:\\Users\\Jeeva\\eclipse-workspace\\MavenBase\\Excel1\\adact.xlsx", "Input", 1,2 );
//		
//		b.setAttribute(dateIn, datein);
//		
//		
//		WebElement dateOut = b.findElementById("datepick_out");
//		String dataout = b.getData("C:\\Users\\Jeeva\\eclipse-workspace\\MavenBase\\Excel1\\adact.xlsx", "Input", 1, 3);
//		b.setAttribute(dateOut, dataout );
		
		
		WebElement people = b.findElementById("adult_room");
		
		b.selectOptionByIndex(people, 2);
		
		
		WebElement child = b.findElementById("child_room");
		
		b.selectOptionByIndex(child, 2);

		
		
		WebElement btnSubmit = b.findElementById("Submit");
		
		b.click(btnSubmit);
			
		WebElement radbtn = b.findElementById("radiobutton_0");
		
		b.click(radbtn);
		
		
		WebElement btncnt = b.findElementById("continue");
		b.click(btncnt);
		
		WebElement txtfirst = b.findElementById("first_name");
		String data = b.getData("C:\\Users\\Jeeva\\eclipse-workspace\\MavenBase\\Excel1\\adact.xlsx", "Input", 1, 4);
		b.type(txtfirst, data);
		
		
	    WebElement txtlast = b.findElementById("last_name");
		
	    String data2 = b.getData("C:\\Users\\Jeeva\\eclipse-workspace\\MavenBase\\Excel1\\adact.xlsx", "Input", 1, 5);
		
		
		
		b.type(txtlast, data2);
		
		WebElement txtaddress = b.findElementById("address");
		
		String data3 = b.getData("C:\\Users\\Jeeva\\eclipse-workspace\\MavenBase\\Excel1\\adact.xlsx", "Input", 1, 6);
		
		
		b.type(txtaddress, data3);
		
		WebElement txtCC = b.findElementById("cc_num");
		
		String data4 = b.getData("C:\\Users\\Jeeva\\eclipse-workspace\\MavenBase\\Excel1\\adact.xlsx", "Input", 1, 7);
		
		b.type(txtCC, data4);
		
		WebElement dDnccty = b.findElementById("cc_type");
		b.selectOptionByIndex(dDnccty, 1);
		
		WebElement dDnccmon = b.findElementById("cc_exp_month");
		b.selectOptionByIndex(dDnccmon, 7);
		
		WebElement dDnccyr = b.findElementById("cc_exp_year");
		b.selectOptionByIndex(dDnccyr, 7);
		
		WebElement txtcvv = b.findElementById("cc_cvv");
		
		String data5 = b.getData("C:\\Users\\Jeeva\\eclipse-workspace\\MavenBase\\Excel1\\adact.xlsx", "Input", 1, 8);
		
		b.type(txtcvv, data5);
		
		WebElement btnbook = b.findElementById("book_now");
		b.click(btnbook);
		
		//Thread.sleep(9000);
		
		
		WebElement txtorder = b.findElementById("order_no");
		
		String orderId = b.getAttributeValue(txtorder,"value");
		
		System.out.println(orderId);
		
		b.updateData("C:\\Users\\Jeeva\\eclipse-workspace\\MavenBase\\Excel1\\adact.xlsx", "Input", 1, 9, orderId);
		

		
		
		
		
		
		
		
		//String attribute = txtorder.getAttribute("value");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
		
		
		
	}

}
