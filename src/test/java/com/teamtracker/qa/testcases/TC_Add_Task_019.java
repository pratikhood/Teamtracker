package com.teamtracker.qa.testcases;

import java.io.IOException;

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

public class TC_Add_Task_019 extends BaseClass
{
	@Test(dataProvider="Data")
	public void Add_POI(String title_name, String task_id, String Task_address, String latitude, String longitude) throws InterruptedException
	{
		methods method = new methods();


		method.login();

		Home_Page hp = new Home_Page(driver);

		hp.click_on_task_menu();

		Task_Page Task_Page = new Task_Page(driver);
		
		Task_Page.click_on_add_button();
		
		Task_Page.enter_title(title_name);
		
		Task_Page.enter_task_id(task_id);
		
		Task_Page.enter_address(Task_address);
		
		Task_Page.enter_latitude(latitude);
		
		Task_Page.enter_longitude(longitude);
		
		Task_Page.click_on_save_button();
	}


	@DataProvider(name="Data")
	String [][] getData() throws IOException

	{
		String path=System.getProperty("user.dir")+"/src/main/java/com/teamtracker/qa/testdata/Data.xlsx";

		int rownum=XLUtils.getRowCount(path, "Add Task");
		int colcount=XLUtils.getCellCount(path,"Add Task",1);

		String logindata[][]=new String[rownum][colcount];

		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Add Task", i,j);//1 0
			}

		}
		return logindata;
	}



}
