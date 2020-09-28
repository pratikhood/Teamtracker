package com.teamtracker.qa.testcases;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.teamtracker.qa.base.BaseClass;
import com.teamtracker.qa.pages.Home_Page;
import com.teamtracker.qa.pages.Organization_Setup;
import com.teamtracker.qa.util.XLUtils;

import methods.methods;

public class TC_Add_Organization_Unit_002 extends BaseClass
{
	@Test(dataProvider="Data")
	public void Add_Organization_Unit(String id,String name, String addr,String lat,String lon, String minimumTask) throws InterruptedException
	{
		
		Logger logger = Logger.getLogger("Teamtracker");
		PropertyConfigurator.configure("Log4j.properties");

		/*
		methods method = new methods();

		method.login();
		*/
		
		driver.findElement(By.id("user")).sendKeys("pratikhoodtest6@gmail.com");
		driver.findElement(By.id("password")).sendKeys("tech8092");
		driver.findElement(By.xpath("//button[@class='btn btn-block btn-info-custom margin-top-04']")).click();
		
		
		Home_Page hp = new Home_Page(driver);
		hp.click_on_admin_menu();
		
		hp.click_on_oranization_setup_menu();

		Organization_Setup Organization_Setup = new Organization_Setup(driver);
		
		
		
		
		Organization_Setup.click_on_add_button();
		
		Organization_Setup.enter_organization_unit_id(id);
		
		Organization_Setup.enter_organization_unit_name(name);
		
		Organization_Setup.enter_organization_unit_address(addr);
		
		Organization_Setup.enter_organization_unit_latitude(lat);
		
		Organization_Setup.enter_organization_unit_longitude(lon);
		
		Organization_Setup.click_on_organization_unit_type_dropdown();
		
		Organization_Setup.select_state_from_organization_unit_type_dropdown();
		
		Organization_Setup.click_on_parent_organization_unit_type_dropdown();
		
		Organization_Setup.select_Alpha_Org_from_organization_unit_type_dropdown();
		
		Organization_Setup.enter_minimum_task_per_team_member(minimumTask);
		
		Organization_Setup.click_on_save_button();
		
		
		
		
		
		
	}
	
	@DataProvider(name="Data")
	String [][] getData() throws IOException

	{
		String path=System.getProperty("user.dir")+"/src/main/java/com/teamtracker/qa/testdata/Data.xlsx";

		int rownum=XLUtils.getRowCount(path, "Add Organization Unit");
		int colcount=XLUtils.getCellCount(path,"Add Organization Unit",1);

		String logindata[][]=new String[rownum][colcount];

		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Add Organization Unit", i,j);//1 0
			}

		}
		return logindata;
	}
}
