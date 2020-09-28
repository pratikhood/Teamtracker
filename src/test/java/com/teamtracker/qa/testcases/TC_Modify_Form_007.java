package com.teamtracker.qa.testcases;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.teamtracker.qa.base.BaseClass;
import com.teamtracker.qa.pages.Form_Page;
import com.teamtracker.qa.pages.Home_Page;
import com.teamtracker.qa.pages.Manager_Page;
import com.teamtracker.qa.util.XLUtils;

import methods.methods;

public class TC_Modify_Form_007 extends BaseClass
{
	@Test(dataProvider="Data")
	public void Add_Manager(String formName,String modifiedFormName) throws InterruptedException
	{
		Logger logger = Logger.getLogger("Teamtracker");
		PropertyConfigurator.configure("Log4j.properties");
		
		
		methods method = new methods();
		
		
		method.login();

		Home_Page hp = new Home_Page(driver);
		hp.click_on_admin_menu();
		hp.click_on_form_menu();
		
		
		
		Form_Page form_page = new Form_Page(driver);
		/*
		form_page.click_on_add_form_button();
		
		form_page.enter_form_name(formName);
		
		form_page.click_on_select_org_unit_dropdown();
		
		//Select sources = new Select(driver.findElement(By.id("sourceType")));
		//sources.selectByVisibleText("GPS");
		
		form_page.check_select_all_option();
		
		form_page.select_number_option();
		
		form_page.select_text_field_option();
		logger.info("Text field option selected");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;


        //Find element by link text and store in variable "Element"        		
        WebElement Element = driver.findElement(By.id("getData"));

        //This will scroll the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", Element);
		
		form_page.click_on_next_button();
		logger.info("Clicked on next button");
		
		form_page.click_on_save_button();	
		
		*/
		
		driver.findElement(By.xpath("//div[@id='organizationUnitSelect']//button[contains(@class,'ms-choice')]//div")).click();
		
		driver.findElement(By.xpath("//label[contains(text(),'Apha Org')]//input[@name='selectItemorganizationUnitSelect']")).click();
		
		
		
		
		String before_xpath = "//div[@id='formList']/div[";
		String after_xpath = "]/div[1]/h3/a";
		
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
				
				
				break;
			}
		
		
		}
		
		
		
}


	@DataProvider(name="Data")
	String [][] getData() throws IOException

	{
		String path=System.getProperty("user.dir")+"/src/main/java/com/teamtracker/qa/testdata/Data.xlsx";

		int rownum=XLUtils.getRowCount(path, "Form-Modify");
		int colcount=XLUtils.getCellCount(path,"Form-Modify",1);

		String logindata[][]=new String[rownum][colcount];

		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Form-Modify", i,j);//1 0
			}

		}
		return logindata;
	}


}
