package pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReservationPage {
	
	private By passengerDrop;
	private WebDriver driver;
	private By titleTxt;
	private By fromDrop;
	private By toDrop;
	
	public ReservationPage(WebDriver driver) {
		this.driver = driver;
		passengerDrop = By.name("passCount");
		titleTxt = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/font");
		fromDrop = By.name("fromPort");
		toDrop = By.name("toPort");
	}
	
	public void assertPage() {
		assertTrue(driver.findElement(titleTxt).getText().equalsIgnoreCase("Use our Flight Finder to search"));
	}
	
	public void selectPassegers(int cant) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement cantidadPasajeros = wait.until(ExpectedConditions.presenceOfElementLocated(passengerDrop));
		Select selectPasajeros = new Select(cantidadPasajeros);
		selectPasajeros.selectByVisibleText(Integer.toString(cant));
	}
	
	public void selectFromPort(int index) {
		Select selectFrom = new Select(driver.findElement(fromDrop));
		selectFrom.selectByIndex(index);
	}
	
	public void selectToPort(String city) {
		Select selectTo = new Select(driver.findElement(toDrop));
		selectTo.selectByValue(city);
	}
	
	
}
