package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helpers.Helpers;

public class LoginPage {

	private By txtUser;
	private By txtPass;
	private By btnLogin;

	private By txtMensajeError;

	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		txtUser = By.name("userName");
		txtPass = By.name("password");
		btnLogin = By.name("submit");
		txtMensajeError = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[3]/td[2]/span");
	}
	
	public void iniciarSesion(String user, String pass) {
		driver.findElement(txtUser).sendKeys(user);
		driver.findElement(txtPass).sendKeys(pass);
		driver.findElement(btnLogin).click();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
/*		Helpers helper = new Helpers();
		helper.sleepSeconds(4);
*/	}
	
	public String getMensajeError() {
		return driver.findElement(txtMensajeError).getText();
	}
	


}
