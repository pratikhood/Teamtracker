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
import com.teamtracker.qa.pages.LoginPage;
import com.teamtracker.qa.pages.Manager_Page;
import com.teamtracker.qa.util.XLUtils;

import methods.methods;

public class TC_Delete_Manager_12 extends BaseClass
{

	@Test(dataProvider="Data")
	public void Modify_Manager(String name,String num, String email,String empid,String username) throws InterruptedException
	{
		Logger logger = Logger.getLogger("Teamtracker");
		PropertyConfigurator.configure("Log4j.properties");
		
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

		manager_page.select_alpha_org();

		manager_page.click_on_save_button();		
		
		Thread.sleep(1000);
		 
		String before_xpath = "//table[@id='managerTable']//tbody/tr[";
		String after_xpath = "]/td[2]/div[1]";
		
		String a = "//table[@id='managerTable']//tbody/tr[";
		String b = "]/td[1]/div[1]";
		
		
		
		List<WebElement> managers = driver.findElements(By.xpath("//table[@id='managerTable']//tbody/tr/td[2]/div[1]/*"));
		
		int count_of_managers= managers.size();
		
		System.out.println("count_of_managers : "+count_of_managers);
		
		Thread.sleep(2000);
		
		
		for(int i=1;i<=count_of_managers;i++)
		{
			Thread.sleep(500);
			
			logger.info("Entered in first for loop");

			String d = before_xpath+i+after_xpath;
			String manager_names = driver.findElement(By.xpath(d)).getText();

			logger.info("Available manager :"+manager_names);
			
			Thread.sleep(500);
			
			if (manager_names.contains("Suresh Chavhan")) 
			{ 
				logger.info("Entered in if loop");
				
				//click on radio button
				driver.findElement(By.xpath(a+i+b)).click();			
				
				manager_page.click_on_delete_button();
				
				Thread.sleep(1000);
				
				manager_page.click_on_OK_button();
				
				Thread.sleep(1000);
				break;
			}
		}}





	@DataProvider(name="Data")
	String [][] getData() throws IOException

	{
		String path=System.getProperty("user.dir")+"/src/main/java/com/teamtracker/qa/testdata/Data.xlsx";

		int rownum=XLUtils.getRowCount(path, "Delete Manager");
		int colcount=XLUtils.getCellCount(path,"Delete Manager",1);

		String logindata[][]=new String[rownum][colcount];

		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Delete Manager", i,j);//1 0
			}

		}
		return logindata;
	}


}
