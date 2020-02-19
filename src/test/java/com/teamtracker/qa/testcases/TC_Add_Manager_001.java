package com.teamtracker.qa.testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.teamtracker.qa.base.BaseClass;
import com.teamtracker.qa.pages.Home_Page;
import com.teamtracker.qa.pages.LoginPage;
import com.teamtracker.qa.pages.Manager_Page;
import com.teamtracker.qa.util.XLUtils;

import methods.methods;

public class TC_Add_Manager_001 extends BaseClass
{

	@Test(dataProvider="Data")
	public void Add_Manager(String name,String num, String email,String empid,String username) throws InterruptedException
	{
		methods method = new methods();
		
		
		method.login();

		Home_Page hp = new Home_Page(driver);
		hp.click_on_admin_menu();

		hp.click_on_manager_menu();

		Manager_Page  manager_page = new Manager_Page(driver); 

		manager_page.click_on_add_button();

		manager_page.enter_manager_name(name);
		
		manager_page.enter_manager_number(num);

		manager_page.enter_manager_email(email);

		manager_page.enter_manager_employee_id(empid);

		manager_page.enter_manager_username(username);

		manager_page.click_on_select_org_unit_dropdown();

		manager_page.click_on_checkbox_LG_Maharashtra_from_org_unit_dropdown();

		manager_page.click_on_save_button();		
	}





	@DataProvider(name="Data")
	String [][] getData() throws IOException

	{
		String path=System.getProperty("user.dir")+"/src/main/java/com/teamtracker/qa/testdata/Data.xlsx";

		int rownum=XLUtils.getRowCount(path, "Add Manager");
		int colcount=XLUtils.getCellCount(path,"Add Manager",1);

		String logindata[][]=new String[rownum][colcount];

		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Add Manager", i,j);//1 0
			}

		}
		return logindata;
	}


}
