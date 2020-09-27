package week2.day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafTapsDuplicateLead {

	public static void main(String[] args) throws InterruptedException {

		// To setup the driver
		WebDriverManager.chromedriver().setup();

		// Open the chrome browser
		ChromeDriver driver = new ChromeDriver();

		// Code to maximize the browser window
		driver.manage().window().maximize();

		// Code to open the URL
		driver.get("http://leaftaps.com/opentaps/control/main");

		// Identify and enter the username
		WebElement username = driver.findElementById("username");
		Thread.sleep(1000);
		username.sendKeys("demosalesmanager");

		// Enter the password
		Thread.sleep(1000);
		driver.findElementById("password").sendKeys("crmsfa");
		// password.sendKeys("crmsfa");

		// Click on the Login button
		Thread.sleep(1000);
		driver.findElementByClassName("decorativeSubmit").click();

		// Click on the CRM/SFA link
		Thread.sleep(1000);
		driver.findElementByPartialLinkText("SFA").click();

		// Click on the LEADS tab
		driver.findElementByLinkText("Leads").click();

		// Click Find leads
		driver.findElementByXPath("//a[text()='Find Leads']").click();

		// Click on Email
		driver.findElementByXPath("//span[text() = 'Email']").click();

		// Enter Email
		driver.findElementByXPath("//input[@name= 'emailAddress']").sendKeys("shs01@yopmail.com");

		// Click on Find leads
		driver.findElementByXPath("//button[text()= 'Find Leads']").click();

		Thread.sleep(1000);
		// Capture name of first resulting lead
		WebElement Name = driver
				.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/child::a");
		String leadName = Name.getText();
		System.out.println(leadName);

		// Click first resulting lead
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/child::a").click();

		// Click on Duplicate Lead
		driver.findElementByXPath("//a[text()='Duplicate Lead']").click();

		// Verify the title as Duplicate lead
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		
		// Click on Create Lead
		driver.findElementByXPath("//input[@class='smallSubmit']").click();

		// Confirm if the duplicate name is same as captured name
		String DuplicateName = driver.findElementByXPath("//span[@id='viewLead_firstName_sp']").getText();
		System.out.println(DuplicateName);
		if (DuplicateName.equals(leadName)) {
			System.out.println("Name is same");
		} 
		else 
		{
			System.out.println("Two names are different");
		}
		
		// Close the browser
		driver.close();
	}

}
