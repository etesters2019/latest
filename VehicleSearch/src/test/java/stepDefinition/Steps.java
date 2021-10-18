package stepDefinition;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.Car_Page;
import pageObject.Car_ResultPage;


public class Steps extends BaseClass {

	@Before
	public void setup() throws IOException
	{
		logger = Logger.getLogger("Demo");
		PropertyConfigurator.configure("log4j.properties");

		configProp = new Properties();
		FileInputStream configPropFile = new FileInputStream("config.properties");
		configProp.load(configPropFile);

		String br= configProp.getProperty("browser");

		if(br.equals("chrome"))
		{

			System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
			driver = new ChromeDriver();
			driver.manage().window().maximize();

		}

		else if (br.equals("firefox"))
		{	
			System.setProperty("webdriver.gecko.driver", configProp.getProperty("firefoxpath"));
			driver = new FirefoxDriver();
			driver.manage().window().maximize();

		}
		else if (br.equals("IE"))
		{	
			System.setProperty("webdriver.ie.driver", configProp.getProperty("IEpath"));
			driver = new InternetExplorerDriver();

			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability("ignoreZoomSetting", true);
			driver.manage().window().maximize();

		}


		logger.info("Launching browser");

	}
	
//	
//	@After (order=1)
//	public void takesScreenshotOnFailure() {
//		
//		
//	}
	@After (order=0)
	public void tearDown() {
		
		//driver.close();
	}



	@Given("user enters URL {string}")
	public void user_enters_URL(String url) {
		car = new Car_Page(driver);
		driver.get(url);
		logger.info("Entering URL");
	}




	@When("I check each registration number on the website")
	public void i_check_each_registration_number_on_the_website() throws IOException  {
		car = new Car_Page(driver);

		// Picking information from input file

		bre = new BufferedReader(new FileReader("C:\\Users\\Olu\\eclipse-workspace\\vehicle_Identify_E2E\\car_input.txt"));

		while((line = bre.readLine()) != null)
		{

			String[] words = line.split(" ");

			for (String word : words) {
				if (word.equals(inputSearch))
				{
					car.enterRegistrationNumber(word);
					car.clickButton();



				}

			}

		}

	}

	@Then("actual value should correspond with output file")
	public void actual_value_should_correspond_with_output_file() throws IOException {
		result = new Car_ResultPage(driver);
		result.isDisplayed();
		result.getRegistration();
		result.getMake();
		result.getColor();
		result.getYear();

		assertEquals(inputSearch, result.getRegistration());

	}

	
	//Another example

	@Given("user enters	{string}")
	public void user_enters(String plate ) {


		car = new Car_Page(driver);
		car.enterRegistrationNumber(plate);
	}

	@When("user clicks search button")
	public void user_clicks_search_button() {
		car.clickButton();
	}

	@Then("apprropriate car details shoould be displayed")
	public void apprropriate_car_details_shoould_be_displayed() {

		result = new Car_ResultPage(driver);
		result.isDisplayed();
		result.getRegistration();
		result.getMake();
		result.getColor();
		result.getYear();

		
	}

	
	///failed test 
	
	@Given("user enter {string}")
	public void user_enter(String reg) {
		car = new Car_Page(driver);
		car.enterRegistrationNumber(reg);

	}


	@Then("matching details should be displayed")
	public void matching_details_should_be_displayed() {
		Assert.assertEquals(expectedTitle, driver.getTitle());
	



}
}
