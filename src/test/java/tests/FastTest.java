package tests;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import helpers.Helpers;
import junit.framework.Assert;
import pages.LoginPage;
import pages.LogonPage;
import pages.ReservationPage;

public class FastTest {

	private WebDriver driver;
	private static final String TIPO_DRIVER = "webdriver.chrome.driver";
	private static final String PATH_DRIVER = "drivers/chromedriver.exe";
	private String URL = "https://demo.guru99.com/test/newtours/";
	
	
	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("INICIO DE TESTS");
		System.setProperty(TIPO_DRIVER,PATH_DRIVER);
	}
	
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
	}

	@Test
	public void pruebaLoginIncorrecto() {
		LoginPage Login = new LoginPage(driver);
		Login.iniciarSesion("pepito", "lopez");
		assertTrue(Login.getMensajeError().equalsIgnoreCase("Enter your userName and password correct"));
	}
	
    @Test
	public void pruebaLoginCorrecto() {
		LoginPage Login = new LoginPage(driver);
		LogonPage Logon = new LogonPage(driver);
		Login.iniciarSesion("mercury", "mercury");
		assertTrue(Logon.getMensajeSuccess().equalsIgnoreCase("Login Successfully"));
	}
	

	@Test
	public void pruebaReservation() {
		LogonPage Logon = new LogonPage(driver);
		ReservationPage reservationPage = new ReservationPage(driver);
		Logon.goToReservation();
		reservationPage.selectPassegers(2);
		reservationPage.selectFromPort(3);
		reservationPage.selectToPort("London");
	}
	
	
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("FINALIZA LOS TESTS");
	}

	
}
