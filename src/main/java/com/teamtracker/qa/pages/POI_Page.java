package com.teamtracker.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POI_Page 
{
	WebDriver ldriver;

	public POI_Page(WebDriver rdriver)
	{
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(id="add-poi-name")
	WebElement POI_name_field ;
	
	@FindBy(id="add-poi-address")
	WebElement POI_address_field;
	
	@FindBy(xpath="//button[@class='btn-select']")
	WebElement category_dropdown ;
	
	@FindBy(id="add-poi-status")
	WebElement status_dropdown;
	
	@FindBy(id="add-poi-btn")
	WebElement add_button;
	
	@FindBy(xpath="//ul[@class='image-select-ul vertical-scroll']//span[contains(text(),'Airport')]")
	WebElement Airport_poi;
	
	@FindBy(id="modify-poi-btn")
	WebElement modify_button;
	
	@FindBy(xpath="//button[@class='confirm']")
	WebElement ok_button;
	
	@FindBy(xpath="//input[@id='import-poi']")
	WebElement import_button;
	
	@FindBy(xpath="//label[contains(@class,'btn btn-default')]")
	WebElement choose_file_button;
	
	@FindBy(xpath="//div[4]//input[1]")
	WebElement upload_button;
	
	public void enter_poi_name(String poi_name)
	{
		POI_name_field.sendKeys(poi_name);
	}
	
	public void enter_poi_addr(String poi_addr)
	{
		POI_address_field.sendKeys(poi_addr);
	}
	
	public void click_on_POI_category()
	{
		category_dropdown.click();
	}
	
	public void select_Airport_from_POI_category()
	{
		category_dropdown.click();
	}
	
	
	public void click_on_status_dropdown()
	{
		status_dropdown.click();
	}
	
	public void Select_Active_from_status_dropdown()
	{
		status_dropdown.click();
	}
	
	
	public void click_on_add_button()
	{
		add_button.click();
	}
	
	public void clear_name_field()
	{
		POI_name_field.clear();
	}
	
	public void click_on_modify_button()
	{
		modify_button.click();
	}
	
	public void click_on_OK_button()
	{
		ok_button.click();
	}
	
	public void click_on_Import_button()
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
