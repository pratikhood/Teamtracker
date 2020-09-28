package com.teamtracker.qa.testcases;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.teamtracker.qa.base.BaseClass;
import com.teamtracker.qa.pages.Home_Page;
import com.teamtracker.qa.pages.Organization_Setup;
import com.teamtracker.qa.util.XLUtils;

import methods.methods;

public class TC_Delete_Organization_Unit_004 extends BaseClass
{
	
	
	@Test(dataProvider="Data")
	public void Delete_Organization_Unit(String id,String name, String addr,String lat,String lon, String minimumTask) throws InterruptedException
	{
		Logger logger = Logger.getLogger("Teamtracker");
		PropertyConfigurator.configure("Log4j.properties");
		
		logger.info("Entered in test case");
		
		methods method = new methods();

		method.login();
				
		Home_Page hp = new Home_Page(driver);
		hp.click_on_admin_menu();

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
		Thread.sleep(500);
		Organization_Setup.click_on_save_button();
		
		Thread.sleep(1000);
		 
		String before_xpath = "//table[@id='serviceCentreTable']//tr[";
		String after_xpath = "]/td[1]";
		
		String a = "//table[@id='serviceCentreTable']//tr[";
		String b = "]/td[5]/div/label/span";
		
		String e = "//table[@id='serviceCentreTable']//tr[";
		String f="]/td[5]//button[2]/span";
		
		
		List<WebElement> org_unit = driver.findElements(By.xpath("//table[@id='serviceCentreTable']//td[1]/span"));
		
		int count_of_organization_unit= org_unit.size();
		
		System.out.println("count_of_organization_unit_type : "+count_of_organization_unit);
		
		
		for(int i=1;i<=count_of_organization_unit;i++)
		{
			Thread.sleep(1000);
			
			logger.info("Entered in first for loop");

			String d = before_xpath+i+after_xpath;
			String org_unit_name = driver.findElement(By.xpath(d)).getText();

			logger.info("Available organization unit :"+org_unit_name);
			
			Thread.sleep(500);
			
			if (org_unit_name.contains("Lambent_Org")) 
			{ 
				logger.info("Entered in if loop");
				
				//click on elipses
				driver.findElement(By.xpath(a+i+b)).click();			
				
				//click on modify button
				driver.findElement(By.xpath(e+i+f)).click();
				Thread.sleep(3000);
				
				Organization_Setup.click_on_YES_button_confirm_button();
				
				break;
			}
		
		
		}
		
		
		
		
	}
	
	@DataProvider(name="Data")
	String [][] getData() throws IOException

	{
		String path=System.getProperty("user.dir")+"/src/main/java/com/teamtracker/qa/testdata/Data.xlsx";

		int rownum=XLUtils.getRowCount(path, "Delete Organization Unit");
		int colcount=XLUtils.getCellCount(path,"Delete Organization Unit",1);

		String logindata[][]=new String[rownum][colcount];

		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Delete Organization Unit", i,j);//1 0
			}

		}
		return logindata;
	}
}
