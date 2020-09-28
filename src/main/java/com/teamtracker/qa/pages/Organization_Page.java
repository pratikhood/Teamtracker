package com.teamtracker.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organization_Page 
{
	WebDriver ldriver;

	public Organization_Page(WebDriver rdriver)
	{
		ldriver=rdriver;

		PageFactory.initElements(rdriver, this);
	}


	@FindBy(xpath="//a[contains(text(),'Settings')]")
	WebElement setting_menu;
	
	@FindBy(id="addCustomField-button-tab")
	WebElement plus_button;
	
	@FindBy(id="hierarchy-name")
	WebElement hierarchy_name_text_field;
	
	@FindBy(id="addHierarchy")
	WebElement add_button;
	
	@FindBy(id="hierarchy-name-f28a74f5-fa8d-4699-ae09-fc8e6d74353a")
	WebElement level_2;
	
	//

	
	public void click_on_setting_menu()
	{
		setting_menu.click();
	}
	
	public void click_on_plus_button()
	{
		plus_button.click();
	}
	
	public void enter_hierarchy_name(String hierarchy_name)
	{
		hierarchy_name_text_field.sendKeys(hierarchy_name);
	}
	
	public void click_on_add_button()
	{
		add_button.click();
	}
	
	public String capture_level_2_Name()
	{
		String level2_name = level_2.getText();
		return level2_name;
	}
}
