package com.teamtracker.qa.testcases;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.teamtracker.qa.base.BaseClass;
import com.teamtracker.qa.pages.Form_Page;
import com.teamtracker.qa.pages.Home_Page;
import com.teamtracker.qa.pages.Manager_Page;
import com.teamtracker.qa.pages.POI_Page;
import com.teamtracker.qa.util.XLUtils;

import methods.methods;

public class TC_Modify_POI_015 extends BaseClass
{



	@Test(dataProvider="Data")
	public void Add_POI(String poi_name, String poi_addr, String modified_POI_name) throws InterruptedException
	{
		Logger logger = Logger.getLogger("Teamtracker");
		PropertyConfigurator.configure("Log4j.properties");

		methods method = new methods();


		method.login();

		Home_Page hp = new Home_Page(driver);

		hp.click_on_POI_menu();

		POI_Page POI_Page = new POI_Page(driver);

		// Right click the button to launch right click menu options
		Actions action = new Actions(driver);

		WebElement link = driver.findElement(By.xpath("//div[@id='mapDiv']"));
		action.contextClick(link).perform();

		Thread.sleep(3000);

		POI_Page.enter_poi_name(poi_name);

		POI_Page.enter_poi_addr(poi_addr);

		POI_Page.click_on_POI_category();

		POI_Page.select_Airport_from_POI_category();

		Select sources = new Select(driver.findElement(By.id("add-poi-status")));
		sources.selectByVisibleText("Active");

		POI_Page.click_on_add_button();

		//click on OK button
		driver.findElement(By.xpath("//button[@class='confirm']")).click();


		String before_xpath = "//table[@id='poiTable']//tbody//tr[";
		String after_xpath = "]/td[1]";

		String a = "//table[@id='poiTable']//tbody//tr[";
		String b = "]/td[5]/div[1]";

		String x = "//table[@id='poiTable']//tbody//tr[";
		String y = "]/td[5]//span[@class='fa fa-pencil']";



		List<WebElement> POIs = driver.findElements(By.xpath("//table[@id='poiTable']//tbody//tr/td[1]"));

		int count_of_POIs= POIs.size();

		System.out.println("count_of_POIs : "+count_of_POIs);

		Thread.sleep(2000);


		for(int i=1;i<=count_of_POIs;i++)
		{
			Thread.sleep(500);

			logger.info("Entered in first for loop");

			String d = before_xpath+i+after_xpath;
			String POIs_names = driver.findElement(By.xpath(d)).getText();

			logger.info("Available POIs :"+POIs_names);

			Thread.sleep(500);

			if (POIs_names.contains("ABC POI")) 
			{ 
				logger.info("Entered in if loop");

				//click on elipses
				driver.findElement(By.xpath(a+i+b)).click();	

				//click on modify
				driver.findElement(By.xpath(x+i+y)).click();


				POI_Page.clear_name_field();


				POI_Page.enter_poi_name(modified_POI_name);

				POI_Page.click_on_modify_button();

				POI_Page.click_on_OK_button();
				
				break;
			}
		}
	}


	@DataProvider(name="Data")
	String [][] getData() throws IOException

	{
		String path=System.getProperty("user.dir")+"/src/main/java/com/teamtracker/qa/testdata/Data.xlsx";

		int rownum=XLUtils.getRowCount(path, "Modify POI");
		int colcount=XLUtils.getCellCount(path,"Modify POI",1);

		String logindata[][]=new String[rownum][colcount];

		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Modify POI", i,j);//1 0
			}

		}
		return logindata;
	}


}
