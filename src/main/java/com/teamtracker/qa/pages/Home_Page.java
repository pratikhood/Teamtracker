package com.teamtracker.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page 
{
	WebDriver ldriver;

	public Home_Page(WebDriver rdriver)
	{
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Organization Setup')]")
	WebElement oranization_setup_menu;
	
	@FindBy(xpath="//span[contains(text(),'Admin')]")
	WebElement Admin_Menu;
	
	@FindBy(xpath="//a[contains(text(),'Manager')]")
	WebElement Manager_Menu;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement Task_Menu;
	
	@FindBy(xpath="//a[contains(text(),'Team Setup')]")
	WebElement Team_Setup;
	
	@FindBy(xpath="//a[contains(text(),'Forms')]")
	WebElement Form_Menu;
	
	@FindBy(xpath="//span[contains(text(),'POI')]")
	WebElement POI_Menu;
	
	
	public void click_on_oranization_setup_menu()
	{
		oranization_setup_menu.click();
	}
	
	
	public void click_on_POI_menu()
	{
		POI_Menu.click();
	}
	
	
	public void click_on_form_menu()
	{
		Form_Menu.click();
	}
	
	public void click_on_team_setup()
	{
		Team_Setup.click();
	}
	
	public void click_on_task_menu()
	{
		Task_Menu.click();
	}
	
	
	
	
	public void click_on_admin_menu()
	{
		Admin_Menu.click();
	}
	
	public void click_on_manager_menu()
	{
		Manager_Menu.click();
	}
	
	
	
	
	

}
