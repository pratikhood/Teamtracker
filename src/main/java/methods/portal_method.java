package methods;



import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.teamtracker.qa.base.PortalBaseClass;
import com.teamtracker.qa.pages.LoginPage;


public class portal_method extends PortalBaseClass
{

	public void portal_login()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		String username = readConfig.getPortalUsername();
		String password = readConfig.getPortalPassword();


		
		
		LoginPage lp = new LoginPage(driver);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		
		lp.enter_portal_username_in_username_field(username);

		lp.enter_portal_password_in_password_field(password);

		lp.click_on_portal_login_button();
	}
}

