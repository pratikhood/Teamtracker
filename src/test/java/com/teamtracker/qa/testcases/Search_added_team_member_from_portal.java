package com.teamtracker.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.teamtracker.qa.base.BaseClass;
import com.teamtracker.qa.pages.Home_Page;
import com.teamtracker.qa.pages.LoginPage;
import com.teamtracker.qa.pages.Manager_Page;
import com.teamtracker.qa.pages.Team_Setup;
import com.teamtracker.qa.util.XLUtils;

import methods.methods;

public class Search_added_team_member_from_portal extends BaseClass
{

	@Test(dataProvider="Data")
	public void Search_team_member(String name) throws InterruptedException
	{
		methods method = new methods();
		
		method.login();

		Home_Page hp = new Home_Page(driver);
		hp.click_on_admin_menu();

		hp.click_on_team_setup();

		Team_Setup Team_Setup = new Team_Setup(driver);
		
		Team_Setup.enter_Suresh_Chavhan_in_search_box(name);
		
		String rowCount = driver.findElement(By.id("totalTblRecords")).getText();
		
		Assert.assertEquals(rowCount, "1");
				
	}





	@DataProvider(name="Data")
	String [][] getData() throws IOException

	{
		String path=System.getProperty("user.dir")+"/src/main/java/com/teamtracker/qa/testdata/Data.xlsx";

		int rownum=XLUtils.getRowCount(path, "Search Team Member");
		int colcount=XLUtils.getCellCount(path,"Search Team Member",1);

		String logindata[][]=new String[rownum][colcount];

		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Search Team Member", i,j);//1 0
			}

		}
		return logindata;
	}


}
