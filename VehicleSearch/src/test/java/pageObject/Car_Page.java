package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class Car_Page {
	
	WaitHelper waithelper;
	
	WebDriver driver;
	
	
	@FindBy(id = "vrm-input")
    WebElement no_Plate_Field;

    @FindBy(xpath = " //button[contains(text(),'Free Car Check')]")
    WebElement button;
    
    public Car_Page(WebDriver ldriver) {
    	
    	PageFactory.initElements(ldriver,this);
    	
    	this.driver=ldriver;
    	waithelper = new WaitHelper (driver);
  
    }
    
    public void enterRegistrationNumber(String reg){
    	no_Plate_Field.sendKeys(reg);
    }

    public String getRegistrationNumber() {
        return no_Plate_Field.getAttribute("value");
    }

    
    
    public void clickButton() {
    	waithelper.WaitForElement(button, 3000);
    	button.click();
    }
    
    public void entersRegFailed()
    
    {
    	
    	
    }
}
