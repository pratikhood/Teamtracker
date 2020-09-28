package methods;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.teamtracker.qa.base.BaseClass;
import com.teamtracker.qa.pages.LoginPage;


public class methods extends BaseClass
{
	WebDriverWait wait = new WebDriverWait(driver, 30);
	
	public void login()
	{
		

		String username = readConfig.getUsername();
		String password = readConfig.getPassword();


		LoginPage lp = new LoginPage(driver);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user")));

		lp.enter_username_in_username_field(username);

		lp.enter_password_in_password_field(password);
		
		

		lp.click_on_login_button();

	}
}

