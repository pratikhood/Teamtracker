package com.teamtracker.qa.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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

public class TC_Import_Organization_Unit_005 extends BaseClass
{


	@Test
	public void Import_Organization_Unit() throws InterruptedException, Exception
	{
		Robot robot = new Robot();

		Logger logger = Logger.getLogger("Teamtracker");
		PropertyConfigurator.configure("Log4j.properties");

		logger.info("Entered in test case");

		methods method = new methods();

		method.login();

		Home_Page hp = new Home_Page(driver);
		hp.click_on_admin_menu();

		
		
		
		
		Organization_Setup Organization_Setup = new Organization_Setup(driver);		

		Organization_Setup.click_on_import_button();
		
		Organization_Setup.click_on_choose_file_button();


		StringSelection stringSelection = new StringSelection("C:\\Users\\91888\\Desktop\\centres.xlsx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		robot.setAutoDelay(1000);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		robot.setAutoDelay(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		robot.setAutoDelay(1000);
		
		Organization_Setup.click_on_upload_button();
		
		
		Thread.sleep(3000);
		
		Organization_Setup.click_on_OK_button();
		
		
		
		




	}
	/*
		Thread.sleep(1000);

		String before_xpath = "//table[@id='serviceCentreTable']//tr[";
		String after_xpath = "]/td[1]";

		String a = "//table[@id='serviceCentreTable']//tr[";
		String b = "]/td[5]/div/label/span";

		String e = "//table[@id='serviceCentreTable']//tr[";
		String f="]/td[5]//button[1]/span";


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

			if (org_unit_name.contains("LG_Org")) 
			{ 
				logger.info("Entered in if loop");

				//click on elipses
				driver.findElement(By.xpath(a+i+b)).click();			

				//click on modify button
				driver.findElement(By.xpath(e+i+f)).click();

				Organization_Setup.clear_minimum_task_per_team_member();

				Organization_Setup.enter_modified_minimum_task_per_team_member(modifiedMinimumTaskPerTeamMember);

				Organization_Setup.click_on_save_button();

				break;
			}


		}




	}
	 */


}