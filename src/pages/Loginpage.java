package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import test.Logintest;

public class Loginpage {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	
	//========Webelement=======
	
	@FindBy(linkText="Log in")
    WebElement LoginLink;
   
    @FindBy(name="user_login")
    WebElement UserName;
   
    @FindBy(id="password")
    WebElement Password;
   
    @FindBy(className="rememberMe")
    WebElement Rememberme;
   
    @FindBy(name="btn_login")
    WebElement Login;
   
    @FindBy(id="msg_box")
    WebElement Error;
	
	
	
	
	//==========Costructor==========
	public Loginpage (){
		driver = Logintest.driver;
		report = Logintest.report;
		test = Logintest.test;
		
		PageFactory.initElements(driver, this);
		
	}
			
	
	//=============Methods===========
	public void login(String uname, String pass) {


	test = report.startTest("Login Test Case");
	//WebElement LoginLink =driver.findElement(By.linkText("Log in"));

	LoginLink.click();
	test.log(LogStatus.PASS, "Successfully clicked on the Login");
	//WebElement UserName = driver.findElement(By.name("user_login"));
	WebDriverWait wait= new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.elementToBeClickable(UserName));


	UserName.sendKeys(uname);
	test.log(LogStatus.PASS, "Successfully entered the user name");
	//WebElement Password = driver.findElement(By.id("password"));
	Password.sendKeys(pass);
	test.log(LogStatus.PASS, "Successfully entered the password");
	
	//WebElement Rememberme = driver.findElement(By.className("rememberMe"));
	Rememberme.click();
	//WebElement Login = driver.findElement(By.name("btn_login"));
	Login.click();
	test.log(LogStatus.PASS, "Successfully clicked on the Login link");
	//WebElement Error= driver.findElement(By.id("msg_box"));
	String ActMsg= Error.getText();
	String ExpMsg="The email or password you have entered is invalid.";

	Assert.assertTrue(Error.isDisplayed());

	Assert.assertEquals(ActMsg, ExpMsg);
	
}
}
