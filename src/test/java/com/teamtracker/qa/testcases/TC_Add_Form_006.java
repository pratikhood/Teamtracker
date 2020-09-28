package com.teamtracker.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.teamtracker.qa.base.BaseClass;
import com.teamtracker.qa.pages.Form_Page;
import com.teamtracker.qa.pages.Home_Page;
import com.teamtracker.qa.pages.Manager_Page;
import com.teamtracker.qa.util.XLUtils;

import methods.methods;

public class TC_Add_Form_006 extends BaseClass
{
	@Test(dataProvider="Data")
	public void Add_Manager(String formName) throws InterruptedException
	{
		methods method = new methods();
		
		
		method.login();

		Home_Page hp = new Home_Page(driver);
		hp.click_on_admin_menu();
		hp.click_on_form_menu();
		
		Form_Page form_page = new Form_Page(driver);
		
		form_page.click_on_add_form_button();
		
		form_page.enter_form_name(formName);
		
		form_page.click_on_select_org_unit_dropdown();
		
		//Select sources = new Select(driver.findElement(By.id("sourceType")));
		//sources.selectByVisibleText("GPS");
		
		form_page.check_select_all_option();
		
		form_page.select_number_option();
		
		form_page.select_text_field_option();
		
		form_page.click_on_next_button();
		
		form_page.click_on_save_button();				
}


	@DataProvider(name="Data")
	String [][] getData() throws IOException

	{
		String path=System.getProperty("user.dir")+"/src/main/java/com/teamtracker/qa/testdata/Data.xlsx";

		int rownum=XLUtils.getRowCount(path, "Form - Add");
		int colcount=XLUtils.getCellCount(path,"Form - Add",1);

		String logindata[][]=new String[rownum][colcount];

		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Form - Add", i,j);//1 0
			}

		}
		return logindata;
	}


}
