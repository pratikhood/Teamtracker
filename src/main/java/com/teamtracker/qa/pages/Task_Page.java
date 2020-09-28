package com.teamtracker.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Task_Page 
{
	
	WebDriver ldriver;

	public Task_Page(WebDriver rdriver)
	{
		ldriver=rdriver;

		PageFactory.initElements(rdriver, this);
	}


	
	
	@FindBy(id="taskOptions-add")
	WebElement Add_Button;
	
	@FindBy(id="order-desc")
	WebElement title;
	
	@FindBy(xpath="//div[@class='dropdown-chose-list']//input[@placeholder='Search']")
	WebElement Assing_to_dropdown;
	
	@FindBy(xpath="//li[contains(text(),'Pratik Hood (1196)')]")
	WebElement Pratik_Hood_from_Assign_to_dropdown;
	
	@FindBy(id="clientServiceOrderId")
	WebElement Task_ID;
	
	@FindBy(id="address")
	WebElement Task_Address;
	
	@FindBy(id="taskLatitude")
	WebElement Latitude;
	
	@FindBy(id="taskLongitude")
	WebElement Longitude;
	
	@FindBy(id="taskAddBtn")
	WebElement save_button;
	
	@FindBy(xpath="//textarea[@id='description']")
	WebElement description_field;
	
	@FindBy(id="taskUpdateBtn")
	WebElement update_button;
	
	@FindBy(xpath="//button[@class='confirm']")
	WebElement ok_button;
	
	@FindBy(id="taskOptions-Import")
	WebElement import_button;
	
	@FindBy(xpath="//span[@class='buttonText']")
	WebElement choose_file_button;
	
	@FindBy(xpath="//div[@id='formImportBox']//div[4]//input[1]")
	WebElement upload_button;
	
	
	
	
	public void click_on_add_button()
	{
		Add_Button.click();
	}
	
	public void enter_title(String title_name)
	{
		title.sendKeys(title_name);
	}
	
	public void click_on_assign_to_dropdown ()
	{
		Assing_to_dropdown.click();
	}
	
	
	public void select_pratik_hood_from_assing_to_dropdown ()
	{
		Pratik_Hood_from_Assign_to_dropdown.click();
	}
	
	
	public void enter_task_id(String task_id)
	{
		Task_ID.sendKeys(task_id);
	}
	
	public void enter_address(String Task_address)
	{
		Task_Address.sendKeys(Task_address);
	}
	
	
	public void enter_latitude(String latitude)
	{
		Latitude.sendKeys(latitude);
	}
	
	
	public void enter_longitude(String longitude)
	{
		Longitude.sendKeys(longitude);
	}
	
	
	public void click_on_save_button()
	{
		save_button.click();
	}
	
	public void enter_description(String desc)
	{
		description_field.sendKeys(desc);
	}
	
	public void clear_description()
	{
		description_field.clear();
	}
	
	public void enter_modified_description(String mod_desc)
	{
		description_field.sendKeys (mod_desc);
	}
	
	public void click_on_update_button()
	{
		update_button.click();
	}
	
	
	public void click_on_OK_button()
	{
		ok_button.click();
	}
	
	public void click_on_Import_button()
	{
		import_button.click();
	}
	
	public void click_on_choose_file_button ()
	{
		choose_file_button.click();
	}
	
	public void click_on_upload_button ()
	{
		upload_button.click();
	}
	
	
}
