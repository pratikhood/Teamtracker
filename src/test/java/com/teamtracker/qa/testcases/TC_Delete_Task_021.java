package com.teamtracker.qa.testcases;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.teamtracker.qa.base.BaseClass;
import com.teamtracker.qa.pages.Home_Page;
import com.teamtracker.qa.pages.POI_Page;
import com.teamtracker.qa.pages.Task_Page;
import com.teamtracker.qa.util.XLUtils;

import methods.methods;

public class TC_Delete_Task_021 extends BaseClass
{
	@Test(dataProvider="Data")
	public void Delete_Task(String title_name,String desription,String task_id, String Task_address, String latitude, String longitude) throws InterruptedException
	{
		Logger logger = Logger.getLogger("Teamtracker");
		PropertyConfigurator.configure("Log4j.properties");

		methods method = new methods();


		method.login();

		Home_Page hp = new Home_Page(driver);

		hp.click_on_task_menu();

		Task_Page Task_Page = new Task_Page(driver);

		Task_Page.click_on_add_button();

		Task_Page.enter_title(title_name);
		
		Task_Page.enter_description(desription);

		Task_Page.enter_task_id(task_id);

		Task_Page.enter_address(Task_address);

		Task_Page.enter_latitude(latitude);

		Task_Page.enter_longitude(longitude);

		Task_Page.click_on_save_button();


		String before_xpath = "//table[@id='taskTableViewTable']//tbody/tr[";
		String after_xpath = "]/td[1]//span[3]//a";

		String a = "//table[@id='taskTableViewTable']//tbody/tr[";
		String b = "]/td[5]//button[2]";

		


		List<WebElement> POIs = driver.findElements(By.xpath("//table[@id='taskTableViewTable']//tbody/tr/td[1]//span[3]//a"));

		int count_of_Tsks= POIs.size();

		System.out.println("count_of_Tasks : "+count_of_Tsks);

		Thread.sleep(2000);


		for(int i=1;i<=count_of_Tsks;i++)
		{
			Thread.sleep(500);

			logger.info("Entered in first for loop");

			String d = before_xpath+i+after_xpath;
			String Taks_IDs = driver.findElement(By.xpath(d)).getText();

			logger.info("Available Tasks :"+Taks_IDs);

			Thread.sleep(500);

			if (Taks_IDs.contains("abc0001")) 
			{ 
				logger.info("Entered in if loop");

				//click on elipses
				driver.findElement(By.xpath(a+i+b)).click();	
	
				Thread.sleep(3000);
				
				Task_Page.click_on_OK_button();
				
				

				
				

				break;
			}
		}
	}


	@DataProvider(name="Data")
	String [][] getData() throws IOException

	{
		String path=System.getProperty("user.dir")+"/src/main/java/com/teamtracker/qa/testdata/Data.xlsx";

		int rownum=XLUtils.getRowCount(path, "Delete Task");
		int colcount=XLUtils.getCellCount(path,"Delete Task",1);

		String logindata[][]=new String[rownum][colcount];

		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Delete Task", i,j);//1 0
			}

		}
		return logindata;
	}



}
