package com.teamtracker.qa.testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.teamtracker.qa.base.BaseClass;
import com.teamtracker.qa.pages.Home_Page;
import com.teamtracker.qa.pages.Task_Page;
import com.teamtracker.qa.util.XLUtils;

import methods.methods;

public class Assign_Task_To_Mobile extends BaseClass
{
	@Test(dataProvider="Data")
	public void Verify_team_member_able_to_do_Activity_on_task(String title_name, String task_id, String Task_address,String latitude, String longitude )
	{
		
			methods method = new methods();
			
			
			method.login();
			
			
			Home_Page home_page = new Home_Page(driver);
			
			home_page.click_on_task_menu();
			
			Task_Page task_page = new Task_Page(driver);
			
			task_page.click_on_add_button();
			
			task_page.enter_title(title_name);
			
			task_page.click_on_assign_to_dropdown();
			
			task_page.select_pratik_hood_from_assing_to_dropdown();
			
			task_page.enter_task_id(task_id);
			
			task_page.enter_address(Task_address);
			
			task_page.enter_latitude(latitude);
			
			task_page.enter_longitude(longitude);
			
			task_page.click_on_save_button();
			
			
			
					
		}





		@DataProvider(name="Data")
		String [][] getData() throws IOException

		{
			String path=System.getProperty("user.dir")+"/src/main/java/com/teamtracker/qa/testdata/Data.xlsx";

			int rownum=XLUtils.getRowCount(path, "Task");
			int colcount=XLUtils.getCellCount(path,"Task",1);

			String logindata[][]=new String[rownum][colcount];

			for(int i=1;i<=rownum;i++)
			{
				for(int j=0;j<colcount;j++)
				{
					logindata[i-1][j]=XLUtils.getCellData(path,"Task", i,j);//1 0
				}

			}
			return logindata;
		}

		
	}


