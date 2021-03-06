package com.teamtracker.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	WebDriver ldriver;

	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="user")
	WebElement username_field;
	
	@FindBy(name="userPassword")
	WebElement password_field;
	
	@FindBy(xpath="//button[@class='btn btn-block btn-info-custom margin-top-04']")
	WebElement login_Button;
	
	@FindBy(id="username")
	WebElement portal_username_field;
	
	@FindBy(name="password")
	WebElement portal_password_field;
	
	@FindBy(xpath="//button[@class='btn btn-block btn-login mt-lg']")
	WebElement portal_login_Button;
	
	public void enter_username_in_username_field(String uname)
	{
		username_field.sendKeys(uname);
	}
	
	public void enter_password_in_password_field(String pwd)
	{
		password_field.sendKeys(pwd);
	}
	
	public void click_on_login_button()
	{
		login_Button.click();
	}
	public void enter_portal_username_in_username_field(String uname)
	{
		portal_username_field.sendKeys(uname);
	}
	
	public void enter_portal_password_in_password_field(String pwd)
	{
		portal_password_field.sendKeys(pwd);
	}
	
	public void click_on_portal_login_button()
	{
		portal_login_Button.click();
	}
	
}
