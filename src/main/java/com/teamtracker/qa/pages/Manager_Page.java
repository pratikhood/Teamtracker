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
	
	@FindBy(id="modifyButton")
	WebElement modify_button;
	
	@FindBy(xpath="//a[@id='06f02c3c-77e4-426e-ba61-d9c84c254384_anchor']//i[@class='jstree-icon jstree-checkbox']")
	WebElement alpha_org;
	
	@FindBy(id="modifyManagerBtn")
	WebElement save_button_modify;
	
	@FindBy(id="deleteButton")
	WebElement delete_button;
	
	@FindBy(xpath="//button[@class='confirm']")
	WebElement confirmation_on_delete_action;
	
	@FindBy(xpath="//span[contains(@class,'btn-theme-group')]//input[1]")
	WebElement import_button;
	
	@FindBy(xpath="//span[@class='buttonText']")
	WebElement choose_file_button;
	
	
	@FindBy(xpath="//div[4]//input[1]")
	WebElement upload_button;
	
	
	
	
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
	
	public void clear_manager_name()
	{
		manager_name.clear();
	}
	
	public void enter_modified_manager_name(String modified_name)
	{
		manager_name.sendKeys(modified_name);
	}
	
	public void click_on_modify_button()
	{
		modify_button.click();
	}
	
	public void select_alpha_org()
	{
		alpha_org.click();
	}
	
	public void click_on_save_button_while_modify()
	{
		save_button_modify.click();
	}
	
	public void click_on_delete_button()
	{
		delete_button.click();
	}
	
	public void click_on_OK_button()
	{
		confirmation_on_delete_action.click();
	}
	public void click_on_import_button()
	{
		import_button.click();
	}
	
	public void click_on_choose_file_button()
	{
		choose_file_button.click();
	}
	
	public void click_on_upload_button()
	{
		upload_button.click();
	}
	
	
}
