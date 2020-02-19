package methods;


import com.teamtracker.qa.base.BaseClass;
import com.teamtracker.qa.pages.LoginPage;


public class methods extends BaseClass
{

	public void login()
	{

		String username = readConfig.getUsername();
		String password = readConfig.getPassword();


		LoginPage lp = new LoginPage(driver);

		lp.enter_username_in_username_field(username);

		lp.enter_password_in_password_field(password);

		lp.click_on_login_button();

	}
}

