package com.teamtracker.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.teamtracker.qa.base.PortalBaseClass;
import com.teamtracker.qa.pages.Home_Page;
import com.teamtracker.qa.pages.Organization_Page;
import com.teamtracker.qa.pages.Portal_Page;
import com.teamtracker.qa.util.XLUtils;

import methods.methods;
import methods.portal_method;

public class TC_Add_Team_Member_from_portal extends PortalBaseClass
{
	@Test(dataProvider="Data")
	public void Add_Team_Member(String first_name, String last_name, String mobile_number) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		portal_method portal_method = new portal_method();
		
		portal_method.portal_login();
		
		Portal_Page Portal_Page =  new Portal_Page(driver);
		
		Portal_Page.select_alpha_org();
		
		Portal_Page.click_on_modify_button();
		
		Portal_Page.click_on_employee_tab();
		
		Portal_Page.click_on_add_employee_button();
		
		Portal_Page.enter_first_name(first_name);
		
		Portal_Page.enter_last_name(last_name);
		
		Portal_Page.enter_mobile_number(mobile_number);
		
		//Portal_Page.click_on_source_type_dropdown();
		
		Select sources = new Select(driver.findElement(By.id("sourceType")));
		sources.selectByVisibleText("GPS");
		
		Portal_Page.click_on_save_button();
		
		
	}
	
	
	
	
	@DataProvider(name="Data")
	String [][] getData() throws IOException

	{
		String path=System.getProperty("user.dir")+"/src/main/java/com/teamtracker/qa/testdata/Data.xlsx";

		int rownum=XLUtils.getRowCount(path, "Team member portal");
		int colcount=XLUtils.getCellCount(path,"Team member portal",1);

		String logindata[][]=new String[rownum][colcount];

		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Team member portal", i,j);//1 0
			}

		}
		return logindata;
	}
}
