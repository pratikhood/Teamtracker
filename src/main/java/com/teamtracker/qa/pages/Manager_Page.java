package com.teamtracker.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Manager_Page
{
	WebDriver ldriver;

	public Manager_Page(WebDriver rdriver)
	{
		ldriver=rdriver;

		PageFactory.initElements(rdriver, this);
	}


	@FindBy(xpath="//input[@value='Add']")
	WebElement Add_Button;
	
	@FindBy(id="name")
	WebElement manager_name;
	
	@FindBy(id="mobileNumber")
	WebElement manager_number;
	
	@FindBy(id="email")
	WebElement manager_email;
	
	@FindBy(id="bpid")
	WebElement manager_employee_id;
	
	@FindBy(id="username")
	WebElement manager_username;
	
	@FindBy(id="check-username-availability")
	WebElement check_availability;
	
	@FindBy(id="selectZoneDropdownTreeBtn")
	WebElement select_org_unit_dropdown;
	
	@FindBy(xpath="//a[@id='5acfcdf0-f5ab-468a-8fda-17f618530087_anchor']//i[@class='jstree-icon jstree-checkbox']")
	WebElement checkbox_LG_Maharashtra;
	
	@FindBy(id="addManagerBtn")
	WebElement save_button;
	
	
	
	
	public void click_on_add_button()
	{
		Add_Button.click();
	}
	
	public void enter_manager_name(String name)
	{
		manager_name.sendKeys(name);
	}
	
	public void enter_manager_number(String num)
	{
		manager_number.sendKeys(num);
	}
	
	public void enter_manager_email(String email)
	{
		manager_email.sendKeys(email);
	}
	
	public void enter_manager_employee_id(String empid)
	{
		manager_employee_id.sendKeys(empid);
	}
	
	public void enter_manager_username(String uname)
	{
		manager_username.sendKeys(uname);
	}
	
	public void check_availability_of_username()
	{
		check_availability.click();
	}
	
	public void click_on_select_org_unit_dropdown()
	{
		select_org_unit_dropdown.click();
	}
	
	public void click_on_checkbox_LG_Maharashtra_from_org_unit_dropdown()
	{
		checkbox_LG_Maharashtra.click();
	}
	
	public void click_on_save_button()
	{
		save_button.click();
	}


	

}
