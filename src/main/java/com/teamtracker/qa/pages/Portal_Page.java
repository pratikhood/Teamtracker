package com.teamtracker.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Portal_Page 
{
	WebDriver ldriver;

	public Portal_Page(WebDriver rdriver)
	{
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(xpath="//tr[3]//td[1]//div[1]//label[1]//span[1]")
	WebElement alpha_org_radio_button;
	
	@FindBy(xpath="//span[contains(text(),'Modify')]")
	WebElement modify_button;
	
	@FindBy(xpath="//span[contains(text(),'Employees')]")
	WebElement employee_tab;
	
	@FindBy(xpath="//span[contains(text(),'Add Employee')]")
	WebElement add_employee_button;
	
	@FindBy(id="efname")
	WebElement first_name_text_field;
	
	@FindBy(id="elname")
	WebElement Last_Name;
	
	@FindBy(id="emnumber")
	WebElement mobileNumber;
	
	@FindBy(id="sourceType")
	WebElement Source_Type_Dropdown;
	
	@FindBy(id="//option[contains(text(),'GPS')]")
	WebElement GPS_source_type;
	
	@FindBy(xpath="//span[contains(text(),'Save')]")
	WebElement save_button;
	
	
	
	
	
	public void select_alpha_org()
	{
		alpha_org_radio_button.click();
	}
	
	public void click_on_modify_button()
	{
		modify_button.click();
	}
	
	public void click_on_employee_tab()
	{
		employee_tab.click();
	}
	
	public void click_on_add_employee_button()
	{
		add_employee_button.click();
	}
	
	public void enter_first_name(String first_name)
	{
		first_name_text_field.sendKeys(first_name);
	}
	
	public void enter_last_name(String last_name)
	{
		Last_Name.sendKeys(last_name);
	}
	
	public void enter_mobile_number(String mobile_number)
	{
		mobileNumber.sendKeys(mobile_number);
	}
	
	public void click_on_source_type_dropdown()
	{
		Source_Type_Dropdown.click();
	}
	
	public void select_gps_source_type()
	{
		GPS_source_type.click();
	}
	
	public void click_on_save_button()
	{
		save_button.click();
	}
	
}
