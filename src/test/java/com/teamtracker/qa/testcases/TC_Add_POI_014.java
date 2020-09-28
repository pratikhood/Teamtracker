package com.teamtracker.qa.testcases;

import java.io.IOException;

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

public class TC_Add_POI_014 extends BaseClass
{



	@Test(dataProvider="Data")
	public void Add_POI(String poi_name, String poi_addr) throws InterruptedException
	{
		methods method = new methods();


		method.login();

		Home_Page hp = new Home_Page(driver);

		hp.click_on_POI_menu();

		POI_Page POI_Page = new POI_Page(driver);

		// Right click the button to launch right click menu options
		Actions action = new Actions(driver);

		WebElement link = driver.findElement(By.xpath("//div[@id='mapDiv']"));
		action.contextClick(link).perform();

		POI_Page.enter_poi_name(poi_name);

		POI_Page.enter_poi_addr(poi_addr);
		
		POI_Page.click_on_POI_category();
		
		POI_Page.select_Airport_from_POI_category();
		
		Select sources = new Select(driver.findElement(By.id("add-poi-status")));
		sources.selectByVisibleText("Active");
		
		POI_Page.click_on_add_button();
	}


	@DataProvider(name="Data")
	String [][] getData() throws IOException

	{
		String path=System.getProperty("user.dir")+"/src/main/java/com/teamtracker/qa/testdata/Data.xlsx";

		int rownum=XLUtils.getRowCount(path, "add poi");
		int colcount=XLUtils.getCellCount(path,"add poi",1);

		String logindata[][]=new String[rownum][colcount];

		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"add poi", i,j);//1 0
			}

		}
		return logindata;
	}


}
