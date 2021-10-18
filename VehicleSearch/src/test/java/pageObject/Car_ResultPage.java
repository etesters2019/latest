package pageObject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;



public class Car_ResultPage {
	
	WaitHelper waithelper;
	WebDriver driver;
	
	
	@FindBy(xpath = "//dt[text()='Registration']/ancestor::dl/dd")
    WebElement registration;

    @FindBy(xpath = "//dt[text()='Make']/ancestor::dl/dd")
    WebElement make;

    @FindBy(xpath = "//dt[text()='Model']/ancestor::dl/dd")
    WebElement model;

    @FindBy(xpath = "//dt[text()='Colour']/ancestor::dl/dd")
    WebElement colour;

    @FindBy(xpath = "//dt[text()='Year']/ancestor::dl/dd")
    WebElement year;
    
    @FindBy(xpath = "//*[contains(text(),'Vehicle Not Found')]")
    WebElement not_found;
    
    @FindBy(xpath = "//*[contains(text(),'Try Again')]")
    WebElement alert_alt;
    
    @FindBy(xpath = "//*[contains(text(),'Try Again')]")
    WebElement alert_;
    
    @FindBy(xpath = " //button[contains(text(),'Free Car Check')]")
    WebElement button;
    
   
    
  
  public Car_ResultPage(WebDriver ldriver) {
    	
	  PageFactory.initElements(ldriver,this);

		this.driver=ldriver;
		waithelper = new WaitHelper (driver);
		
		
}

  public boolean isDisplayed() {
  
	  waithelper.WaitForElement(registration, 3000);
      return registration.isDisplayed();
  }

  public String getRegistration() {
      return registration.getText();
  }

  public String getMake() {
      return make.getText();
  }

  public String getModel() {
      return model.getText();
  }

  public String getColor() {
      return colour.getText();
  }

  public String getYear() {
      return year.getText();
  }
  
  public String vehicleNotFound() {
      return not_found.getText();
  }
  
 
}

