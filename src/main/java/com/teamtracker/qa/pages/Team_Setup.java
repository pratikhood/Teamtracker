package com.teamtracker.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Team_Setup 
{
	WebDriver ldriver;

	public Team_Setup(WebDriver rdriver)
	{
		ldriver=rdriver;

		PageFactory.initElements(rdriver, this);
	}


	
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement search_box;
	
	
	public void enter_Suresh_Chavhan_in_search_box(String name)
	{
		search_box.sendKeys(name);
	}
	
}
