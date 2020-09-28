package com.teamtracker.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.teamtracker.qa.base.BaseClass;
import com.teamtracker.qa.pages.Home_Page;
import com.teamtracker.qa.pages.Organization_Page;
import com.teamtracker.qa.pages.Organization_Setup;
import com.teamtracker.qa.util.XLUtils;

import methods.methods;

public class TC_Add_Organization_HIerarchy_001 extends BaseClass
{
	@Test(dataProvider="Data")
	public void Add_Organization_Hierarchy(String hierarchy_name) throws InterruptedException
	{
		//methods method = new methods();

		//method.login();
		
		driver.findElement(By.id("user")).sendKeys("pratikhoodtest6@gmail.com");
		driver.findElement(By.id("password")).sendKeys("tech8092");
		driver.findElement(By.xpath("//button[@class='btn btn-block btn-info-custom margin-top-04']")).click();
		

		Home_Page hp = new Home_Page(driver);
		hp.click_on_admin_menu();

		Organization_Page Organization_Page = new Organization_Page(driver);
		
		Organization_Page.click_on_setting_menu();
		
		Organization_Page.click_on_plus_button();
		
		Organization_Page.enter_hierarchy_name(hierarchy_name);
		
		Organization_Page.click_on_add_button();
		
		
		
		
	}
	
	@DataProvider(name="Data")
	String [][] getData() throws IOException

	{
		String path=System.getProperty("user.dir")+"/src/main/java/com/teamtracker/qa/testdata/Data.xlsx";

		int rownum=XLUtils.getRowCount(path, "Add Organization Hierarchy");
		int colcount=XLUtils.getCellCount(path,"Add Organization Hierarchy",1);

		String logindata[][]=new String[rownum][colcount];

		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Add Organization Hierarchy", i,j);//1 0
			}

		}
		return logindata;
	}
}
