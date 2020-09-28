package com.teamtracker.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Form_Page 
{
	
	
	WebDriver ldriver;

	public Form_Page(WebDriver rdriver)
	{
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//button[@id='addNewForm']")
	WebElement add_form_button;
	
	@FindBy(id="formName")
	WebElement form_name_text_field;
	
	@FindBy(xpath="//div[@class='row']//span[@class='placeholder'][contains(text(),'Select Organization Unit')]")
	WebElement select_org_unit_dropdown;
	
	@FindBy(xpath="//label[contains(text(),'Select all')]")
	WebElement select_all_option;
	
	@FindBy(xpath="//li[@class='icon-number input-control input-control-12 ui-sortable-handle']")
	WebElement number_option;
	
	@FindBy(xpath="//span[contains(text(),'Text Field')]")
	WebElement text_field_option;
	
	@FindBy(id="getData")
	WebElement next_button;
	
	@FindBy(id="saveBtn")
	WebElement save_button;
	
	
	
	public void click_on_add_form_button()
	{
		add_form_button.click();
	}
	
	public void enter_form_name(String formName)
	{
		form_name_text_field.sendKeys(formName);
	}
	
	public void click_on_select_org_unit_dropdown()
	{
		select_org_unit_dropdown.click();
	}
	
	public void check_select_all_option()
	{
		select_all_option.click();
	}
	public void select_number_option()
	{
		number_option.click();
	}
	
	public void select_text_field_option()
	{
		text_field_option.click();
	}
	
	public void click_on_next_button()
	{
		next_button.click();
	}
	
	public void click_on_save_button()
	{
		save_button.click();
	}
	
	
	

}
