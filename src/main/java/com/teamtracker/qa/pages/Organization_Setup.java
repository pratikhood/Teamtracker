package com.teamtracker.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organization_Setup 
{
	
	WebDriver ldriver;

	public Organization_Setup(WebDriver rdriver)
	{
		ldriver=rdriver;

		PageFactory.initElements(rdriver, this);
	}
	
	
	
	@FindBy(id="addDepartmentCentre")
	WebElement organization_setup_Add_Button;
	
	@FindBy(id="centerId")
	WebElement organization_unit_id;
	
	@FindBy(id="centerName")
	WebElement organization_unit_name;
	
	@FindBy(id="address")
	WebElement organization_unit_address;
	
	@FindBy(id="mapLat")
	WebElement organization_unit_latitude;
	
	@FindBy(id="maplong")
	WebElement organization_unit_longitude;
	
	@FindBy(id="saveServiceCenterBtn")
	WebElement organization_unit_save_button;
	
	@FindBy(xpath="//span[contains(text(),'Select value')]")
	WebElement organization_unit_type_dropdown;
	
	@FindBy(xpath="//div[@id='department-list-div']//div//button[contains(@class,'ms-choice')]//div")
	WebElement parent_organization_unit_dropdown;
	
	@FindBy(xpath="//label[contains(text(),'State(state)')]//input[@name='selectItemdepartment-groups']")
	WebElement select_state_from_organization_unit_type_dropdown;
	
	@FindBy(xpath="//label[contains(text(),'Alpha Org(alpha_org)')]")
	WebElement select_alpha_org_from_parent_organization_unit_type_dropdown;
	
	@FindBy(id="taskPerEngineer")
	WebElement minimum_task_per_team_member;
	
	
	@FindBy(xpath="/html/body/div[19]/div[7]/div/button")
	WebElement Yes_button_of_delete_confirmation_popUp;
	
	@FindBy(id="organizationStructureImportBtn")
	WebElement import_button;
	
	
	@FindBy(xpath="//form[@id='organizationStructureImport']//span[@class='icon-span-filestyle glyphicon glyphicon-folder-open']")
	WebElement choose_file_button;
	
	
	@FindBy(xpath="//form[@id='organizationStructureImport']//button[contains(@class,'btn-info')][contains(text(),'Upload')]")
	WebElement upload_button;
	
	@FindBy(xpath="//button[@class='confirm']")
	WebElement OK_button;
	
	
	
	
	
	
	
	public void click_on_add_button()
	{
		organization_setup_Add_Button.click();
	}
	
	public void enter_organization_unit_id(String id)
	{
		organization_unit_id.sendKeys(id);
	}
	
	public void enter_organization_unit_name(String name)
	{
		organization_unit_name.sendKeys(name);
	}
	
	public void enter_organization_unit_address(String addr)
	{
		organization_unit_address.sendKeys(addr);
	}
	
	public void enter_organization_unit_latitude(String lat)
	{
		organization_unit_latitude.sendKeys(lat);
	}
	
	public void enter_organization_unit_longitude(String lon)
	{
		organization_unit_longitude.sendKeys(lon);
	}
	
	public void click_on_organization_unit_type_dropdown()
	{
		organization_unit_type_dropdown.click();
	}
	
	public void select_state_from_organization_unit_type_dropdown()
	{
		select_state_from_organization_unit_type_dropdown.click();
	}
	
	public void click_on_parent_organization_unit_type_dropdown()
	{
		parent_organization_unit_dropdown.click();
	}
	
	public void select_Alpha_Org_from_organization_unit_type_dropdown()
	{
		select_alpha_org_from_parent_organization_unit_type_dropdown.click();
	}
	
	public void enter_minimum_task_per_team_member(String minimumTask)
	{
		minimum_task_per_team_member.sendKeys(minimumTask);
	}
	
	public void click_on_save_button()
	{
		organization_unit_save_button.click();
	}
	
	public void clear_minimum_task_per_team_member()
	{
		minimum_task_per_team_member.clear();
	}
	
	public void enter_modified_minimum_task_per_team_member(String modifiedValue)
	{
		minimum_task_per_team_member.sendKeys(modifiedValue);
	}
	
	
	public void click_on_YES_button_confirm_button()
	{
		Yes_button_of_delete_confirmation_popUp.click();
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
	
	public void clear_organization_unit_name()
	{
		organization_unit_name.clear();
	}
	
	public void enter_modified_organization_unit_name(String org_unit_name)
	{
		minimum_task_per_team_member.sendKeys(org_unit_name);
	}
	
	
	public void click_on_OK_button()
	{
		OK_button.click();
	}
	
}
