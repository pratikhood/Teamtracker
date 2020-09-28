package com.teamtracker.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page 
{
	WebDriver ldriver;

	public Login_Page(WebDriver rdriver)
	{
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(id="user")
	WebElement username_field;
	
	@FindBy(id="password")
	WebElement password_field;
	
	@FindBy(xpath="//button[@class='btn btn-block btn-info-custom margin-top-04']")
	WebElement login_button;
	
	public void enter_username(String usr)
	{
		username_field.sendKeys(usr);
	}
	
	
	public void enter_password(String pwd)
	{
		password_field.sendKeys(pwd);;
	}
	
	public void click_on_login_button()
	{
		login_button.click();
	}
	

}
