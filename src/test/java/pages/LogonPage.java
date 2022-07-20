package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogonPage {

	private By txtMensajeSuccess;
	private By linkFlights;
	private WebDriver driver;
	
	public LogonPage(WebDriver driver) {
		this.driver = driver;
		txtMensajeSuccess = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/h3");
		linkFlights = By.xpath("/html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/a");
	}
	
	
	public String getMensajeSuccess() {
		return driver.findElement(txtMensajeSuccess).getText();
	}
	
	public void goToReservation() {
		driver.findElement(linkFlights).click();
	}
}
